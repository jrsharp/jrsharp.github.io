---
status: publish
published: true
title: OmniGraffle Webpage Skeleton AppleScript
author:
  display_name: admin
  login: admin
  email: jon@jonsharp.net
  url: http://jonsharp.net
author_login: admin
author_email: jon@jonsharp.net
author_url: http://jonsharp.net
wordpress_id: 11
wordpress_url: http://jonsharp.net/archives/2004/04/06/OmniGraffle Webpage Skeleton
  AppleScript/
date: '2004-04-06 09:35:12 -0500'
date_gmt: '2004-04-06 14:35:12 -0500'
categories: []
tags: []
layout: page
comments:
- id: 3
  author: David Benton
  author_email: dbenton@southern.edu
  author_url: http://www.dbenton.com
  date: '2004-04-07 16:22:31 -0500'
  date_gmt: '2004-04-07 21:22:31 -0500'
  content: "First of all, the blog looks good. I was going to call you and discuss
    this entry, but I'll take this opportunity to add to the discussion and contribute
    to your site, so here goes...

    As you said, \"it doesn't matter how
    good the visual design of [a] website is if the structural design and content
    are lacking.\"  That's so true. Information Architecture is an oft overlooked
    area of web development. As you know, I've taken an interest in web standards
    (see http://www.vmpofcollegedale.org),
    and I think your statement is in the same vein. How so? Because this medium is
    all about information. We web designers sometimes have a hard time remembering
    that. Anyway, thanks for the reminder.

    On to the more immediate
    point of the entry - I love the idea of linking the visualization to code. That
    would be excellent for efficiency and coherence in the development of websites
    (me coughs in the general direction of Macromedia). Best of luck with the
    project and keep me posted."
---
I have been given the task of rebuilding my company's website.  I will not have to do the design work, as we have a full-time graphic designer, but because he does not have much web experience, I am responsible for putting his design into code.  I'm not too concerned about that, but what I am concerned with is the content and structure of the site.  I have emphasized to our management that it doesn't matter how good the visual design of our website is if the structural design and content are lacking.  This is a problem I have faced many times before, but this time around is different.

<!--more-->

You see, the people putting together the content for the site are not going to be able to give me a clear site map diagram for me to begin building the site from.  Sure, they have an opinion, but I don't believe they can create a sitemap by themselves.  That's ok, because I've created sitemaps before for people who just don't know where to begin, but I'm concerned that if I take that responsibility, they will come back and want me to change something after the graphics have been created and navigation put in place.  

So, in considering this, I came up with an idea.  I was already using OmniGraffle to do my sitemap diagram which I was going to use to show my boss to have him sign off on.  I thought OmniGraffle had an XML export option, so I envisioned writing a PHP script which parsed the XML representing my sitemap and generated a collection of html files with links to each other according to the diagram.  This would essentially be a skeleton website with all the html documents I needed with the link navigation I needed.  I then planned to pull that into Dreamweaver to apply my template.

You may be saying to yourself that this is a bit of overkill, or there may be a better way to accomplish this using existing Dreamweaver techniques or plugins.  And you know what?  You may be very right.  However, I love using OmniGraffle and really liked this idea of translating the visual representation of a website into some actual useful code.  What I discovered, however, is that OmniGraffle 2 does not have an XML export feature.  Only OmniGraffle 3 Professional does.  So, I almost gave up, but not quite.  I discovered that OmniGraffle is a scriptable application.  

Now, I know very little AppleScript.  Up to this point, my only exposure was modifying an iPhoto AppleScript to work with the image gallery database of JonandJolene.com.  But again, I really liked this idea, so I figured this was an opportunity to learn some more AppleScript!  :)  I have been working on this project a few hours a day for the past 5 days or so and I now have a working script that creates an html document for each shape whose url contains "html" and adds links to each which point to the other documents that are connected via outgoing lines.  The script needs a lot of polish, and there are many things I want to add, but it's more or less working at this point.  I just wanted to write about it here on the blog in hopes someone may find it interesting.  When I get more work done on the project, I may release it on this site, or see if Omni Group would be interested in putting in there community contribution section.  Anyway, wish me luck on the completion of the project.  (and that it actually does save me some time in the long run)
