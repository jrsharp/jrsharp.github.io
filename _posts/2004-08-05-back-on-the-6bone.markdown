---
status: publish
published: true
title: Back on the 6bone
author:
  display_name: admin
  login: admin
  email: jon@jonsharp.net
  url: http://jonsharp.net
author_login: admin
author_email: jon@jonsharp.net
author_url: http://jonsharp.net
wordpress_id: 31
wordpress_url: http://jonsharp.net/archives/2004/08/05/back-on-the-6bone/
date: '2004-08-05 09:42:02 -0500'
date_gmt: '2004-08-05 14:42:02 -0500'
categories: []
tags: []
layout: page
comments: []
---
We're back on the 6bone at home.  I lost my IPv6 tunnel a few weeks ago while I was in the process of upgrading / patching my kernel.  I lost ip_tables functionality temporarily during the upgrade, so I shut down the tunnel temporarily for security concerns.  [Hurricane Electric](http://www.tunnelbroker.net) permanently shut down the tunnel after a week of inactivity.  I just got ip_tables back yesterday, so I quickly signed back up for a new tunnel.  I had to modify my configuration for the new IPv6 adresses, and modify my DNS accordingly.  So, http://ipv6.jonandjolene.com is up again.  (Link will not work unless you have an IPv6 stack installed and are on the 6bone)  I'm glad to have it working again because IPv6 makes me feel so cool.

Edit: And, for the first time, ipv6.jonsharp.net works.  Now that I've migrated to Apache 2, I no longer have to use the khttpd ipv6 hack I was using.  This means I can actually do ipv6 virtual hosts.  <Mr. Burns Voice>Excellent.</Mr. Burns Voice>
