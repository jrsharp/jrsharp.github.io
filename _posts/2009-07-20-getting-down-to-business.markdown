---
status: publish
published: true
title: Getting down to business
author:
  display_name: admin
  login: admin
  email: jon@jonsharp.net
  url: http://jonsharp.net
author_login: admin
author_email: jon@jonsharp.net
author_url: http://jonsharp.net
wordpress_id: 174
wordpress_url: http://www.jonsharp.net/archives/2009/07/20/getting-down-to-business/
date: '2009-07-20 00:53:37 -0500'
date_gmt: '2009-07-20 05:53:37 -0500'
categories: []
tags: []
layout: page
comments: []
---
Ok, so I arrived home to discover that about half of the things I had ordered for the project had arrived.  It was enough to start putting things together, so I started today with the WT-32 Bluetooth module.  I ordered this from Sparkfun with their breakout board, so it was easy to interface this with an RS232 level adapter board I had on hand.  I powered this with 3 AAA batteries and fired up ZTerm on my MBP.  I was able to begin interacting with the module straight away over the UART.  I then initiated a Bluetooth connection with it and was able to create a serial connection over the Bluetooth.  This took about 5 minutes.  So far, I'm very impressed with the module.

With the Bluetooth module working as it should, I set my attention on the //e.  Since I intend to recreate the SSC in my card, I figured it was best to begin with a real SSC and simply connect my RS232 adapter board to the SSC directly.  This proved more tricky than setting up the Bluetooth module, as it took me a while to get the settings for <a href="http://adtpro.sourceforge.net/">ADTPro</a> just right.  I ended up getting ADTPro working using the serial port so I am now able to send disk images over from my MBP.  Tomorrow I should be able to get MODEM.MGR up and running on it and we should have the Bluetooth module up and running with it!

After that, I'll need to figure out how to implement the SSC logic in my CPLD and continue laying out my board.  I did also receive my Altera CPLD dev kit.  I'm still waiting on a few parts, but in the meantime, here are a few pics:

<img src="http://jonsharp.net/images/IMG_8501.jpg"/><br />
Altera MAX7000 CPLD dev kit<br />

<img src="http://jonsharp.net/images/IMG_8504.jpg"/><br />
WT-32 Bluetooth module on breakout board from Sparkfun<br />

<img src="http://jonsharp.net/images/IMG_8506.jpg"/><br />
Assembled test circuit for WT32 module<br />
