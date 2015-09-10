---
status: publish
published: true
title: 'RetroChallenge Update #1'
author:
  display_name: admin
  login: admin
  email: jon@jonsharp.net
  url: http://jonsharp.net
author_login: admin
author_email: jon@jonsharp.net
author_url: http://jonsharp.net
wordpress_id: 171
wordpress_url: http://www.jonsharp.net/archives/2009/07/09/retrochallenge-update-1/
date: '2009-07-09 23:36:59 -0500'
date_gmt: '2009-07-10 04:36:59 -0500'
categories: []
tags: []
layout: page
comments: []
---
Ok, well, I happen to be rather busy with work lately, so I haven't been able to post since my first post, but I wanted to post this brief update.  I have been making good progress...  I have been reading lots of documentation and I've nearly completed my parts list.  For flexibility, I'll be using a CPLD to implement the discrete logic/ROM required for my board design.  I've ordered an Altera MAX7000 series part, but am also considering using one of the comparable Atmel parts.  For compatibility, I'll also be using the <a href="http://www.jameco.com/webapp/wcs/stores/servlet/ProductDisplay?jameco_page=42&langId=-&productId=43318&catalogId=10001&freeText=6551&storeId=10001&search_type=jamecoall&ddkey=http:StoreCatalogDrillDownView">6551</a> UART chip used in the original Super Serial Card design.

Now, for the most significant part...  I think I've decided on using the <a href="http://www.bluegiga.com/WT12_Class_2_Bluetooth_Module">BlueGiga WT12 embedded Bluetooth module</a>.  There are a number of good modules out there for embedded bluetooth, but this one has a flexible firmware and supports more profiles than other modules, giving me some interesting potential beyond simply establishing the virtual serial connection with my Treo. ;)

Also, I've got a handy Eagle CAD library for the Apple II card edge connector.  (Thanks Anthony!)  With that, I should be able to start putting a schematic and board layout together soon.
