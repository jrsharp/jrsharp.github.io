---
status: publish
published: true
title: New kernel for Mac OS X?
author:
  display_name: admin
  login: admin
  email: jon@jonsharp.net
  url: http://jonsharp.net
author_login: admin
author_email: jon@jonsharp.net
author_url: http://jonsharp.net
wordpress_id: 144
wordpress_url: http://jonsharp.net/archives/2006/04/26/new-kernel-for-mac-os-x/
date: '2006-04-26 15:53:07 -0500'
date_gmt: '2006-04-26 20:53:07 -0500'
categories: []
tags: []
layout: page
comments: []
---
I recently read an [editorial](http://www.pbs.org/cringely/pulpit/pulpit20060420.html) by Robert Cringely dealing a bit with Mac OS X 10.5 (Leopard), Windows Vista / XP, Virtualization and Windows API compatibility.  I wasn't so interested in his speculation regarding Windows API compatibility as I was his suggestion that Leopard would be sporting a new kernel.  In all honesty, I hadn't ever really considered such a move very likely.  I mean, I know people have issues with Mach, but it works, right?  In fact, it works quite well.  That being said, I'm certainly not tied to it.  I began doing a bit of research on this issue to see if I could try to guess what to expect from Apple in Leopard.

The notion that Apple is ditching Mach brings several questions to mind.  First of all, why?  Well, it appears that Mach does in fact have some significant performance limitations when compared to monolithic kernels.  AnandTech put together [a nice write-up](http://www.anandtech.com/mac/showdoc.aspx?i=2436&p=7) of its own comparison testing.

So, if you agree that Mach has some significant drawbacks and that Apple is likely to want to replace it, the next question is, "With what will they replace it?"  The primary reason for replacing Mach in OS X would likely be for performance, so presumably, the replacement kernel would be monolithic.  Of the available open source monolithic kernels, the Linux and FreeBSD kernels present possibilities.  I discount Linux for several reasons.  First, Linux has some significant technical differences between FreeBSD &#47; Darwin, so marrying the Linux kernel with Darwin could prove technically challenging and unrewarding.  Second, Linux has GPL license encumberances.  Apple enjoys greater freedom with the BSD license.  Of the available monolithic kernels, the <a href="http:&#47;&#47;www.freebsd.org">FreeBSD<&#47;a> kernel seems most likely.

It is entirely possible, however, that Apple has been developing a replacement kernel themselves for some time.  I actually think this one is less likely, but still possible.  I think it would take an awful lot of resources to develop a separate kernel entirely for all this time.

Another interesting possibility is the [L4 kernel](http://en.wikipedia.org/wiki/L4_kernel).  L4 is similar to Mach in its microkernel design, but is meant to address a number of the problems with Mach.  There has already been some work done to bring L4 to Darwin and work is ongoing.  You can read more about the L4/Darwin (darbat) project [here](http://www.ertos.nicta.com.au/software/darbat/).  I've downloaded the Qemu image and tried it out, myself.  It's still very early in development, and unless Apple engineers have been working on this apart from the darbat developers, I can't see Leopard sporting L4.

The last question I want to explore in this post is, "Even if Mach has problems, is it really worth the effort of replacing it?"  It seems to me that Mach's issues have the greatest implication for Mac OS X Server, where things like database and webserver performance are so critical.  Well, wouldn't it be worth replacing Mach to have a competitive enterprise server OS?  I'm not so sure Apple is that concerned about it.  In fact, here is [one account](http://viewfromthemountain.typepad.com/applepeels/2006/03/lingering_regre.html) that Apple is not interested in the enterprise at all.  So, if Steve isn't interested in the enterprise market, and Mach is mostly holding back OS X Server performance, does it make sense to swap kernels?

Well, honestly, I don't know.  It seems to me like Mach has seen better days.  Maybe the naysayers are right and it is time for a change.  Could Apple pull it off?  In the middle of the PPC->Intel transition?  Yes, I think so.  In fact, the time is right for a kernel move.  All I know is, Apple's not saying a whole lot about Leopard yet.  This year's WWDC is sure to bring some exciting news items.  Will a new kernel be one of them?  I don't know, but I can't wait to find out.

Links:
 * http://www.pbs.org/cringely/pulpit/pulpit20060420.html
 * http://www.pbs.org/cringely/pulpit/pulpit20060413.html
 * http://www.anandtech.com/mac/showdoc.aspx?i=2436&p=7
 * http://episteme.arstechnica.com/groupee/forums/a/tpc/f/8300945231/m/645003648731
 * http://en.wikipedia.org/wiki/L4_kernel
 * http://www.ertos.nicta.com.au/software/darbat/
 * http://en.wikipedia.org/wiki/Linux_kernel
 * http://en.wikipedia.org/wiki/FreeBSD_kernel
