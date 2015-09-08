---
status: publish
published: true
title: OpenWrt upgrade
author:
  display_name: admin
  login: admin
  email: jon@jonsharp.net
  url: http://jonsharp.net
author_login: admin
author_email: jon@jonsharp.net
author_url: http://jonsharp.net
wordpress_id: 60
wordpress_url: http://jonsharp.net/archives/2005/05/04/openwrt-upgrade/
date: '2005-05-04 11:45:13 -0500'
date_gmt: '2005-05-04 16:45:13 -0500'
categories: []
tags: []
comments: []
---
<p>I recently upgraded to the latest CVS of <a href="http:&#47;&#47;www.openwrt.org">OpenWrt<&#47;a>, a custom Linux distribution designed for the Linksys Wrt54G wireless access point &#47; router and similar devices.  I've got to say that the new build process is incredible!  Great job guys!  I, for one, am one very happy user.  Using a "make menuconfig" build process, I was able to select the specific packages and kernel options&#47;modules I wanted on my custom firmware.  I wanted IPv6, Openswan IPsec, and wondershaper QOS.  So far, everything looks great and I was able to bring my iptables config over from the old OpenWrt installation.  I may add things like a simple SIP router or BGP routing.  After all, I still have 500kB left on the flash. ;)</p>
<p>The only thing I'm really wondering about at this point is if there is any way to install shorewall on another Linux box simply for the setup of the rules for my router.  I don't want shorewall actually running on the other Linux host.  I just want to be able to use the shorewall scripts to create my iptables rules for my router.  Anyway, if anyone knows how to do such a thing, let me know.  In the meantime, I'll just try to figure it out as I have time.</p>
