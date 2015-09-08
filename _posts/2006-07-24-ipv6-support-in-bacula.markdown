---
status: publish
published: true
title: IPv6 support in Bacula
author:
  display_name: admin
  login: admin
  email: jon@jonsharp.net
  url: http://jonsharp.net
author_login: admin
author_email: jon@jonsharp.net
author_url: http://jonsharp.net
wordpress_id: 156
wordpress_url: http://jonsharp.net/archives/2006/07/24/ipv6-support-in-bacula/
date: '2006-07-24 13:56:14 -0500'
date_gmt: '2006-07-24 18:56:14 -0500'
categories: []
tags: []
comments: []
---
<p>I now have my own <a href="http:&#47;&#47;www.bacula.org">Bacula<&#47;a> backup setup running entirely over <a href="http:&#47;&#47;en.wikipedia.org&#47;wiki&#47;IPv6">IPv6<&#47;a>.  It didn't take too long to figure out, but I thought I'd share this here.  The trick is defining the addresses for your storage daemon, file daemon, and director.  The entry looks something like this:</p>
<pre><code><br />
DIRAddresses = {<br />
   ipv6 = {<br />
     addr = servername;<br />
     port = 9101;<br />
   }<br />
 }<br />
<&#47;code><&#47;pre></p>
<p>In my case, I have AAAA records set up for my servers, so I'm not using the colon notation, but the <a href="http:&#47;&#47;www.bacula.org&#47;dev-manual&#47;Storage_Daemon_Configuratio.html#SECTION000162000000000000000">documentation<&#47;a> seems to indicate that either is acceptable.  This above example is for my director, found in the bacula-dir.conf file.  Similar entries for the FD and SD are found in their respective files.</p>
