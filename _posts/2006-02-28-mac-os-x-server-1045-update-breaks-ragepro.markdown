---
status: publish
published: true
title: Mac OS X Server 10.4.5 update breaks RagePro
author:
  display_name: admin
  login: admin
  email: jon@jonsharp.net
  url: http://jonsharp.net
author_login: admin
author_email: jon@jonsharp.net
author_url: http://jonsharp.net
wordpress_id: 89
wordpress_url: http://jonsharp.net/archives/2006/02/28/mac-os-x-server-1045-update-breaks-ragepro/
date: '2006-02-28 09:54:35 -0600'
date_gmt: '2006-02-28 14:54:35 -0600'
categories: []
tags: []
comments: []
---
<p>I'm probably only one of 3 people crazy enough to run Tiger Server on Beige G3 hardware, but I figure I'll post this for those 2 others that may find this helpful.  I recently applied the 10.4.5 update and was disappointed to see that my screen blanked upon reboot.  As I am running VNC server on the box, I connected remotely to it to discover that the video was indeed messed up, even in VNC.  I had been avoiding the "Patched RagePro" driver provided by XPostFacto because I had seen some artifacts when using it before, but the update has forced me to check that checkbox in XPostFacto to get any video.  Of course, if I happen to notice too many artifacts, I suppose I can always install the 10.4.4 driver.</p>
<p>BTW, for anyone who may be curious about performance of Tiger Server on such old hardware, it's really not that bad.  I mean, it's useful for browsing, email, testing, etc.  I actually use it as a backup server.  It runs <a href="http:&#47;&#47;www.bacula.org">Bacula<&#47;a> backup software and backs up my network computers to an externally attached FireWire HD.</p>
