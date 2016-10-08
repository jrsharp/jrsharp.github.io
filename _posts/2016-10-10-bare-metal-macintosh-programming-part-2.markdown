---
layout: page
#
# Content
#
title: "Bare-metal Macintosh Programming - Part 2"
subheadline: "Building blocks for an OS?"
teaser: ""
categories: [retrocomputing]
tags: [tech,retrocomputing,mac,macintosh]
excerpt_separator: <!--more-->
---

_This second installment of my "bare-metal" Macintosh Programming effort moves
past the boot block limitations of my proof-of-concept demo and introduces 
some foundational building blocks necessary for doing something more useful 
than just painting pictures on the framebuffer._

<!--more-->

After getting a functional demo up and running, (see 
[part 1]({% post_url 2016-08-31-bare-metal-macintosh-programming-part-1 %}))
I began thinking of more useful solutions.  If I could implement a basic
terminal, I could use it to port a host of existing software and use it to
build a whole new operating environment:

 - Port Frotz z-code interpreter for Zork/Infocom games
 - Port pforth to create a Forth operating environment (Open Firmware for 68k Macs?) ;)
 - eLua?
 - FreeRTOS demo/shell
 - uCLinux?

At least initially, each of these would rely on the floppy, but eventually
these could run directly out of ROM, if unused ROM routines were removed and
especially if something like BMOW's 
[ROM-inator](http://www.bigmessowires.com/mac-rom-inator/) is used.

First things first, though... I need to get some text on this Mac.  At the end
of this next round of hacking, I managed to get this:

![Condensed Font Screenshot]({{ site.url }}/images/HappyJonCondensedFont.png)

Now on to the how...

### _A note on "bare metal"_

While my eventual goal _might_ be to replace the ROM entirely, I'm certainly
content to leverage the portions of the ROM that are particularly useful or
expeditious.  I'm not really interested in the GUI Toolbox functions, but the
disk driver is kinda nice.  My goal isn't to boycott Apple's fine code, but
simply to explore the possibilities of an alternative operating environment
for the Mac.  So, for the record, I'll be using at least one of those useful
ROM routines in this post...

# &gt; 1024 bytes

We left off at the end of part one needing to overcome the confines of the 
1024-byte boot block that the ROM startup code loads off of the floppy into
memory automatically for us.  In order to do _anything_ useful, we need to
use the ROM routines (floppy driver) to read the rest of our code from disk
into memory.  In this case, I only need to do this once, as I'm working with
a Mac Plus, that can hold a full 800K disk in RAM.  This saves us the trouble
of subsequent disk reads. (if at the expense of initial load time)

For this I am again borrowing from the 
[Emile project](http://www.gryphel.com/c/minivmac/) for its second-stage loader
code.  In the highlight below, we allocate enough memory to accommodate 
our floppy image and use the `PBReadSync` Toolbox routine to read the floppy 
data into the allocated RAM location and finally jump to it.

{% highlight asm %}

	...

	/* Set up Heap: */
start:
	moveal SysZone,%a0
	addal %pc@(SysHeapSize),%a0
	SetApplBase
	movel SysZone,TheZone

	/* buffer size to store second stage booter */

	get_second_size %d0

	/* Allocate Memory for second stage loader */

	add.l	#4, %d0
	NewPtr
	move.l	%a0, %d0
	bne	malloc_ok
	move.l	#1, %d0
	SysError
malloc_ok:
	add.l	#3, %d0
	and.l	#0xFFFFFFFC.l, %d0

	/* load second stage */

	load_second

	/* jump to code loaded from disk: */

	jmp	(%a0)

	...

{% endhighlight %}

## Relocatable code

The other thing to note about executing our code in memory is to ensure that it
is relocatable.  (this was also true for our first demo, but less significant 
given its size)  We want our compiler/linker to produce code that can be 
executed from any location in memory, now that we rely on `NewPtr` to set up 
our memory for us.

First, we want to be using PC-relative addressing wherever we can.  It appears
that gcc for m68k has evolved a fair bit through the years, leaving some gaps
in the documentation on some of these compiler + arch features.  It took some
trial and error and getting familiar with `m68k-elf-objdump`'s output
to arrive at the right combination of flags to produce code that didn't result
in jumps to invalid instructions:


```
m68k-elf-gcc -g -o demo demo.s chars.c -nostdlib -fomit-frame-pointer -mno-rtd -m68000 -msoft-float -mpcrel
m68k-elf-objcopy -O binary demo floppy.img
```

There are several things going on here, and I'm sure I can't explain them all
properly, but basically, I'm making sure that gcc is producing code that is
safe for a pure 68000 CPU (without FPU or MMU) and uses PC-relative addressing.

_It turns out this part was more complicated than it seemed at first, as gcc 
was producing absolute address jumps when linking to newlib.  I ended up
addressing this another way with a new linker script and memory allocation
method.  I will try to spend some time describing this in part 3._

# Output

Since I had already started on the output side with my framebuffer graphics 
demo, the next logical step was to begin thinking of ways to get text onto the 
Mac's screen.  One of the things I use my real Mac Plus for is a serial 
terminal using ZTerm, but even with the smallest available font, the maximum 
terminal size is smaller than I'd prefer.  So now that I have control over the 
complete display, (no system menu or windowing elements) I want to choose a 
condensed font that will make the most of the Mac's meager 512x342 resolution.

## A Condensed Font

After some searching, I came across 
[Christian Neukirchen](http://chneukirchen.org)'s 
[5x13 font](https://github.com/chneukirchen/5x13).  This font seemed like the 
right mix of efficient and readable.  It should yield an *effective terminal 
size of 102x26*, (512 / 5 = 102, 342 / 13 = 26) more than adequate for my 
needs.

I used [bdfe](https://github.com/achilikin/bdfe) to convert the .bdf font data 
into a C header file suitable for use with my gcc project.  bdfe generated each
printable ASCII character in order (through code 127), making it easy to map
ASCII codes to font data.  (bdfe exported the data as 5x16 arrays, and I simply 
ignore the last 3 lines of pixel data.)

## Character routine

In order to render the font data on screen, I began by adapting my previous
framebuffer memcopy loop for this font data and started working on the x/y
arithmetic for the "terminal".  The first version of this routine wrote
character data to the display at byte boundaries for simplicity, making for an
effective terminal size of only *64x26*. (512 / 8 = 64)  This meant my nice 
5x13 font had generous spacing.

![Hello World Screenshot]({{ site.url }}/images/HappyJonHelloWorld.png)

In order to condense this down, I needed some new arithmetic, bit-shifting and
logical or'ing tricks to get these characters to "share" bytes nicely.  Again,
the result is a 102x26 character terminal.  Here's a shot of that condensed 
terminal filled up with a pangram for illustration:

![Condensed Font Screenshot]({{ site.url }}/images/HappyJonCondensedFont.png)

The resulting `draw_char` routine is a fairly efficient (I'm sure it could be 
more so) bit of assembly that draws an ASCII character at a given X/Y location:

{% highlight asm %}

	...

/* draw_char: draws an ASCII char at x/y loc in framebuffer using 5x13 font:
 *
 *  params:
 * 	d0 - char value
 *	d1 - x value
 *	d2 - y value
 */

draw_char:
	movel	%d0, -(%sp)
	movel	%d7, -(%sp)
	movel	%d2, -(%sp)
	movel	%d1, -(%sp)
	movel	%a0, -(%sp)
	movel	%a1, -(%sp)
	movel	%d3, -(%sp)
	movel	%d4, -(%sp)
	movel	%d5, -(%sp)
	movel	%d6, -(%sp)

	movel	(ScrnBase), %a0
	mulsw	#(13 * 64), %d2

	movel	%d1, %d5
	mulsw	#5, %d5
	divuw	#8, %d5
	movew	%d5, %d6
	addal	%d6, %a0

	lsrl	#8, %d5
	lsrl	#8, %d5

	cmp	#0, %d5
	beq	even_stevens

even_stevens:
	addal	%d2, %a0

	sub	#32, %d0
	mulsw	#64, %d0

	/* Reset vars for image drawing: */
	lea	font_data(%pc), %a1 /* font data */
	addal	%d0, %a1 /* offset for font_data */

	movel	%d0, %d3

	movew	#13, %d1
fill_loop:

	movel	(%a1)+, %d0
	moveb	(%a0), %d7
	moveb	#0x80, %d2
	lsrb	%d5, %d0
	subb	#1, %d5
	asrb	%d5, %d2
	add	#1, %d5
	andb	%d2, %d7
	orb	%d7, %d0
	moveb	%d0, (%a0)+

	addal	#63, %a0	/* Move to next line */

check_dec:
	subi	#1, %d1
	bne	fill_loop

check_overflow:
	cmp	#3, %d5
	blt	draw_done
	movew	#8, %d4
	sub	%d5, %d4
	
	sub	#((13 * 64) - 1), %a0

	lea	font_data(%pc), %a1 /* font data */
	addal	%d3, %a1 /* offset for font_data */

	movew	#13, %d1
fill_loop2:

	movel	(%a1)+, %d0
	moveb	(%a0), %d7
	moveb	#1, %d2
	aslb	%d4, %d2
	lslb	%d4, %d0
	andb	%d2, %d7
	orb	%d7, %d0
	moveb	%d0, (%a0)+

	addal	#63, %a0	/* Move to next line */

check_dec2:
	subi	#1, %d1
	bne	fill_loop2

draw_done:

	movel	(%sp)+, %d6
	movel	(%sp)+, %d5
	movel	(%sp)+, %d4
	movel	(%sp)+, %d3
	movel	(%sp)+, %a1
	movel	(%sp)+, %a0
	movel	(%sp)+, %d1
	movel	(%sp)+, %d2
	movel	(%sp)+, %d7
	movel	(%sp)+, %d0

	rts

	...

{% endhighlight %}

## The Strings Section

What good is a `draw_char` without a `draw_string`?  The next obvious step was 
to implement a routine that would print a string to a given X/Y location using 
a pointer to a null-terminated string:

{% highlight asm %}

	...

/* draw_string: draws an ASCII char at x/y loc in framebuffer using 5x13 font:
 *
 *  params:
 *  a3 - pointer to string
 *	d1 - x value
 *	d2 - y value
 */

draw_string:

draw_str_loop:
	movew	(%a3)+, %d0
	cmp		#0, %d0
	bne		dsproceed
	rts
dsproceed:
	movel	%d2, -(%sp)
	movel	%d1, -(%sp)
	movel	%d0, -(%sp)

	jsr	draw_char
	movel	(%sp)+, %d0
	movel	(%sp)+, %d1
	movel	(%sp)+, %d2
	add.l	#1, %d1
	jmp		draw_str_loop

	...

{% endhighlight %}

# Next steps

Ok, so this seems like as good a place as any to pause and summarize.  This 
represents a fair amount of work (especially for someone that hadn't written
68k assembly before this project) and a necessary step towards my goal to do
really _anything_ useful.  In the next installment, I'll describe some of
the challenges in getting GCC to generate relocatable code, along with my
efforts to link these output routines to newlib's stubs for terminal output,
which allows us to use handy functions like `puts()`.

...so stay tuned for part 3:

 - GCC linker scripts and relocatable code
 - Mixing C and assembly (calling conventions!)
 - Newlib port/implementation
 - Keyboard input routine?

And in the meantime, please feel free to checkout out 
[the repository](https://github.com/jrsharp/HappyJon) and join in the fun. ;)
