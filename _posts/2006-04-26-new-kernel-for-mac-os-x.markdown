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
comments: []
---
<p>I recently read an <a href="http:&#47;&#47;www.pbs.org&#47;cringely&#47;pulpit&#47;pulpit20060420.html">editorial<&#47;a> by Robert Cringely dealing a bit with Mac OS X 10.5 (Leopard), Windows Vista &#47; XP, Virtualization and Windows API compatibility.  I wasn't so interested in his speculation regarding Windows API compatibility as I was his suggestion that Leopard would be sporting a new kernel.  In all honesty, I hadn't ever really considered such a move very likely.  I mean, I know people have issues with Mach, but it works, right?  In fact, it works quite well.  That being said, I'm certainly not tied to it.  I began doing a bit of research on this issue to see if I could try to guess what to expect from Apple in Leopard.</p>
<p>The notion that Apple is ditching Mach brings several questions to mind.  First of all, why?  Well, it appears that Mach does in fact have some significant performance limitations when compared to monolithic kernels.  AnandTech put together <a href="http:&#47;&#47;www.anandtech.com&#47;mac&#47;showdoc.aspx?i=2436&p=7">a nice write-up<&#47;a> of its own comparison testing.</p>
<p>So, if you agree that Mach has some significant drawbacks and that Apple is likely to want to replace it, the next question is, "With what will they replace it?"  The primary reason for replacing Mach in OS X would likely be for performance, so presumably, the replacement kernel would be monolithic.  Of the available open source monolithic kernels, the Linux and FreeBSD kernels present possibilities.  I discount Linux for several reasons.  First, Linux has some significant technical differences between FreeBSD &#47; Darwin, so marrying the Linux kernel with Darwin could prove technically challenging and unrewarding.  Second, Linux has GPL license encumberances.  Apple enjoys greater freedom with the BSD license.  Of the available monolithic kernels, the <a href="http:&#47;&#47;www.freebsd.org">FreeBSD<&#47;a> kernel seems most likely.</p>
<p>It is entirely possible, however, that Apple has been developing a replacement kernel themselves for some time.  I actually think this one is less likely, but still possible.  I think it would take an awful lot of resources to develop a separate kernel entirely for all this time.</p>
<p>Another interesting possibility is the <a href="http:&#47;&#47;en.wikipedia.org&#47;wiki&#47;L4_kernel">L4 kernel<&#47;a>.  L4 is similar to Mach in its microkernel design, but is meant to address a number of the problems with Mach.  There has already been some work done to bring L4 to Darwin and work is ongoing.  You can read more about the L4&#47;Darwin (darbat) project <a href="http:&#47;&#47;www.ertos.nicta.com.au&#47;software&#47;darbat&#47;">here<&#47;a>.  I've downloaded the Qemu image and tried it out, myself.  It's still very early in development, and unless Apple engineers have been working on this apart from the darbat developers, I can't see Leopard sporting L4.</p>
<p>The last question I want to explore in this post is, "Even if Mach has problems, is it really worth the effort of replacing it?"  It seems to me that Mach's issues have the greatest implication for Mac OS X Server, where things like database and webserver performance are so critical.  Well, wouldn't it be worth replacing Mach to have a competitive enterprise server OS?  I'm not so sure Apple is that concerned about it.  In fact, here is <a href="http:&#47;&#47;viewfromthemountain.typepad.com&#47;applepeels&#47;2006&#47;03&#47;lingering_regre.html">one account<&#47;a> that Apple is not interested in the enterprise at all.  So, if Steve isn't interested in the enterprise market, and Mach is mostly holding back OS X Server performance, does it make sense to swap kernels?</p>
<p>Well, honestly, I don't know.  It seems to me like Mach has seen better days.  Maybe the naysayers are right and it is time for a change.  Could Apple pull it off?  In the middle of the PPC->Intel transition?  Yes, I think so.  In fact, the time is right for a kernel move.  All I know is, Apple's not saying a whole lot about Leopard yet.  This year's WWDC is sure to bring some exciting news items.  Will a new kernel be one of them?  I don't know, but I can't wait to find out.</p>
<ul>Links:</p>
<li><a href="http:&#47;&#47;www.pbs.org&#47;cringely&#47;pulpit&#47;pulpit20060420.html">http:&#47;&#47;www.pbs.org&#47;cringely&#47;pulpit&#47;pulpit20060420.html<&#47;a><&#47;li>
<li><a href="http:&#47;&#47;www.pbs.org&#47;cringely&#47;pulpit&#47;pulpit20060413.html">http:&#47;&#47;www.pbs.org&#47;cringely&#47;pulpit&#47;pulpit20060413.html<&#47;a><&#47;li>
<li><a href="http:&#47;&#47;www.anandtech.com&#47;mac&#47;showdoc.aspx?i=2436&p=7">http:&#47;&#47;www.anandtech.com&#47;mac&#47;showdoc.aspx?i=2436&p=7<&#47;a><&#47;li>
<li><a href="http:&#47;&#47;episteme.arstechnica.com&#47;groupee&#47;forums&#47;a&#47;tpc&#47;f&#47;8300945231&#47;m&#47;645003648731">http:&#47;&#47;episteme.arstechnica.com&#47;groupee&#47;forums&#47;a&#47;tpc&#47;f&#47;8300945231&#47;m&#47;645003648731<&#47;a><&#47;li>
<li><a href="http:&#47;&#47;en.wikipedia.org&#47;wiki&#47;L4_kernel">http:&#47;&#47;en.wikipedia.org&#47;wiki&#47;L4_kernel<&#47;a><&#47;li>
<li><a href="http:&#47;&#47;www.ertos.nicta.com.au&#47;software&#47;darbat&#47;">http:&#47;&#47;www.ertos.nicta.com.au&#47;software&#47;darbat&#47;<&#47;a><&#47;li>
<li><a href="http:&#47;&#47;en.wikipedia.org&#47;wiki&#47;Linux_kernel">http:&#47;&#47;en.wikipedia.org&#47;wiki&#47;Linux_kernel<&#47;a><&#47;li>
<li><a href="http:&#47;&#47;en.wikipedia.org&#47;wiki&#47;FreeBSD_kernel">http:&#47;&#47;en.wikipedia.org&#47;wiki&#47;FreeBSD_kernel<&#47;a><&#47;li><br />
<&#47;ul></p>
