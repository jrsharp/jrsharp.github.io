---
status: publish
published: true
title: They don't call it a challenge for nothing
author:
  display_name: admin
  login: admin
  email: jon@jonsharp.net
  url: http://jonsharp.net
author_login: admin
author_email: jon@jonsharp.net
author_url: http://jonsharp.net
wordpress_id: 176
wordpress_url: http://www.jonsharp.net/archives/2009/07/24/they-dont-call-it-a-challenge-for-nothing/
date: '2009-07-24 00:49:06 -0500'
date_gmt: '2009-07-24 05:49:06 -0500'
categories: []
tags: []
layout: page
comments: []
---
Well, the reason I haven't posted of late is that I've run into a couple of snags.  I had really hoped that next post would be one announcing my success in establishing a direct connection from my //e to my Treo.  You see, I was very close.  As I mentioned in my last post, I was nearly able to transfer disk images over to my //e using ADTPro.  Well, I got that working with minimal effort and created myself a MODEM.MGR boot disk which would talk to my bluetooth module connected to the SSC.  So all of that works just fine.  The //e talks to the bluetooth module no problem.

So the issue I'm having is between the Treo and the module.  It seems there's something about the Treo that the module doesn't like, or vice versa, perhaps.  I can establish a SPP/DUN connection to my wife's phone, a Sanyo Katana, no problem.  Of course, I can establish a similar connection with the Treo, but I cannot issue any commands at all.  The module says it is connected but I'm clearly getting nothing through.  I've never been terribly impressed with the Bluetooth stack on the Palm OS, so I imagine it's just a little idiosyncratic and I haven't found a way to make this module talk to the Treo yet.  Bluegiga is a Finnish company and their tech support has been friendly and responsive, but not particularly helpful.

At this point, I feel as if I'm out of options with the WT-32 module, so I've ordered a <a href="http://www.sparkfun.com/commerce/product_info.php?products_id=582">BlueSMIRF module</a>.  I'm determined to get this connection working under the deadline.  Now, I'm not as enthusiastic about the feature set on the BlueSMIRF, which is why I had picked the BlueGiga module in the first place.  But as it turns out, the BlueGiga module does not support the HID profile in host mode, which would have allowed me to interface my Apple Bluetooth Keyboard with the //e.  The WT-32 still has some neat audio features that the BlueSMIRF lacks, but I wasn't quite as interested in those.  Anyway, I'm hoping that the BlueSMIRF and Treo get along a little better.

In the meantime, I have been trying to work on the other thing I wanted to accomplish, the board layout/design for a custom card for this application.  This was always the part I wasn't entirely certain I would have time to put together in a month.  As August approaches, I'm feeling less and less confident.  However, I do continue to make progress on this, but it is requiring learning a lot of new tools.  I'm currently trying to implement the discrete logic of the SSC as VHDL code in an Altera CPLD.  Given that the schematic for the SSC is available, the challenge here is simply getting up to speed with these new tools.

I'm also still awaiting the delivery of some essential prototyping components that have been delayed.  But all things considered, I'm still confident I can have my //e and Treo talking soon and I should also be able to have a board layout/VHDL design for the card mostly complete by the time the clock runs out on this friendly competition.
