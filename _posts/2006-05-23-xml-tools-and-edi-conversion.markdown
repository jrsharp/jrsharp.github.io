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
comments: []
---
<p>I've been working on a project recently involving converting X12 EDI documents into XML files for integration with the <a href="http:&#47;&#47;www.sma-promail.com">PRO-MAIL<&#47;a> warehouse management &#47; fulfillment software.  I wanted to post here about some of the tools I've employed throughout this project.  Initially, I began using <a href="http:&#47;&#47;www.entropy.ch&#47;software&#47;macosx&#47;#testxslt">TestXSLT<&#47;a>, a simple Cocoa XSLT helper app, to begin putting together the stylesheet that would ultimately translate from one XML schema to another.  </p>
<p>Another tool I enjoyed using was the <a href="http:&#47;&#47;www.oxygenxml.com&#47;"><oXygen&#47;><&#47;a> XML editor.  I was particularly impressed with the schema browser&#47;editor portion of the software.</p>
<p>Ultimately, the tool I used most, however, was <a href="http:&#47;&#47;www.stylusstudio.com&#47;">Stylus Studio<&#47;a>.  Stylus Studio has many great features, but I was primarily interested in their EDI-to-XML conversion utilities.  From what I can tell, their EDI utilties are the best available.  Anyone who's ever dealt with EDI can tell you that it's a PITA to work with, and Stylus Studio makes it easy.  (relatively speaking, at least)  As a Java developer, I've also been impressed with the Java code generation and other Java language utilities available.  I was able to accomplish my EDI-XML workflow by utilizing Stylus Studio's Java API to achieve functionality not available using XSLT alone.  One of my favorite parts is that the API is available completely outside of the Stylus Studio application, meaning that you are able to leverage its powerful EDI adapters without invoking the application itself.  If you'd like to try it out, the version I have been using is <a href="http:&#47;&#47;www.stylusstudio.com&#47;xml_feature_overview.html">Stylus Studio 2006 Release 2 XML Enterprise Edition<&#47;a> and there is a 30-day trial version available <a href="http:&#47;&#47;www.stylusstudio.com&#47;xml_download.html">here<&#47;a>.  </p>
<p>Working in XML is almost always challenging, but I also find it very rewarding.  It's such a large bundle of complex, related technologies that it is necessrary to have good tools.  The <oXygen&#47;> XML editor is powerful and appears to be a great XML tool for many tasks, but I couldn't have completed my project without the EDI component of Stylus Studio.  I'm looking forward to trying more XML tools and new versions of those I've mentioned, and thanks to Stylus Studio, I'm actually looking forward to working with EDI again.</p>
