---
layout: page
title: "Laptop Art"
permalink: "/projects/laptops/"
---

Some computers start out as works of art.  Others need a little help...

Pentium 133 Laptop
------------------

Another machine I inherited is a Toshiba Satellite Pro 440cdx.  It is a Pentium-133 with 16MB RAM.  I actually use two hard drives in the machine, swapping them depending on my OS mood.  I have Windows 95B installed on a 1.8GB HD (hardly ever use that one anymore) and Slackware Linux 8.1 installed on a 2Gig.  I use this laptop quite a bit for wireless connectivity and as this one has a good battery, it's much more useful than my laptop below.  My Slackware install is absolutely great after some tweaking.  I compiled "tinyx" or "KDrive" from the XFree86 source to squeeze some more performance out of my memory-starved machine.  The KDrive server is a "tiny" subset of the XFree86 full server.  It compiles into a single binary of about 800K.  I compiled the vesa KDrive server.  I noticed an immediate and considerable improvement in X performance.  It isn't easy to figure out how to compile and set it all up, but if your short on memory, it is well worth your time!

**(TinyX / KDrive):** As I said above, KDrive is not exactly easy to figure out how to build.  It's been some time since I performed the task, so I don't think I can really describe the process well, so here are the binaries I built for my Slackware 8.1 box:

 * [Xvesa](/files/Xvesa) - Server binary compiled for VESA support.
 * [Xchips](/files/Xchips) - Server binary compiled for Chips and Technologies chipsets.
 * *Extra:* [dillo](/files/dillo) - My Dillo binary for Slackware 8.1

I chose to paint something on my P133 that made it appear the laptop was cracking apart and electronic components were then exposed.  Here are some images of the laptop.  First, is the sketch I drew before I painted the laptop.

![440cdx Sketch #1][sketch1]
![440cdx Sketch #2][sketch2]
![440cdx Sketch #3][sketch3]
![440cdx Sketch #4][sketch4]

486/25 Laptop
-------------

I picked a 486 laptop up over Christmas 2001, and it's followed me many places now.  I recently went through quite a process to install Linux on the machine so the information at the bottom of this page is a bit outdated.  I have chosen to leave it up, however, for historical reasons and it may yet help someone interested in exploring the DOS option.

I wanted Linux on my laptop because I knew I would not be so confined as in DOS to my options for modern software.  Linux is a modern operating system that provides features (like multitasking) that I required.  The laptop is an AST PowerExec 4/25.  It has a 486/25 processor with 4MB of RAM and a 120MB IDE HD.  There is a HOWTO out there for installing Linux on laptops with 4MB of RAM, but I decided to go an easier route than their suggestion.  Basically, modern Linux distributions require 8MB for the installation process (RAMDisk and such).  So, I ordered a 2.5" IDE to 3.5" IDE convertor.  I installed the laptop HD in P166 test box and did a very lightweight installation of Slackware 3.6 from CD.  This method also allowed me to install from CD instead of using a network install from the laptop which would be necessary from my CD-ROM-less laptop.  After installing Slackware, I stripped out absolutely every unnecessary file or package and extracted the 2.0.39 kernel source.  I needed the latest kernel and pcmcia-cs package to get support for my Cisco 350 wireless PCMCIA adapter.  Using my faster Pentium-166 box, I compiled the latest 2.0.39 kernel with the latest pcmcia-cs package.

After using my faster machine to do the installation I fired up the drive in my laptop.  Everything came up ok, (albeit more slowly) and it was using my 16MB of swap this time.  The wireless card worked ok, and I put some finishing touches on my installation like setting up startup scripts and disabling services.

With 4MB RAM, I knew X would be a bit much to ask for, but I asked anyway!  I found tinyX, a stripped down XFree86 from an older version.  I found libc5 binaries and it was simply a matter of extracting them.  I then had to discover what graphics chipset I had in my laptop, which was not as easy as you might think.  When I finally found it, I then looked for an XFree86 config file for that chipset.  After finding that, X came up like a charm on my 486 with 4MB and 16MB swap!  I was able to actually export my DISPLAY from my other machines to the laptop so I got a great little X workstation in the process of upgrading from DOS to Linux.  Anyway, the whole process was fun and exciting and it seems I will never tire from stretching the limits of older, discarded hardware!

For a networking class project, I was able to establish a VPN connection between this machine using FreeS/WAN.  I was able to establish a connection to another FreeS/WAN box and to a FreeBSD box running the KAME stack.

Here are the pictures:

![PowerExec 1][ibm1]
![PowerExec 2][ibm2]

Yes, I chose to paint this laptop camoflage.  My camo powerexec now has four IBM processors epoxied to the top of it.  These CPUs are an IBM Blue Lightning 486 DX2/66, a PowerPC 601/66, a PPC 601/80a, and a PPC 601/90a.  This laptop has a whole lot more power on the outside than on the inside!  I took the PPC chips from several older Macs.  I like it very much.  Someday I hope to finish up the detail work on the inside of the machine as well.  Anyway, hope you like it!

DOS TCP/IP information (old info)
---------------------------------

When I first inherited this AST PowerExec 4/25, I started out using DOS.  It's actually quite a nice little laptop and I've discovered things that DOS was never meant to do!  In fact, I'm currently editing this page from the laptop.  I'm connected via Cisco wireless PCMCIA card using <a href="http://sshdos.sourceforge.net">sshdos</a>.  I'm afraid vim's syntax highlighting leaves much to be desired on this greyscale screen, but it will do.  In the meantime, I will post a few links to some of the sites that helped me make my laptop what it is today.

 * [Wattcp](http://www.wattcp.com) - TCP/IP stack for DOS.
 * [Arachne](http://www.arachne.cz) - Graphical web browser for DOS.
 * [Cisco](http://www.cisco.com) - Maker of fine wireless cards and provider of fine DOS packet drivers for those cards.
 * [sshdos](http://sshdos.sourceforge.net) - SSH for DOS!

I plan to continue to use MS-DOS as my primary OS on this bad boy, but I would also like to have a small Linux installation as well.  With a whopping 120MB HD, I should have no problem finding space for a little Linux.  With RAM also at a minimum, I am considering building my own Linux distribution from scratch, using my more powerful machines to develop everything.  Anyway, just an idea, so I'll post more if I do more.

[sketch1]: /images/440cdx_sketch.jpg
[sketch2]: /images/440cdx_2.jpg
[sketch3]: /images/440cdx_1.jpg
[sketch4]: /images/440cdx_3.jpg
[ibm1]: /images/powerexec_ibm_1.jpg
[ibm2]: /images/powerexec_ibm_2.jpg
