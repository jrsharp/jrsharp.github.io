---
layout: page
#
# Content
#
title: "Bare-metal Macintosh Programming - Part 1"
subheadline: "Booting a Mac Plus without Mac OS"
teaser: ""
categories: [retrocomputing]
tags: [tech,retrocomputing,mac,macintosh]
excerpt_separator: <!--more-->
---

The original compact Macintoshes (128k, 512k, and Plus) have long been a 
subject of my collection and study, but after acquiring a Canon Cat, I began
to see the Mac in a slightly new light.  The original Macintosh may be a truly
unique blend of hardware and software engineering, but what if you looked at 
the Mac only for its hardware?

<!--more-->

If you know the Mac, you know that it was innovative in large part
because of its ROM.  The Toolbox functions of the ROM really made the Mac
what it was.  As a result, The MacOS (System) software is inextricably linked 
to the ROM code, and the two work together in a clever balance of pointers and 
patched code.  This cleverness and tight engineering allowed the Mac to do a 
lot with its relatively meager resources.

But what if you threw out the ROM and its Toolbox?  The Mac might start to look
not too different from other 68000-based personal computers of its time.  
What would you do if someone handed you a Macintosh with no available software? 
What if you were tasked with designing an operating system for this new (rather
limited) 68000-based box?  How would you start?  Would you attempt to emulate 
windowing systems from expensive contemporaries like the Lisa and Alto?  Would 
you take a simpler approach?  Maybe something more like the DOSes of the day?

