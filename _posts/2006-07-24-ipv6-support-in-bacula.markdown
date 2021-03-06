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
layout: page
comments: []
---
I now have my own <a href="http://www.bacula.org">Bacula</a> backup setup running entirely over <a href="http://en.wikipedia.org/wiki/IPv6">IPv6</a>.  It didn't take too long to figure out, but I thought I'd share this here.  The trick is defining the addresses for your storage daemon, file daemon, and director.  The entry looks something like this:

```
DIRAddresses = {
  ipv6 = {
    addr = servername;
    port = 9101;
  }
}
```

In my case, I have AAAA records set up for my servers, so I'm not using the colon notation, but the <a href="http://www.bacula.org/dev-manual/Storage_Daemon_Configuratio.html#SECTION000162000000000000000">documentation</a> seems to indicate that either is acceptable.  This above example is for my director, found in the bacula-dir.conf file.  Similar entries for the FD and SD are found in their respective files.
