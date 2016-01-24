---
status: publish
published: true
title: XML Tools and EDI conversion
author:
  display_name: admin
  login: admin
  email: jon@jonsharp.net
  url: http://jonsharp.net
author_login: admin
author_email: jon@jonsharp.net
author_url: http://jonsharp.net
wordpress_id: 145
wordpress_url: http://jonsharp.net/archives/2006/05/23/xml-tools/
date: '2006-05-23 15:12:23 -0500'
date_gmt: '2006-05-23 20:12:23 -0500'
categories: []
tags: []
layout: page
comments: []
---
I've been working on a project recently involving converting X12 EDI documents into XML files for integration with the [PRO-MAIL](http://www.sma-promail.com) warehouse management / fulfillment software.  I wanted to post here about some of the tools I've employed throughout this project.  Initially, I began using [TextXSLT](http://www.entropy.ch/software/macosx/#testxslt), a simple Cocoa XSLT helper app, to begin putting together the stylesheet that would ultimately translate from one XML schema to another. 

Another tool I enjoyed using was the [oXygen](http://www.oxygenxml.com/) XML editor.  I was particularly impressed with the schema browser/editor portion of the software.

Ultimately, the tool I used most, however, was [Stylus Studio](http://www.stylusstudio.com/).  Stylus Studio has many great features, but I was primarily interested in their EDI-to-XML conversion utilities.  From what I can tell, their EDI utilties are the best available.  Anyone who's ever dealt with EDI can tell you that it's a PITA to work with, and Stylus Studio makes it easy.  (relatively speaking, at least)  As a Java developer, I've also been impressed with the Java code generation and other Java language utilities available.  I was able to accomplish my EDI-XML workflow by utilizing Stylus Studio's Java API to achieve functionality not available using XSLT alone.  One of my favorite parts is that the API is available completely outside of the Stylus Studio application, meaning that you are able to leverage its powerful EDI adapters without invoking the application itself.  If you'd like to try it out, the version I have been using is the Stylus Studio 2006 Release 2 XML Enterprise Edition and there is a 30-day trial version available.

Working in XML is almost always challenging, but I also find it very rewarding.  It's such a large bundle of complex, related technologies that it is necessrary to have good tools.  The `<oXygen/>` XML editor is powerful and appears to be a great XML tool for many tasks, but I couldn't have completed my project without the EDI component of Stylus Studio.  I'm looking forward to trying more XML tools and new versions of those I've mentioned, and thanks to Stylus Studio, I'm actually looking forward to working with EDI again.
