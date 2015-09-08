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
comments: []
---
<p>My old AT keyboard finally bit the dust recently, so I decided to replace it with an Apple Pro USB Keyboard.  I'm currently using a trial copy of Windows XP x64 Edition on this new PC of mine, and the Apple Pro Keyboard works great "out of the box" with it.  However, when I began using Synergy, I began to be irritated by the fact that the alt&#47;option key naturally maps to the apple&#47;command key on my PowerBook.  The alt&#47;option key is just not nearly so well positioned for this purpose, so I set it to fix this annoyance.  </p>
<p><a href="http:&#47;&#47;synergy2.sourceforge.net">Synergy<&#47;a> is very configurable, and I was able to fix the problem by setting "Alt" to "Super" and "Super" to "Alt" in my PowerBook's screen definition in the Synergy config.   This allowed me to use the proper Apple&#47;Command key when my PowerBook had focus in Synergy.  My problem seemed resolved until switching back to the PC and realizing that Alt-Tab meant moving my thumb to the "alt&#47;option" key again.  This, I thought, was a bit annoying as well.</p>
<p>I knew that Windows XP allowed for remapping keyboard keys by redefining keyboard scancodes in the registry, so after consulting <a href="http:&#47;&#47;www.microsoft.com&#47;whdc&#47;device&#47;input&#47;w2kscan-map.mspx">several<&#47;a> <a href="http:&#47;&#47;goatpunch.com:8080&#47;interflow?Remapping+Windows+Xp+Keyboard+Scancodes">references<&#47;a>, I put together a registry entry that remapped my Apple&#47;Command (originally mapped as the "Left Windows Key") to be "Left Alt" and "Left Alt" to "Left Windows Key".  I didn't bother remapping the right equivalents, as I don't tend to use those very often.</p>
<p>So far, I've found this remapping to be very useful, so I am providing it as a registry file you can import.  You will need to reboot after applying the registry file for the changes to take effect.</p>
<p>You can download the file <a href="http:&#47;&#47;jonsharp.net&#47;files&#47;Apple Pro Keyboard Map.reg">here<&#47;a>.</p>
<p>I hope someone else finds this useful. </p>
