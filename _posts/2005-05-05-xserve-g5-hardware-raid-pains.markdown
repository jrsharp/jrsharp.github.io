---
status: publish
published: true
title: Xserve G5 Hardware RAID pains
author:
  display_name: admin
  login: admin
  email: jon@jonsharp.net
  url: http://jonsharp.net
author_login: admin
author_email: jon@jonsharp.net
author_url: http://jonsharp.net
wordpress_id: 62
wordpress_url: http://jonsharp.net/archives/2005/05/05/xserve-g5-hardware-raid-pains/
date: '2005-05-05 21:46:21 -0500'
date_gmt: '2005-05-06 02:46:21 -0500'
categories: []
tags: []
comments:
- id: 2836
  author: Frederic
  author_email: magicfredo@neuf.fr
  author_url: ''
  date: '2005-06-24 17:39:06 -0500'
  date_gmt: '2005-06-24 22:39:06 -0500'
  content: "Hello! I have exactly the same problem and did not find a way to solve
    it. I do not have a graphic card and can't buy one for the moment. Any idea to
    help me? Even the Apple Support was not able to give me a solution!\r\nRegards\r\nFr&Atilde;&copy;d&Atilde;&copy;ric"
---
<p>Who knew it could be so hard to install a PCI hardware RAID controller in an Xserve G5?  Well, I learned about this unexpected difficulty today.  I write about it here because I think the experience may be useful to others.  </p>
<p>The task for today was to upgrade from a single 80GB SATA drive to 3 80GB SATA drives in a hardware RAID-5 configuration.  (I chose the hardware RAID solution because I just don't quite trust software RAID.)  I really didn't this task would be as challenging as it turned out to be.  The first major roadblock came when I discovered that I needed a video card installed in order to perform the reinstallation of Mac OS X Server.  You see, Xserve G5s don't come equipped with video cards.  These are entirely optional.  Now, that wouldn't normally be a problem, as I would perform the installation on my powerbook, with the Xserve in Firewire Target Disk Mode.  However, because the new drives would be connected to the new PCI RAID controller, and not the main SATA controller, Firewire Target Disk Mode would not work.  The only way to do the install was to use a PCI video card.  So, I ran down to the local Mac store and picked up an ATI Radeon 9200 PCI ME w&#47; 128MB DDR.  (Yes, quite a bit of overkill for my purposes, but it was all that was available.  The Xserve booted up to the new video card just fine and I thought that was the last of my challenges.</p>
<p>However, in order to set up the RAID array, I needed the "megaraid" command line utility, which required the Mac OS X Server (10.3.5) Install CD, and I only had the 10.3.3 CD.  I thought I would have to get a newer CD shipped to me, but then I thought to check if perhaps I had the megaraid utility on my 10.3.9 install on my PowerBook.  I was pleased to find that I did and promptly connected my PowerBook in Firewire Target Disk Mode to the Xserve and booted up to the PowerBook HD.  It worked like a charm!  The megaraid utility picked up the controller and all three disks, and a quick "megaraid -create auto" gave me a new RAID-5 volume.</p>
<p>Now I thought I had it made.  Now that the array had been configured, the installation CD would see the disk and I could finish the install.  I was mistaken.  Not only did the 10.3.3 CD lack the "megaraid" command line utility, it lacked the RAID controller drivers, so no disks were detected on boot.  My next attempt involved creating a custom installation CD by making an image of the original CD and copying the kext from my PowerBook into it.  Unfortunately, this new Frankenstein CD resulted in a kernel panic and I finally realized I would have to give up and call Apple for a newer CD.</p>
<p>Sad ending, isn't it?  I really got creative and thought I had it licked so many times.  I investigated a serial console installation, ssh-based remote install, ASR, netboot, etc., but I had to get that video card.  And I managed to keep overcoming the hurdles put in front of me, but then to be set back in the end was a real bummer.</p>
<p>Well, on the way home, I realized I had one more option.  And I really wish I would've thought of this sooner, because I think it has a real chance of working.  I should be able to boot up to my 10.3.9 (non-Server) installation on my PowerBook again from the Xserve and format the array and perform the install from the CD by simply installing the .mpkg on the CD.  I had to do the same thing in order to get the Tiger WWDC build to install on my 17" PowerBook.  Anyway, I think it has a real chance, but we'll see.  Anyway, I hope this story has helped someone else out there with this task.  Remember, you need a video card.  Also, make sure you have the Mac OS X Server 10.3.5 or higher installation CDs.</p>