And what about today?  What features would you include?  Maybe a nice, 
lightweight IP stack? ([lwIP](http://savannah.nongnu.org/projects/lwip/))  How
much could you squeeze into a replacement ROM?  I began to wonder what I could 
get my old Mac to do with the benefit of modern toolchains and open-source 
stacks and kernels.  Relying on all of the available documentation, the 
original Macintosh becomes a blank slate for our imagination.

This first article in my _bare-metal Macintosh programming series_ describes 
my first steps down this road.

## A proof-of-concept demo

In my search for information on the Macintosh boot process, I ran across 
[this Gist](https://gist.github.com/kmcallister/3236565ed7eb7b45cf99) that
outlines a method for booting arbitrary code on a 68k Macintosh -- that is,
_without_ Mac OS.  Bingo.  This was the starting point I needed to begin 
exploring my thoughts on alternative software/firmware for the Mac.

I decided my first step was to develop the simplest demo I could think of that would 
show off some of the Mac's hardware while compact enough to fit into the boot
sector (first 1K) of a floppy.  So I set out to build a simple
bare-metal Macintosh demo written in 68k assembly that displays my own smiling 
face on the machine's 1-bit framebuffer.

I targeted the Macintosh Plus for the extra RAM and becuase Mini vMac emulates
it by default, but the code should run fine on the 128k/512k as well, now that
I'm using the ROM vector to get the frambuffer start address.  The 68000 of 
these original Macintosh models makes them feel a lot like modern embedded 
systems.  And that's roughly the approach I've taken in thinking of the hardware
 -- working with it like a modern, MMU-less ARM microcontroller.

Here's the result:

![Screenshot]({{ site.url }}/images/HappyJon1.png)

_I'm smiling becuase it works ;)_

(I used [The Gimp](https://www.gimp.org/) to create my 1-bit bitmap code block)

And on to *how* it works...

## The Code

The code listing follows below. (missing only the full bitmap data)  The
necessary boot block header was borrowed from the 
[Emile project](http://www.gryphel.com/c/minivmac/) and is based on the 
Inside Macintosh documentation.

The startup code in the Macintosh ROM eventually loads the first 1024 bytes off
of the disk and this bootblock is then responsible for bootstrapping the OS.
(or other arbitrary code such as our framebuffer demo)

The code itself is rather simple, basic memory copy loops, responsible for
clearing the entire display (white) and copying the bitmap data onto the 
center of the screen.  You may notice that the Mac's characteristic rounded
corners are of course no longer visible.

At the end is an endless loop, producing a subtle animation effect.

{% highlight asm %}
# HappyJon Demo
#
# Produced using "68k Mac boot floppy example" template
#
# Boot block header based on first/first.S
# from http://emile.sourceforge.net/
#

# The ROM loads this many bytes from the start of the disk.
.equ stage1_size, 1024

# Define ScrnBase, location in memory containing the start of video memory
.equ ScrnBase, 0x0824

# Macro to define a Pascal string
.macro pString string
pstring_begin_\@:
        .byte   pstring_end_\@ - pstring_string_\@ - 1
pstring_string_\@:
        .string "\string"
pstring_end_\@:
        .fill 16 - (pstring_end_\@ - pstring_begin_\@) , 1, 0
.endm

begin:

ID:          .short  0x4C4B              /* boot blocks signature */
Entry:       bra     start               /* entry point to bootcode */
Version:     .short  0x4418              /* boot blocks version number */
PageFlags:   .short  0x00                /* used internally */
SysName:     pString "Face Demo     "    /* System filename */
ShellName:   pString "Face Demo     "    /* Finder filename */
Dbg1Name:    pString "Face Demo     "    /* debugger filename */
Dbg2Name:    pString "Face Demo     "    /* debugger filename */
ScreenName:  pString "Face Screen   "    /* name of startup screen */
HelloName:   pString "Face          "    /* name of startup program */
ScrapName:   pString "Scrap         "    /* name of system scrap file */
CntFCBs:     .short  10                  /* number of FCBs to allocate */
CntEvts:     .short  20                  /* number of event queue elements */
Heap128K:    .long   0x00004300          /* system heap size on 128K Mac */
Heap256K:    .long   0x00008000          /* used internally */
SysHeapSize: .long   0x00020000          /* system heap size on all machines */

start:
	/* movel	#0x3FA700, %a0 */ /* Start of framebuffer on 4MB Plus */
	movel	(ScrnBase), %a0

	/* clear screen */
	movel	#0x00000000, %d0
	movel	#5472, %d1
clear_loop:
	movel	%d0, (%a0)+
	subi	#1, %d1
	bne	clear_loop

	/* Reset vars for image drawing: */
	lea	buffer, %a1 /* Image data */
	movel	(ScrnBase), %a0
	addal	#7388, %a0 /* Offset to place 64x64 image in center of display */
	movew	#127, %d1
fill_loop:

	movel	(%a1)+, %d0
	movel	%d0, (%a0)+

	/* mod buffer count to find offset and shift memory */
	movel	%d1, %d3
	divuw	#2, %d3
	andil	#0xFFFF0000, %d3
	bne	check_dec

	addal	#56, %a0	/* Move to next line */

check_dec:
	subi	#1, %d1
	bne	fill_loop

	/* One more time! */
	movel	(%a1)+, %d0
	movel	%d0, (%a0)+

	/* Set up an animation / prog indicator: */
	addal	#56, %a0	/* Move to next line */
	movel 	%a0, %a1
	addal	#4, %a1
	movel	#0xFF000000, %d0
	movel	#0x000000FF, %d2

end_loop:
	movel	%d0, (%a0)
	movel	%d2, (%a1)
	rorl	#1, %d0
	roll	#1, %d2
	movel	#10000, %d1
delay_loop:
	nop
	subi	#1, %d1
	bne	delay_loop
	bra	end_loop
end:

buffer:
	dc.l 0b00000000000000000000000000100001
	dc.l 0b11111100000000000000000000000000
	dc.l 0b00000000000000000000000000000011
	dc.l 0b11111100000000000000000000000000
	dc.l 0b00000000000000000000000000111111
	dc.l 0b11111110000000000000000000000000
	dc.l 0b00000000000000000000000001110000
	dc.l 0b01111110000000000000000000000000
	dc.l 0b00000000000000000000000011110111

	...

{% endhighlight %}

## A modern toolchain

Since 68k still lives on, it is an architecture well-supported by GCC, allowing
us to use a familiar toolchain.  I've tested several 68k GCC toolchains built
using [crosstool-ng](http://crosstool-ng.org/), across several host platforms. 
(most recently using my venerable [chip](https://getchip.com/))  A quick way
to get started on Windows is to get a pre-built toolchain 
[here](http://gnutoolchains.com/).

A simple Makefile is responsible for producing the binary output that can be
placed directly onto a disk, or booted directly using an accurate Mac emulator
like [Mini vMac](http://www.gryphel.com/c/minivmac/):

 - `cd HappyJon`
 - `make`
 - `<vMac_path>/Mini\ vMac floppy.img`

## Clone, Build, and Fork

You can check out the code in my [HappyJon](https://github.com/jrsharp/HappyJon)
public repository.  Feel free to clone, build and fork my code.  Try it out on
your own vintage Mac. (instructions for creating a working floppy are in the 
README)  Fire up Mini vMac and see what interesting code you can squeeze into 
the boot block.  

I believe a mirror of the framebuffer memory block is available for 
double-buffering.  It would be fun to see what animations could be created.
Can we start a new Macintosh demoscene? ;)

## Boot sector and beyond

In Part 2, I will go into the next stage of my bare-metal Macintosh efforts,
where I begin to explore something more useful on my sans-MacOS Plus.  To do
anything meaningful I will need to break out of my 1024-byte boot block jail...
