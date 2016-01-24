---
status: publish
published: true
title: We Need MOSIX for Darwin / Mac OS X
author:
  display_name: admin
  login: admin
  email: jon@jonsharp.net
  url: http://jonsharp.net
author_login: admin
author_email: jon@jonsharp.net
author_url: http://jonsharp.net
wordpress_id: 110
wordpress_url: http://jonsharp.net/archives/2006/03/20/we-need-mosix-for-darwin-mac-os-x/
date: '2006-03-20 10:35:01 -0600'
date_gmt: '2006-03-20 15:35:01 -0600'
categories: []
tags: []
layout: page
comments: []
---
I've long been interested in parallel computing, having become intrigued by the subject when reading about the first "Beowulf" clusters in use years ago.  I began experimenting with PVM on my Linux and FreeBSD machines at home years ago and was pleased to build a "cluster" of two machines which could process POV scenes more quickly than either one by itself.  It was a nice achievement, but I recognized that parallel computing did not hold much promise for my day-to-day computing experience.

As time went on, I discovered [MOSIX](http://www.mosix.org).  I began playing with MOSIX and was thrilled to have a cluster that did not require special apps compiled against PVM or MPI libraries.  MOSIX made parallel computing transparent to the applications running on top of it.  While there are still places where the PVM or message-passing models may work better, MOSIX greatly simplifies this parallel computing process and opens it up to every Unix binary.  (that can be forked)

As a Mac OS X user &#47; administrator today, I have been playing with Xgrid since Apple released it's technology preview.  Based on the initial marketing hype and my experience with MOSIX, I was greatly anticipating an amazing advance forward in parallel computing in a system with the advantages of MOSIX and the signature ease-of-use that Apple products bring.  I have since discovered that while Xgrid simplifies some things, it is certainly not as trivial as I first expected.  In addition, there doesn't seem to be a whole lot of examples for new uses for Xgrid.  Doing a search for Xgrid applications, I discovered the same basic POVRay example that I used to test my PVM-based cluster years ago.

Now I'm not saying that Xgrid is bad.  In fact, I'm very glad to see Apple working on such technology, and I'm certain that it will continue to improve.  Perhaps we'll see advances in this area for Leopard.  In the meantime, wouldn't it be great to have MOSIX ported to Darwin?  I've never even glanced at the MOSIX code, so I have no idea what this would entail, but the MOSIX team says it has been ported to several Unices, and they seem to indicate that it is fairly portable code.  So, let's do it.  Are there any other Mac OS X &#47; parallel computing enthusiasts interested in such a project?  Am I way off here?  Maybe Xgrid is more powerful and flexible than it appears to me.  What are some of you doing with Xgrid?  I'd love to hear about it.

In the meantime, I'll continue to use Xgrid for POV and Xcode's distributed build technology for compiling large projects.  But if I could speed up certain tasks on my older G3s and G4s by tapping the idle CPU power on my newer boxes, that'd be marvelous.
