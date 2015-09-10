---
status: publish
published: true
title: Apple Pro Keyboard on Windows XP
author:
  display_name: admin
  login: admin
  email: jon@jonsharp.net
  url: http://jonsharp.net
author_login: admin
author_email: jon@jonsharp.net
author_url: http://jonsharp.net
wordpress_id: 143
wordpress_url: http://jonsharp.net/archives/2006/04/18/apple-pro-keyboard-on-windows-xp/
date: '2006-04-18 14:51:34 -0500'
date_gmt: '2006-04-18 19:51:34 -0500'
categories: []
tags: []
layout: page
comments: []
---
My old AT keyboard finally bit the dust recently, so I decided to replace it with an Apple Pro USB Keyboard.  I'm currently using a trial copy of Windows XP x64 Edition on this new PC of mine, and the Apple Pro Keyboard works great "out of the box" with it.  However, when I began using Synergy, I began to be irritated by the fact that the alt/option key naturally maps to the apple/command key on my PowerBook.  The alt/option key is just not nearly so well positioned for this purpose, so I set it to fix this annoyance. 

[Synergy](http://synergy2.sourceforge.net) is very configurable, and I was able to fix the problem by setting "Alt" to "Super" and "Super" to "Alt" in my PowerBook's screen definition in the Synergy config.   This allowed me to use the proper Apple/Command key when my PowerBook had focus in Synergy.  My problem seemed resolved until switching back to the PC and realizing that Alt-Tab meant moving my thumb to the "alt/option" key again.  This, I thought, was a bit annoying as well.

I knew that Windows XP allowed for remapping keyboard keys by redefining keyboard scancodes in the registry, so after consulting http://www.microsoft.com/whdc/device/input/w2kscan-map.mspx and http://goatpunch.com:8080/interflow?Remapping+Windows+Xp+Keyboard+Scancodes, I put together a registry entry that remapped my Apple/Command (originally mapped as the "Left Windows Key") to be "Left Alt" and "Left Alt" to "Left Windows Key".  I didn't bother remapping the right equivalents, as I don't tend to use those very often.

So far, I've found this remapping to be very useful, so I am providing it as a registry file you can import.  You will need to reboot after applying the registry file for the changes to take effect.

You can download the file [here](/files/Apple Pro Keyboard Map.reg).

I hope someone else finds this useful.
