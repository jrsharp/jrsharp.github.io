---
status: publish
published: true
title: OpenDarwin 7.2.1 on Latitude D600
author:
  display_name: admin
  login: admin
  email: jon@jonsharp.net
  url: http://jonsharp.net
author_login: admin
author_email: jon@jonsharp.net
author_url: http://jonsharp.net
wordpress_id: 33
wordpress_url: http://jonsharp.net/archives/2004/08/18/opendarwin-721-on-latitude-d600/
date: '2004-08-18 16:22:03 -0500'
date_gmt: '2004-08-18 21:22:03 -0500'
categories: []
tags: []
comments:
- id: 337
  author: Matthew Hocker
  author_email: mhocker@gmail.com
  author_url: ''
  date: '2004-12-18 22:34:09 -0600'
  date_gmt: '2004-12-19 03:34:09 -0600'
  content: "I am currently trying to compile gcc-3.3.4 on Opendarwin 7.2.1  so I can
    compile GNUstep, what configure options did you use and how did you compile it.\r\n\r\nThanks,"
- id: 344
  author: Jon Sharp
  author_email: jon@jonsharp.net
  author_url: http://www.jonsharp.net
  date: '2004-12-20 01:34:50 -0600'
  date_gmt: '2004-12-20 06:34:50 -0600'
  content: "Matthew,\r\n\r\nI'm glad to see someone else interested in this!  I'm
    afraid it's been a while since I've had the time to spend on this project, so
    my answer won't be as specific as you or I would like, but I'll try to help as
    best as I can.  In the documentation directory of th GNUstep-make package for
    GNUstep, there is a HOWTO.Darwin or README.Darwin file.  I was able to follow
    the steps in this file straight through to a working GNUstep installation on OpenDarwin
    7.2.1 (x86).  It's pretty detailed and a little bit tricky, but it's doable.  I
    began working on a Portfile for the GNUstep packages, but again, have not had
    the time to finish them and submit them.  I've got them working for the most part,
    but I have yet to resolve some of the detailed issues involved in Darwinports
    development.  Anyway, I hope that helps.  Feel free to email me for more help.
    \ Good luck!\r\n\r\n--\r\nJon"
- id: 1052
  author: carlos torres
  author_email: k4toc@yahoo.com.mx
  author_url: ''
  date: '2005-03-02 11:42:24 -0600'
  date_gmt: '2005-03-02 16:42:24 -0600'
  content: "hello... well.. it's not a comment ... but i'd like, if you want learn
    me how did you compile GNUStep in your darwin, i'm doing the same, but i can not
    get to compile GNUStep. i have darwin 7.2.1. i have installed gnu make and fsf
    gcc \r\n\r\nof course! on x86\r\n\r\nthanks for all!! \r\n\r\ncarlos torres!"
---
<p>I have long been interested in the <a href="http:&#47;&#47;apple.com&#47;darwin">Darwin<&#47;a> project.  It is, after all, the basis for <a href="http:&#47;&#47;apple.com&#47;macosx">Mac OS X<&#47;a>.  And it's <a href="http:&#47;&#47;www.opensource.org">open source<&#47;a>!  Perhaps the aspect that so fascinates me is that it runs on x86 hardware, albeit with limited support.  I have played with Darwin since version 1.2.1, when it was quite a bit more raw than it is today.  Darwin still remains raw, but many things have improved.  With the recent release of OpenDarwin 7.2.1, I decided to upgrade my existing Darwin 7.0.1 installation on my Dell Latitude D600.</p>
<p>I did have a few problems with the installation.  The x86 installation of OpenDarwin still requires that you reboot into the installation CD shell, mount the new installation, and edit a file to specify exactly which partition to boot to.  (It can be done from the boot prompt as well, but you must remember what partition designation is required.)  Also, the Broadcom Gigabit driver for my built-in BCM5705M chipset would not load this time.  I was, in fact, very surprised that it was supported under Darwin 7.0.1, but I didn't understand why it would be broken in a later release.  After some help from the OpenDarwin hackers list, (thanks Chuck!) I discovered that the new driver was not compiled fat (with both x86 and ppc code), while the previous one had included x86 support.  I was able to replace the new driver with the one provided on the 7.0.1 CD and all is well again.</p>
<p>I now have OpenDarwin 7.2.1 running quite well on my Latitude.  I was able to successfully compile XFree86 4.4, which is much nicer than running in Darwin's VESA framebuffer o' artifacts.  My greatest success so far has been to get <a href="http:&#47;&#47;www.gnustep.org">GNUstep<&#47;a> running.  It's not exactly an easy task.  I had to compile GCC 3.3.4 and use it instead of Apple's provided GCC 3.3.  After wading through the documentation, I was treated to a working installation of GNUstep.  I have WindowMaker running as well.  My goal at present is to get more GNUstep applications to compile and run.  I have successfully managed to compile ProjectCenter and GNUMail, but neither will run, complaining about bundles not existing.  The bundles do in fact exist, so I clearly have some work to do there.</p>
<p>The fascinating part of GNUstep is that it is based upon the NeXTSTEP&#47;OpenSTEP architecture, which has become Mac OS X&#47;Cocoa today.  My goal is to create a system which resembles my Mac OS X system as closely as possible on x86 hardware.  Using the GNUstep framework, it is possible to port Mac OS X&#47;Cocoa applications to Darwin x86&#47;GNUstep.  I find this possibility very interesting.  I know that I may not have the time or continuing interest to achieve this goal, but perhaps I can share some of my efforts here and inspire others to do the same.</p>
<p>The best part of the 7.2.1 release?  The bootsplash screen is exactly the same as that on Mac OS X.  When booting, you are greeted with the gray screen with the Apple logo and spinning progress indicator below.  It's marvelous.</p>
