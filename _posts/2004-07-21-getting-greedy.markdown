---
status: publish
published: true
title: Getting Greedy
author:
  display_name: admin
  login: admin
  email: jon@jonsharp.net
  url: http://jonsharp.net
author_login: admin
author_email: jon@jonsharp.net
author_url: http://jonsharp.net
wordpress_id: 28
wordpress_url: http://jonsharp.net/archives/2004/07/21/getting-greedy/
date: '2004-07-21 19:06:47 -0500'
date_gmt: '2004-07-22 00:06:47 -0500'
categories: []
tags: []
layout: page
comments: []
---
While I was very satisfied with my successful PowerBook overclocking, I was left with the nagging thought that this G3 could handle higher speeds.  :)  So, I decided to try the 83Mhz FSB.  I knew this would likely give the greatest increase in performance, with the greatest risk of instability.  I started by resetting the multiplier to 6, while altering the resistors responsible for the FSB.  It would not POST.  No lovely Apple chime.  The screen remained black, though the machine was clearly on.  I tried removing one of the dimms and making sure the cpu module and memory were both seated properly.  Still nothing.  I figured it was time to try for 500Mhz by using a multiplier of 7.5 with the original FSB of 66Mhz.  I reconfigured my resistors, reinstalled the cpu module, and powered my Lombard up while crossing my fingers.  It booted right up into OS X (10.4 Tiger preview).  So far so good.  It read "500Mhz PowerPC G3 Processor" under "About this computer".  Excellent!  Now, I knew OS 9 was a bit more finicky, so I decided to reboot into 9 to test stability.  It booted up into 9 just fine, but Apple System Profiler crashed.  GLQuake crashed.  I tried rebooting, but the system just wasn't stable.  I think the CPU was getting too hot.  I decided 466 was my magic number.  I reset the resistors and my stability was restored.  I'm currently making this post using Mozilla 1.3.1 under OS 9 on this machine right now.  At least I satisfied my curiosity (without ruining my CPU) and hopefully provided some useful stability information for anyone attempting this in the future. :)
