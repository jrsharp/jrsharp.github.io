---
status: publish
published: true
title: Installing Tiger on Lombard
author:
  display_name: admin
  login: admin
  email: jon@jonsharp.net
  url: http://jonsharp.net
author_login: admin
author_email: jon@jonsharp.net
author_url: http://jonsharp.net
wordpress_id: 63
wordpress_url: http://jonsharp.net/archives/2005/05/06/installing-tiger-on-lombard/
date: '2005-05-06 07:49:00 -0500'
date_gmt: '2005-05-06 12:49:00 -0500'
categories: []
tags: []
layout: page
comments:
- id: 2243
  author: John Sawyer
  author_email: johnsawyercjs@yahoo.com
  author_url: ''
  date: '2005-05-11 03:05:05 -0500'
  date_gmt: '2005-05-11 08:05:05 -0500'
  content: This is a brilliantly simple hack--other people who have installed Tiger
    onto Lombards using other methods, have reported no trouble, so this should work
    fine.  However, changing the "badmachine" listing to &acirc;&euro;&oelig;PowerBook3,1&acirc;&euro;&sup3;prevents
    the DVD from installing onto a Powerbook G3 Firewire (Pismo).  Why not just delete
    the reference to Powerbook1,1 altogether?  By the way, "Powerbook2,1" is the first
    clamshell iBook, which I suspect will run Tiger just fine too, so might as well
    delete that too.
- id: 2245
  author: admin
  author_email: jon@jonsharp.net
  author_url: http://jonsharp.net
  date: '2005-05-11 06:24:19 -0500'
  date_gmt: '2005-05-11 11:24:19 -0500'
  content: "John,\r\n\r\nI meant to mention that I thought it probably would have
    worked by simply removing the reference altogether.  In fact, it may work if the
    entire array was cleared out.  The reason I simply changed the one byte of text
    was because I was unsure about what tamper protections might be in place -- I
    was concerned about throwing some checksum off.  But yes, I do think it would
    work if removed altogether.  I just didn't want to waste too many DVDs if I was
    wrong on that. :)"
- id: 2255
  author: Gary Moler
  author_email: fire@cameo.plala.or.jp
  author_url: http://http//:www12.plala.or.jp/garymoler
  date: '2005-05-12 03:26:42 -0500'
  date_gmt: '2005-05-12 08:26:42 -0500'
  content: I've been trying to install Tiger on my fire-wireless Graphite iBook (probably
    what you mentioned as being a "Powerbook2,1") with no luck. I used Disk Utility
    to create and mount the DVD Master Image of Tiger, hen I used Pacifist to open
    the "OSinstall.mpkg" and find the "Contents" file. However, I was unable to locate
    any "OSintall.dist" or "badmachines" list or any "Powerbook2,1" (Spotlight was
    unable to locate any of these files as well). Would you kindly verify the path
    and&#47;or software needed to get at the "badMachines" list? After fixing the
    disk image I plan to upload it via LAN to a new partition on my iBook HD, try
    to install it on another partition (no DVD-ROM -- do you think that would work?),
    and see how well Tiger can roar...
- id: 2256
  author: admin
  author_email: jon@jonsharp.net
  author_url: http://jonsharp.net
  date: '2005-05-12 06:46:42 -0500'
  date_gmt: '2005-05-12 11:46:42 -0500'
  content: "Gary,\r\n\r\nWell, I've never used Pacifist.  In this case, I simply used
    the command line to navigate the contents of OSInstall.mpkg.  The path above is
    correct.  The filename is OSInstall.dist.  The line you are looking for is:\r\n\r\nvar
    badMachines = ['iMac','PowerBook1,1','PowerBook2,1', 'AAPL,Gossamer', 'AAPL,PowerMac
    G3', 'AAPL,PowerBook1998', 'AAPL,PowerBook1999'];\r\n\r\nIn my case, I just used
    Vim to edit the file.  But if you are more comfortable with BBEdit or another
    editor, just type \"open OSInstall.dist\" from the command line to attempt to
    open it in your default editor.\r\n\r\nAnyway, let me know if that helps.  I'd
    be interested to know if it does."
- id: 2261
  author: Gary Moler
  author_email: fire@cameo.plala.or.jp
  author_url: http://http//:www12.plala.or.jp/garymoler
  date: '2005-05-12 13:04:47 -0500'
  date_gmt: '2005-05-12 18:04:47 -0500'
  content: Sorry to ask such basics... I've been an OS9Forever person until now. I
    tried using Terminal and Vim (for the first time) to find the "OSInstall.dist"
    file and can't do it. Vim's "Open..." command can't open the OSInstall.mpkg. Pacifist,
    on the other hand, can unpack it but can't see the "OSInstall.dist" file. Could
    you tell me the commands and where (or how) to use them to get to my destination?
    Thanks... sorry OS X newbees are such dummies.
- id: 2267
  author: Barthold Van Acker
  author_email: barthold.van.acker@mac.com
  author_url: ''
  date: '2005-05-12 19:30:25 -0500'
  date_gmt: '2005-05-13 00:30:25 -0500'
  content: "It's even more easy to edit the bad machines list.\r\n\r\nJust open the
    contents of the installation package OSInstall.mpkg by ctrl-clicking the package
    file in the Finder and choosing the option Show Package Contents in the popup
    menu list. A Finder window will show the package contents. Open the Contents folder
    and find in a glimpse the file OSInstall.dist.\r\n\r\nOpen this file with TextEdit.
    Look for the line with the text 'var badMachines ...', below the text 'function
    checkSUpportedMachine...', at the beginning of this file, which, by the way, is
    a scripting code file used by the installation application.\r\n\r\nThrow away
    any 'bad' machine out of the list within the square brackets. Take care to keep
    the remaining names, within two single quotes, in the list separated by a comma
    (no comma at the beginning and at the end of the list, please). And certainly
    do not throw away this variable declaration line. Keep it at least in a minimal
    form: var badMachines= []; (an empty list of bad machines), and no problem will
    ever arrive, except perhaps for the installation of that Tiger on a truly incompatible
    machine. Bad machines do exist.\r\n\r\nYou can also try this, for the daredevil
    between you people: adapt the function that checks for a bad machine in such a
    way that it will always like any machine it finds. It's easy to do so: just throw
    away the whole shebang in the function body of that function except fo the last
    line with the code 'return true;' (keep the semicolon at the end!).\r\n\r\nHow
    to, would you say. Well, find in the OSInstall.dist file the line of text 'function
    checkSupportedMachine(machineType){', just above the line with the list of bad
    machines ('var badMachines = ...'). And then throw away the lines of text starting
    with the text 'var badMachines' right through the line before the first line of
    text that has the code 'return true;' j(ust below the line '&#47;&#47; if we can't
    find it, ...'). Keep the text 'return true;', a line of code necesary to have
    the installation software to like any machine.\r\n\r\nYou can even keep the line
    of text '&#47;&#47; if we can't find it, ...'. It's just a line of comment in
    the code. But then, again, do not throw away the two slashes at the beginning
    of that line of text, or it's no comment anymore.\r\n\r\nAnd, if you're a kind
    of tabula rasa-type, you can do the same with the function that checks for a supported
    boot-ROM. But I suppose this will certainly give some apr&Atilde;&uml;s-ski problems...\r\n\r\n:-)\r\n\r\nP.S.
    More funny: replace any bad machine in the list by some other names, like e.g.
    the name of your mother-in-law, your boss, the attorney of your wife, ..."
- id: 2274
  author: admin
  author_email: jon@jonsharp.net
  author_url: http://jonsharp.net
  date: '2005-05-13 11:47:34 -0500'
  date_gmt: '2005-05-13 16:47:34 -0500'
  content: "Barthold,\r\n\r\nThank you so much for your comment. My instructions needed
    some clarification. I take some things for granted sometimes. I also really like
    your ideas for modifying the function in other ways&acirc;&euro;&brvbar; very
    creative. Thanks again for sharing!\r\n\r\nGary,\r\n\r\nI hope this extra info
    helps you out, too.  If it doesn't, feel free to email me.\r\n\r\nThanks,\r\nJon"
- id: 2285
  author: Bob Fechner
  author_email: bobsport7@aol.com
  author_url: http://jonsharp.net/archives/2005/05/06/installing-tiger-on-lombard/
  date: '2005-05-14 18:11:05 -0500'
  date_gmt: '2005-05-14 23:11:05 -0500'
  content: "Jon,\r\nI have been using my Lombard since 1999 and have upgraded my hard
    drive, RAM and my processor to a Daystar G4 and have updated my Mac OS to the
    latest version as soon as Apple released it.  I have installed Tiger on my 3 other
    machines at home since they were all supported.  \r\n\r\nMy dilemma with your
    \"fix\" is that I probably need a \"step by step\" instruction on how to do this.
    \ I kind of got \"lost\" in your explanations on your website.  Now my other 3
    Machines all have DVD-Rom's so I am not sure what hardware i need to buy to make
    this DVD thing work.  I know I could probably send away for the Apple CD Installer
    and this might be easier.  Any detailed help you can give me would certainly be
    aprreciated.  I am sure there a lot of Lombard people like me that would like
    to install Tiger.\r\n\r\nAny help regarding this issue would be appreciated.\r\n\r\nThank
    you."
- id: 2305
  author: Barthold Van Acker
  author_email: barthold.van.acker@mac.com
  author_url: ''
  date: '2005-05-16 14:41:05 -0500'
  date_gmt: '2005-05-16 19:41:05 -0500'
  content: "John, and others, I have 3 things extra to say now.\r\n\r\nFirst of all,
    an installation of Tiger succeeded on my Powerbook Lombard (bad machine name 'Powerbook1,1\").
    And everything seems to work very well. The first time, after installation, it
    takes some time to get started. I suppose there are some after-installations arrangements
    to clear out. Also, do not be annoyed by some initial delays when interacting
    with the machine, for Spothlight is doing some first run through indexing the
    contents of your files.\r\n\r\nThen, secondly: before you can make changes in
    the OSInstall.dist file, it is essential to convert the disk image of the installation
    dvd into a read-write version with Disk Utility. You can then choose afterwards
    to make it a read-only version again or to leave it read-writable to be able to
    change some things afterwards.\r\n\r\nAnd, thirdly, I got the strange message,
    even after tweaking the OSInstall.dist file, that the modified installation dvd
    didn't want to upgrade the system because it was not compatible. I was confused.
    But then, again, after restarting the machine and holding down the C key (you
    can also choose the dvd as startup disk before restarting), the installation started
    whithout any problem and everything was installed as normal.\r\n\r\nI do not understand
    this well. I suppose there must be perhaps another check somewhere, although,
    as till now I did not find one. Or perhaps the system on my Powerbook remembered
    a first trial with the original installation dvd? I'm trying to work that out.
    If I find something, I'll let you know."
- id: 2317
  author: Aaron Turner
  author_email: turner.543@osu.edu
  author_url: ''
  date: '2005-05-17 09:00:48 -0500'
  date_gmt: '2005-05-17 14:00:48 -0500'
  content: I have tried all of these methods to no avail. So far, every DVD that i
    create becomes a worthless coaster!! Heres how I modified the OSInstall.dist---I
    copied the entire .mpkg onto the desktop from the disk image, then modified the
    file and moved the .mpkg back into the disk image, then burned it using disk utility.
    What am I doing wrong?? Just for reference, I am attempting to install on two
    unsupported machines; the Powerbook Lombard (Powerbook 1,1) and the PowerMac G3
    Beige (AAPL Gossamer). Any help would be greatly appreciated!! Thanks
- id: 2318
  author: admin
  author_email: jon@jonsharp.net
  author_url: http://jonsharp.net
  date: '2005-05-17 09:56:54 -0500'
  date_gmt: '2005-05-17 14:56:54 -0500'
  content: Barthold, thank you so much for your continued research on this.  I know
    that many others here will benefit from your efforts.
- id: 2319
  author: admin
  author_email: jon@jonsharp.net
  author_url: http://jonsharp.net
  date: '2005-05-17 09:59:42 -0500'
  date_gmt: '2005-05-17 14:59:42 -0500'
  content: Bob, I apologize if my instructions are not clear.  I will have to post
    a new blog entry with step-by-step instructions like one might find on <a href="http:&#47;&#47;macosxhints.com"
    rel="nofollow">macosxhints.com<&#47;a>.  I'll try to do this when I get back home
    and have the original DVD with me so that I can step through it myself again.
    In the meantime, perhaps some of Barthold's insight would be useful to you.  I'll
    try to post something new shortly.
- id: 2320
  author: admin
  author_email: jon@jonsharp.net
  author_url: http://jonsharp.net
  date: '2005-05-17 10:03:25 -0500'
  date_gmt: '2005-05-17 15:03:25 -0500'
  content: "Aaron,\r\n\r\nI am sorry to hear about the coasters.  I don't know if
    copying the file out and moving it back into the disk image is causing your trouble,
    but when I did it, I modified the file within the image itself.  I believe that
    when I created the image, I specified \"CD&#47;DVD Master\" in Disk Image.  Like
    I told Bob, I'm going to try to post a more clear entry this evening with step-by-step
    instructions.  Perhaps this will help clear up some of these issues.  In the meantime,
    perhaps this helps a bit.  Let me know.  Thanks!"
- id: 2350
  author: d'Artagnan
  author_email: ''
  author_url: ''
  date: '2005-05-26 16:07:40 -0500'
  date_gmt: '2005-05-26 21:07:40 -0500'
  content: "WARNING WARNING WARNING!\r\n\r\nI followed the instructions and got a
    working install DVD. Booted the lombard\r\nfrom the DVD and began installation.
    About 30 minutes later, while installing\r\nMail, the installation process crapped
    out. The installer log provided a helpful\r\n\"child died with signal 10\". \r\n\r\nAttempting
    to re-install failed. When booting from the DVD, the process stopped \r\nat the
    initial grey screen with the little pinwheel circling forever. When booting from\r\nthe
    half-upgraded hard disk, a kernel panic gets barfed to the screen with \"cannot\r\nfind
    driver for powerbook1,1\". \r\n\r\nMake very very sure you have your 10.3 installation
    disks before attempting this\r\ntiger upgrade. Don't know what happened during
    upgrade, but I'll be trying it\r\nagain as soon as my book comes back to life."
- id: 2362
  author: Hiro
  author_email: bombo@mac.com
  author_url: http://www.kubota-ke.jp/hiro/
  date: '2005-05-27 05:15:23 -0500'
  date_gmt: '2005-05-27 10:15:23 -0500'
  content: "Aaron,\r\nIn my case,  RAM was the crucial point. \r\nmy lombard&#47;333
    MHz with 512 MB ram did not boot the tewaked DVD,  but set back to 320 MB, the
    DVD boots.\r\nAfter installaing Tiger, 512 MB ram works fine."
- id: 2704
  author: Grady
  author_email: ''
  author_url: ''
  date: '2005-06-18 16:43:56 -0500'
  date_gmt: '2005-06-18 21:43:56 -0500'
  content: "I can't find the file to edit. When I open the DVD>System>Installation>Packages>OSinstall.mpkg
    I see the content folder. I open that, and I only have three files.\r\n\r\nFile
    one: Info.plist\r\nFile two: Version.plist\r\nAnd file three is a folder called
    \"resources.\"\r\n\r\nWhen I top the Resources folder, it just gives me a bunch
    of other language folders. I don't see the list of 'bad machines'. \r\n\r\n"
- id: 2706
  author: Grady
  author_email: Grady_123@hotmail.com
  author_url: ''
  date: '2005-06-18 16:49:07 -0500'
  date_gmt: '2005-06-18 21:49:07 -0500'
  content: 'I can''t find the file to edit. When I open the Mac OS X Tiger DVD>System>Installation>Packages>OSinstall.mpkg
    I see a folder called "contents." When I open that folder, I only see three files.
    One called, Info.plist another called version.plist and a folder entitled, "Resources."
    Could it be somewhere else? '
- id: 2717
  author: Devin Frank
  author_email: dgf@devinfrank.com
  author_url: ''
  date: '2005-06-19 01:06:00 -0500'
  date_gmt: '2005-06-19 06:06:00 -0500'
  content: 'I can confirm that this procedure also works with the installation CDs.
    I sucessfully installed Tiger on my Lombard 333 Mhz, which does not have a DVD
    drive. Overall performance on this machine (with 320MB RAM) is quite good.   '
- id: 2893
  author: Ran
  author_email: rfriedline@hotmail.com
  author_url: ''
  date: '2005-06-27 15:55:18 -0500'
  date_gmt: '2005-06-27 20:55:18 -0500'
  content: I must concur with Grady - I also have no OSInstall.dist file in my installation
    CD's.  Hence, I can not install on my g3 350 (no USB&#47;firewire).  Any other
    solutions?
- id: 2909
  author: ''
  author_email: ''
  author_url: ''
  date: '2005-07-04 11:43:22 -0500'
  date_gmt: '2005-07-04 16:43:22 -0500'
  content: Has anybody successfully installed Tiger on a Lombard with a G4 processor
    upgrade? Mine has a PowerLogix G4 in it, and my Tiger installation also crashed.
    I'm reinstalling Panther now, and preparing for a second try.
- id: 2910
  author: Rob
  author_email: rob.green@att.net
  author_url: ''
  date: '2005-07-04 11:45:39 -0500'
  date_gmt: '2005-07-04 16:45:39 -0500'
  content: Has anybody successfully installed Tiger on a Lombard with a G4 processor
    upgrade? Mine has a Powerlogix G4 card in it, and my installation crashed in a
    way similar to what d'Artagnan describes above. I'm reinstalling Panther now,
    and readying for a second try.
- id: 2915
  author: diego
  author_email: ''
  author_url: ''
  date: '2005-07-11 15:45:13 -0500'
  date_gmt: '2005-07-11 20:45:13 -0500'
  content: I just bought a G4powerbook and now I want to upgrade my dual mirrordoor
    Powermac with the powerbook's install&#47;restore DVD. But, it does not allow
    installation.  I suspect the the disc is trying to find a powerbook. Is there
    a similiar work around for this problem? Is there a scipt that I could erase&#47;modify
    so the disc could be universal and not powerbook specific?
- id: 2917
  author: Tim
  author_email: tjlazer@rainierconnect.com
  author_url: ''
  date: '2005-07-26 00:41:58 -0500'
  date_gmt: '2005-07-26 05:41:58 -0500'
  content: I used the idea here on my PowerBook G4 15" Tiger DVD and with some fiddling
    finally got it to work.  Following the instructons above would not work for me,
    it still reported my machine was not supported.  I had to do more than just delete
    the badcomputer names, I removed the whole check for bad machines and other checks,
    then it installed fine.  I did have to format my old HD as it had some errors
    on it and reported errors, but after a full format it installed fine!
- id: 2918
  author: Tim
  author_email: tjlazer@rainierconnect.com
  author_url: ''
  date: '2005-07-26 00:47:59 -0500'
  date_gmt: '2005-07-26 05:47:59 -0500'
  content: I followed the instructions and it did not work.   With some fiddling I
    was able to get it to work.  I removed ALL the code that checks for bad machines
    and the other checks! (Boot rom) It then proceeded to install then ran into an
    error verifying my 20GB HD, I reformatted it and it then finished fine!  Tiger
    runs great on my Lombard G3 333 with 384MB!  I am still trying to find a 256MB
    module that actually works to get 512MB....
- id: 3042
  author: Fred
  author_email: ''
  author_url: ''
  date: '2005-09-05 15:12:35 -0500'
  date_gmt: '2005-09-05 20:12:35 -0500'
  content: Thinking abou trying to install Tiger on my Lomard, but I'm wondering does
    Tiger run faster or slower than Panther on the Lombard machines?
- id: 3096
  author: admin
  author_email: jon@jonsharp.net
  author_url: http://jonsharp.net
  date: '2005-09-24 15:29:13 -0500'
  date_gmt: '2005-09-24 20:29:13 -0500'
  content: "Fred,\r\n\r\nI've got to say that Tiger probably runs slower than Panther
    on my Lombard.  I'm actually writing this post from my Lombard now and I'm using
    10.3.9.  I think I'll stick with this for now.\r\n\r\nThanks,\r\nJon"
- id: 3109
  author: David F
  author_email: dfcarsearch@earthlink.net
  author_url: ''
  date: '2005-09-28 21:31:50 -0500'
  date_gmt: '2005-09-29 02:31:50 -0500'
  content: "Hi gang, I have two legit Tiger DVD's one is from my G5 dual the other
    is from my imac 2.0 I tried the hack but I have three issues...\r\n1. the G5 Dual
    DVD is 3.9gb I notice it says some things about powermac:\r\nfunction checkSupportedMachine(machineType){\r\nvar
    badMachines = ['iMac','PowerBook1,1','PowerBook2,1', 'AAPL,Gossamer', 'AAPL,PowerMac
    G3', 'AAPL,PowerBook1998', 'AAPL,PowerBook1999'];\r\n\r\nand a little further
    down:\r\nif(machineType){\r\nvar length = badMachines.length;\r\n\r\n&#47;&#47;
    Fail if any of the compatible values match the list of badMachines\r\nfor( var
    j = 0; j < length; j++ ){\r\nif(machineType == badMachines[j]){\r\nreturn false;\r\n}\r\n\r\nFinally
    it says:\r\nfunction checkSupportedBootRom(machineType){\r\nvar machinesNeedingROMUpdate
    = new Array();\r\nmachinesNeedingROMUpdate['Powermac1,'] = 'f2';\r\nmachinesNeedingROMUpdate['Powermac1,']
    = '$0003.30f3';\r\nTHE POWERMAC PART SAID SOMETHING LIKE THAT I CAN'T REMEMBER\r\n\r\n2.
    when I burn a dvd how do I set up Toast 6.0 or disk utility to burn correctly?\r\nYour
    help is appreciated....\r\n3. The imac DVD is 5.6 gb so does that need a D&#47;L
    DVD? Thanks again.."
- id: 3110
  author: David F
  author_email: dfcarsearch@earthlink.net
  author_url: ''
  date: '2005-09-29 01:52:32 -0500'
  date_gmt: '2005-09-29 06:52:32 -0500'
  content: Hi I have two tiger dvd's one for the powermac dual and the other for the
    17" imac 2.0 and some of the wording is different on the powemac install vs. your
    description and the imac tiger is a 5.6 gb vs 3.9 for the powermac version. Can
    anyone help out on what to eliminate on the powermac dvd? basically it lists bad
    machines but below that there something about the bootrom version wonder how that
    works... Finally as stupid as it sounds I don't quite understand the correct method
    of burning the final dvd I have toast 6.0 and disk utility can anyone explain
    please?
- id: 3173
  author: Yaw Nti-Addae
  author_email: ntiaddae@aol.com
  author_url: ''
  date: '2005-11-29 11:52:13 -0600'
  date_gmt: '2005-11-29 16:52:13 -0600'
  content: hello, I'm a new Mac user. I found the OSInstall.dist file with no problem
    and edited the line. but the problem is that since i'm editing a package, i am
    unable to save the edited file. my guess is that there should be a way to make
    either the file or the package editable. would really appreciate your comment.
    thanks.
- id: 3239
  author: Steve W
  author_email: sw_junk@hotmail.com
  author_url: ''
  date: '2005-12-08 02:41:33 -0600'
  date_gmt: '2005-12-08 07:41:33 -0600'
  content: "Exact same problem as Yaw Nti-Addae here.  Disk Utility doesn't let me
    convert disk to read-write, and tried batChmod, too, but still couldn't overwrite
    OSInstall.dist, or delete it at all.  Trying to save edited file from finder just
    returns \"can't overwrite file\" messages.\r\n\r\nThis is with the Tiger DVD that
    came with a new iMac iSight, and a disk image on an external firewire drive."
- id: 3240
  author: Paul Eident
  author_email: ''
  author_url: ''
  date: '2005-12-08 10:09:21 -0600'
  date_gmt: '2005-12-08 15:09:21 -0600'
  content: "Thanks Jon.  Your instructions were great.  I'm running Tiger on my 400
    Mhz Lombard.  This is what I did.\r\n\r\nI used Disk Utility to make a DVD&#47;CD
    master disk image.  Then I mounted the image.  I opened Terminal and typed >cd
    &#47;Volumes. Then typed >ls to view the contents of the directory. Found the
    \"Mac OSX Install DVD\". Then typed >cd 'Mac OSX Install DVD'&#47;System&#47;Installation&#47;Packages&#47;OSInstall.mpkg&#47;Contents.
    \ Typed >ls to view the contents and saw the \"OSInstall.dist\" file.  Then I
    typed >vi OSInstall.dist .  This allowed me to edit the file in VI.  It's easy
    to navigate using the arrows and delete.  press \"i\" to enter Insert mode to
    type characters.  Then type :wq to write and quit.  After I made my edits as stated
    in the first post, I quit Terminal, put the mounted disk image in the trash, then
    used Disk Utility to create a new disk image from the modified OSX Install image.
    \ Put the newly created DVD in my Lombard and booted from the CD ROM.  Ran the
    install and I was done.  The whole process took about two hours to create the
    image, modify, burn and install.\r\n\r\nI'm going to try your battery trick next.\r\n\r\nThanks\r\nhttp:&#47;&#47;www.aslaninteractive.com"
- id: 3262
  author: Jim
  author_email: jameselove@mac.com
  author_url: ''
  date: '2006-01-15 15:38:41 -0600'
  date_gmt: '2006-01-15 20:38:41 -0600'
  content: "I have been up all night and I cannot find \" ... the OSInstall.dist file
    in &#47;System&#47;Installation&#47;Packages&#47;OSInstall.mpkg&#47;Contents on
    the image. Near the top of the file is a line that specifies a list of &acirc;&euro;&oelig;badMachines&acirc;&euro;\x9D,
    or some such. \" I have tried Text Edit and BBEdit ..... \r\n\r\nJust tired ..........
    \  Trying to install Tiger on my original Tangerine iBook  .....   \r\nJim\r\n\r\n"
- id: 3263
  author: Jim
  author_email: jameselove@mac.com
  author_url: ''
  date: '2006-01-16 03:10:33 -0600'
  date_gmt: '2006-01-16 08:10:33 -0600'
  content: "I found it! .... I found it!  I changed the &acirc;&euro;&trade;PowerBook2,1&acirc;&euro;&sup2;
    ... to 'PowerBook3,1'  since I am trying to install Tiger onto my original Tangerine
    iBook .... and burned the DVD and it still said that \"Mac OS X 10.4 cannot be
    installed on this machine\" when I tried running it by double clicking the Install
    Mac OS X icon. It said \"Mail cannot be installed on this computer. This software
    cannot be installed on this computer\" when I tried double clicking the Optional
    Istalls Installer. It said \"BaseSystem cannot be installed on this computer.
    This software cannot be installed on this computer.\" when I tried double clicking
    on the OSInstall.mpkg icon. I am running the modified DVD Intall disc a Sony Dual
    RW Double Layer (Firewire&#47;USB) external drive connected to my iBook via its
    one and only USB connection .... and I cannot get it to Start Up via this modified
    disc ....  Should I just give up ???????????   Jim\r\n"
- id: 3351
  author: Dexter
  author_email: dextepayne@aol.com
  author_url: ''
  date: '2006-02-28 07:26:49 -0600'
  date_gmt: '2006-02-28 12:26:49 -0600'
  content: "Great info! I have an iMac G5 Tiger install disc that was sold with the
    promise of compatability with all macs using Pacifist. Problem is, on my G4 powermac
    the Combo drive does not read the DVD. Any one have a way to work around that?\r\n\r\nThanks,\r\nD"
- id: 3370
  author: Pat B
  author_email: stairways@eircom.net
  author_url: ''
  date: '2006-03-02 14:49:20 -0600'
  date_gmt: '2006-03-02 19:49:20 -0600'
  content: I followed the instructions above and am delighted to now have a Lombard
    running Tiger very smoothly. The only problem is - and it's a big one - I cannot
    connect to the net (am writing this now on my Powerbook G4). Obviously I have
    no AirPort option, but I can't connect wireless using my RoamAbout PC Card and
    Tiger-supporting IOXperts driver) or even using Ethernet cable directly to my
    ADSL modem router. I can see the modem router recognises the Ethernet LAN connection,
    and the Network Preferences say Etnernet connection made but can not connect to
    the internet. And I have absolutely no idea why. Any suggestions would be really
    welcome.
- id: 3463
  author: Ben McCourt
  author_email: ''
  author_url: ''
  date: '2006-03-15 02:58:36 -0600'
  date_gmt: '2006-03-15 07:58:36 -0600'
  content: "Along with the hack listed at the top, you need to remove this reference
    in order to skip the machine check.\r\n\r\n\r\n\r\nChange it to:\r\n\r\n\r\n\r\n\r\nThis
    neuters the script which checks to see if your machine is the right one for the
    disk ( if for example you are using an iMac disk for a PowerBook or something
    ).\r\n\r\nhappy installing!"
- id: 3464
  author: Ben McCourt
  author_email: ''
  author_url: ''
  date: '2006-03-15 03:00:35 -0600'
  date_gmt: '2006-03-15 08:00:35 -0600'
  content: "Above should say:\r\n\r\n''\r\n\r\nChange it to:\r\n\r\n''\r\n\r\n(without
    the ' and the space between "
- id: 3465
  author: Ben McCourt
  author_email: ''
  author_url: ''
  date: '2006-03-15 03:01:19 -0600'
  date_gmt: '2006-03-15 08:01:19 -0600'
  content: "installation-check script=\"hwbeInstallCheck()\"&#47;\r\n\r\ninstallation-check
    script=\"\"&#47;"
- id: 3519
  author: Eli
  author_email: emt@emtweb.net
  author_url: ''
  date: '2006-03-19 23:17:59 -0600'
  date_gmt: '2006-03-20 04:17:59 -0600'
  content: "Does anyone know how to follow the same process, but instead to use it
    for OS X 10.4, for OS X 10.3? I have a lombard where I need to install OSX 10.3.
    I have follow the process described in this page (it did work for OS X 10.4) but
    I need something similar for OS X 10.3. \r\n\r\nAnyone has any ideas? Thanks!!"
- id: 3586
  author: Spud
  author_email: ''
  author_url: ''
  date: '2006-03-29 08:14:29 -0600'
  date_gmt: '2006-03-29 13:14:29 -0600'
  content: "You there is another check for supported machines towards the bottom of
    the OSInstall.dist file.\r\n\r\n         var hwbeSupportedMachines = ['\r\n\r\n"
- id: 3610
  author: admin
  author_email: jon@jonsharp.net
  author_url: http://jonsharp.net
  date: '2006-04-02 22:53:30 -0500'
  date_gmt: '2006-04-03 03:53:30 -0500'
  content: "Eli,\r\n\r\nThe Lombard is fully supported by Mac OS X 10.3 (Panther).
    \ You shouldn't have to do anything special.  This hack is just for 10.4 (Tiger),
    which has dropped (official) support for the PowerBook G3 Lombard.\r\n\r\n--\r\nJon"
- id: 3611
  author: admin
  author_email: jon@jonsharp.net
  author_url: http://jonsharp.net
  date: '2006-04-02 23:06:46 -0500'
  date_gmt: '2006-04-03 04:06:46 -0500'
  content: "Pat,\r\n\r\nI'm not sure about your networking trouble.  I never had any
    trouble with mine.  For the record, I'm using a Cisco Aironet 350 PCMCIA 802.11b
    WiFi card and both it and my built-in Ethernet adapter work fine under Tiger.
    \ In fact, I'm using the Cisco card on it right now to post this message.  I'm
    using the latest Cisco drivers.  (Officially only supported up to 10.2 (Jaguar),
    but seem to work just fine under Panther and Tiger)\r\n\r\nThe only thing I might
    recommend is zapping your PRAM, etc. and seeing if that clears it up.  Also, have
    you been working inside your PowerBook recently?  Perhaps you disconnected the
    wired ethernet connector from the logic board?  I did that once and it took me
    a while to figure it out.  I thought for sure I'd killed the thing.\r\n\r\nAnyway,
    I hope it works out for you.\r\n\r\n--\r\nJon"
- id: 3787
  author: Pete
  author_email: camel@hotmail.com
  author_url: ''
  date: '2006-05-02 15:56:17 -0500'
  date_gmt: '2006-05-02 20:56:17 -0500'
  content: "Would it be possible to just change the list of hwbesupportedmachines
    as mentioned by spud to include your machine?\r\n\r\nthat is if it is not on the
    list of bad machines..\r\n\r\ni.e. I have install discs that are specific to a
    machine (ibook 1.33GHz aka powerbook6,7) . If I was to change the list of hwbesupportedmachines
    from powerbook6,7 to powerbook6,5 would I then have an install disc that would
    work and be specific to an ibook 1.04 GHz?"
- id: 3792
  author: paris
  author_email: paris@cperi.certh.gr
  author_url: ''
  date: '2006-05-03 23:37:47 -0500'
  date_gmt: '2006-05-04 04:37:47 -0500'
  content: "High all,\r\nI found this blog very exciting because despite all odds
    I still refuse to abandon my trusty lombard! Just couple of years I had to do
    a brain transplant when the original CPU died due to a bad solder. Then I installed
    a G4 powerlogic update after solving some of the heat related problems that hwoever
    did this knows well about, I installed Tiger shortly after release and I been
    following updates up to 10.4.3. For some reason I did not try to update further
    as it was not my primary powerbook anymore. The other night I was feeling lucky
    and foolishly without first backing up I gave the 10.4.5 a try. I wont go further
    to horrible detail. This post is mainly to inform that this configuration Lombard
    G4 384 RAM was fine with 10.4.3. The thing I wantted to ask is what is the succesfull
    install beyond that 10.4.4? If I find it myself I will be happy to share!\r\nPS.
    I will try to revive my machine. How I hate when this s... happens!"
- id: 3835
  author: admin
  author_email: jon@jonsharp.net
  author_url: http://jonsharp.net
  date: '2006-05-08 09:10:21 -0500'
  date_gmt: '2006-05-08 14:10:21 -0500'
  content: "paris,\r\n\r\nI have 10.4.5 running on my Lombard right now (as well as
    several other very unsupported machines).  It was just updated incrementally from
    10.4.1, I think.  I don't know what could've gone wrong w&#47; yours, but it could
    be anything, I suppose.  Let us know what you find out.\r\n\r\n--\r\nJon"
- id: 3836
  author: bngwolfe
  author_email: bryan@coconutcreations.com
  author_url: ''
  date: '2006-05-08 09:24:15 -0500'
  date_gmt: '2006-05-08 14:24:15 -0500'
  content: "Jon,\r\n\r\nYou mentioned in a previous post that you would try to get
    a \"how to\" posted? Have you been able to do so? Also I can change the file and
    have deleted files which I don't plan on installing (primarily to cut down disk
    image size) so that I can burn it to a regular 4.7 DVD. But I can't seem to copy
    the image and change the file size. Any way to do so?"
- id: 3872
  author: Xaja
  author_email: dimmadip@gmail.com
  author_url: ''
  date: '2006-05-10 22:39:50 -0500'
  date_gmt: '2006-05-11 03:39:50 -0500'
  content: OK - I am brand new to MACs completely and inherited a Lombard &amp; Tiger
    dvd.  I dont have Disk Utility (I think), but want to upgrade to Tiger from OS9.  I
    am able to see the OSInstall.dist - but when I try to mount the contents.mpkg,
    I get a  'does not have a recognized file type'.  HELP!  I wanna use this machine!
- id: 5246
  author: Mike
  author_email: mike3@mac.com
  author_url: ''
  date: '2006-06-12 15:51:45 -0500'
  date_gmt: '2006-06-12 20:51:45 -0500'
  content: "Do you have a step by step of this process available?\r\nId like to try
    this install ASAP.\r\nPlease email me the step by step if you can.\r\nMuch Appreciated.\r\n\r\nThanks!\r\n"
- id: 14031
  author: Gazzer
  author_email: ''
  author_url: http://mac.bloxio.us
  date: '2006-11-24 03:33:49 -0600'
  date_gmt: '2006-11-24 08:33:49 -0600'
  content: "A late comment but another way is to look at the check functions and simply
    add return true; at the beginning of them:\r\n\r\nfunction check_something(){\r\nreturn
    true;\r\n\r\n\r\n}\r\n\r\nThen it simply ensures that true (i.e. OK ) is returned
    for each check."
- id: 14102
  author: Matthew
  author_email: adonisdionysus@yahoo.com
  author_url: http://JonSharpITconsulting
  date: '2006-11-26 18:41:22 -0600'
  date_gmt: '2006-11-26 23:41:22 -0600'
  content: I have no problem finding the OSInstall.Dist in the OSInstall.mpkg I just
    dont know how to make a CD&#47;DVD Master Image. I know what Disk Utility is but
    Im not all that sure how to use it.Help for this would be greatly appreciated
    I cant use GarageBand without Tiger and Im going nuts.Thanks for all that you
    guys have posted so far but this little clarification about the CD&#47;DVD Master
    Image is most pertinent.
- id: 14114
  author: Matthew
  author_email: adonisdionysus@yahoo.com
  author_url: http://JonSharpITconsulting
  date: '2006-11-27 20:35:57 -0600'
  date_gmt: '2006-11-28 01:35:57 -0600'
  content: I had to use Disk Copy because Im runnin on v. 10.2.8. I did everything
    as posted to no avail all I keep getting is SOFTWARE CANNOT BE INSTALLED ON THIS
    COMPUTER.What a bummer! Still searching for any insight though.
- id: 17556
  author: PL
  author_email: ''
  author_url: ''
  date: '2007-01-23 16:17:35 -0600'
  date_gmt: '2007-01-23 21:17:35 -0600'
  content: "I can't modify the file OSInstall.dist in any way. I tried the Terminal
    and BBEdit, can't save the modified file\r\n\r\nHow can I make it?\r\n\r\nThanks
    a lot"
- id: 17646
  author: brett
  author_email: bvrettski@msn.com
  author_url: ''
  date: '2007-01-29 11:43:23 -0600'
  date_gmt: '2007-01-29 16:43:23 -0600'
  content: "'m trying this experiment now and am wondering how people (successfully)
    edited the OSInstall.dist fille. I opened it with Vim but it says my image is
    readonly. What do I need to do to the image to allow writing back of the changed
    file? do I need to reset the permissions afterwards? \r\n\r\nhttp:&#47;&#47;jonsharp.net&#47;archives&#47;2005&#47;05&#47;06&#47;installing-tiger-on-lombard&#47;
    \r\n\r\n\r\nUpdated: \r\n\r\nWhats really strange here is that I saved the image
    file as read&#47;write enabled. But when I get to the \"system\" folder and get
    \"info\" it saays read only. So I change it and do the same for all the folders
    and items intil I get to the OSInstall.dist. I modify that as suggested and choose
    \"Save\" but it reports it can't overwrite the existing file. So I save it to
    my desktop to try a replace drag and drop. Which it allows but when I open the
    OSInstall.dist file to confirm the replacement its the same old uneditted file
    I had before. \r\n\r\nWhats going on here..it feels like Big Brother is watching
    me do this and undoing it. \r\n\r\n\r\nWhat am I missing? \r\n\r\nAS stated I
    saved the image as read&#47;write but several of the sub folders were still marked
    as \"read\" when I hit command I for get info. \r\n\r\nAt one point I deleted
    the OSInstall.dist item from the image file all together. I closed the image file
    and reopened it to see if was actually gone. It was. But when I dragged the modified
    image file on my desktop back into the image...closed it , unmounted it, remounted
    it and looked at the OSINstall file it again had the offending bad machine code
    back in it. Like I said I can't explain it. \r\n\r\nAs an experiment I tried this
    on my ipod using it as a firewire drive. I used the instructions on the post listed
    above then dug into the OSINstall.dist file and tried to edit it. When I went
    to save it said it could not overwrite the file. So I dragged it to the trash...deleted
    it..emptied the trash. Unmounted the ipod...remounted the ipod and reopened the
    OSInstall.mpkg and sure enough the file was gone. I dragged a modified copy of
    the file into the OSINstall.mpkg, contents folder and opened it with text edit.
    Sure enough the previously deleted code is back in the script. \r\n\r\nThe mystery
    continues.....(hears the X files theme song)"
- id: 17680
  author: hunke.ws
  author_email: ''
  author_url: http://www.hunke.ws/2007/01/31/replacing-the-shielding-behind-the-clamshell-ibook-lcd/
  date: '2007-01-31 21:58:11 -0600'
  date_gmt: '2007-02-01 02:58:11 -0600'
  content: "[...] Next up is shoehorning Tiger onto this machine by hacking the installation
    CD. I&#8217;ll be using the Tiger CD-based install as I lack a DVD drive. I&#8217;ll
    also be replacing the logic board due to a strange buzzing issue (the CPU buzzes
    whenever the machine is plugged into the mains adapter, which scares me) and perhaps
    swapping the 256MB stick for a 512MB one. Hopefully that will quiet my inner demons.
    [...]"
- id: 17736
  author: TG
  author_email: ''
  author_url: ''
  date: '2007-02-04 13:20:22 -0600'
  date_gmt: '2007-02-04 18:20:22 -0600'
  content: "Hello, I'm trying to edit the OSInstall.dist, but it won't let me save.\r\nWhen
    I try and save, first it asks me if I want to overwrite it. When I say \"overwrite\"
    it says that it can't overwrite because it is in the \"Contents\" folder.\r\nThat
    Step by Step guid would sure be nice, but I think I have it for now. This is the
    only snag... Please help!"
- id: 23659
  author: Kevin Ramey
  author_email: romeo1993@chartertn.net
  author_url: ''
  date: '2007-05-04 21:06:19 -0500'
  date_gmt: '2007-05-05 02:06:19 -0500'
  content: I followed your directions but when I go to burn the dvd it comes back
    with a incomplete session error I was not sure if was my recorder or my media
    maybe dunno. Could you tell me what drive you used to burn it and what brand and
    type of media as well. Thanks for any help you can give
- id: 23689
  author: Jpauls
  author_email: ''
  author_url: ''
  date: '2007-05-05 22:03:16 -0500'
  date_gmt: '2007-05-06 03:03:16 -0500'
  content: "OS 10.4 CD INSTALL (Prepare Image on a 10.0 machine)\r\n\r\nI copied the
    disk1.dmg image onto my OS 10.0 Machine (via ftp).\r\nIf mounted using Disk Copy,
    it is read-only.\r\nTherefore, I created a new writable image...\r\nTERMINAL#
    cd &#47;DIRECTORY&#47;TO&#47;IMAGE\r\nTERMINAL# hdiutil convert disk1.dmg -format
    UDRW -o newdisk1.dmg \r\nMount new image using disk copy.\r\nvi Volumes&#47;NAMEOFVOLUME&#47;System&#47;Installation&#47;Packages&#47;OSInstall.mpkg&#47;Contents&#47;OSInstall.dist\r\n\r\nBefore:\r\nvar
    badMachines = [&rsquo;iMac&rsquo;,'PowerBook1,1?,&rsquo;PowerBook2,1?, &lsquo;AAPL,Gossamer&rsquo;,
    &lsquo;AAPL,PowerMac G3?, &lsquo;AAPL,PowerBook1998?, &lsquo;AAPL,PowerBook1999?];\r\n\r\nAfter:\r\nvar
    badMachines = [];\r\n\r\nFeel free to modify any other PreInstall checks.\r\n\r\nWrite
    the file. Unmount the image. Burn Image."
- id: 28913
  author: Steve
  author_email: lis35@hotmail.com
  author_url: ''
  date: '2007-07-16 02:19:57 -0500'
  date_gmt: '2007-07-16 07:19:57 -0500'
  content: "i am trying to install Tiger onto my clamshell iBook SE (no DVD). \r\n\r\nafter
    created and copied the disk image (thru firewire) of OSX Install DVD and mount
    to the hard disk, i run the 'osinstall.mpkg'. but installation halts and prompts
    &ldquo;BaseSystem cannot be installed on this computer. This software cannot be
    installed on this computer.&rdquo;  have also tried to activate the Install Mac
    OSX but it only leads to reboot and go no further.\r\n\r\ni'm pretty sure that
    the script has been edited to bypass the installation check and badmachines check.\r\n\r\nappreciate
    if anyone can offer further help."
- id: 29170
  author: Guy Merritt
  author_email: webmaster@guymerritt.com
  author_url: http://guymerritt.com
  date: '2007-08-06 14:15:34 -0500'
  date_gmt: '2007-08-06 19:15:34 -0500'
  content: "I just wanted to thank everyone for sharing this information.  I run a
    small computer store (just  getting started) and a young kid brought me a Mac
    Book he'd \"bought at a gas station\".  He'd paid $500.00 for the thing so I hope
    - wherever it came from originally - that it was insured.  I lectured him about
    buying stuff in this way, but he was on the hook for $500.00 and had a password
    protected Mac Book 1,1.  I had never touched a Mac.  For 5 weeks I tried everything
    under the sun, including picking up an old iMac G3 for testing things.  After
    downoading dozens of CD sets, \"universal\" Mac OSx  DVDs that did not work, I
    \ downloaded some DVDs that purported to be the retail disks for a Mac  Book,
    bought a dual layer DVD burner (which I didn't have). They tried to work, but
    failed with the message that I had the wrong hardware...\r\n\r\nFrom a command
    line, with DVD 1 mounted on the old iMac, I did the 'ol triple whamy.\r\n\r\nI
    edited the OSInstall.dist file thusly (as superuser):\r\n\r\nFirst Edit  (Title
    = \"I never met a Mac I didn't wanna work for....\")\r\n\r\nvar badMachines =
    ['']; \r\n\r\nSecond Edit: (Title = \"Some things in life are simply best ignored,
    completely........\")\r\n\r\nchanged installation-check script=\"hwbeInstallCheck()\"&#47;\r\nto\r\ninstallation-check
    script=\"\"&#47;\r\n\r\nThird Edit (Title = \"Can't we just all work together
    and get along...????)\r\n\r\nChanged that pesky line down at the bottom (you can't
    miss it), to this:\r\n\r\nvar hwbeSupportedMachines = ['iMac4,1','iMac5,1','iMac6,1','MacBook1,1','MacBook2,1','MacBookPro1,1',
    \r\n'MacBookPro1,2','MacBookPro2,1','MacBookPro2,2','Macmini1,1','MacPro1,1','PowerBook6,5','MacBook2,1'];
    \r\n\r\n\r\nAnd, in the above line, you should absolutely do this in Vim to avoid
    getting a line break - the line break is on this page due to the contraints imposed
    by the page itself.\r\n\r\nALSO: I had virtually ZERO luck trying to mount thse
    things on Windows and editing the above file with a text editor (though posters
    on torrent sites said this would work).  Do this on another Mac (based upon my
    experience) and use a command line text editor.\r\n\r\n\r\nThanks again,\r\n\r\nGuy
    Merritt"
- id: 30046
  author: Mark
  author_email: msw@altexa.com
  author_url: ''
  date: '2007-09-06 12:56:25 -0500'
  date_gmt: '2007-09-06 17:56:25 -0500'
  content: "Jon\r\n\r\nTHANK YOU for this info!  I upgraded my macbook to a macbook
    revision 2 (core 2 duo), and sold the old one on ebay - but I lost the original
    install DVD.  I thought i'd be ok to use the new macbook install DVD, but it complains
    about the machine.  A quick copy of the install dvd to a blank usb hard disk,
    a vi of the OSInstall file, and I'm one up on MacOS!\r\n\r\nThanks again\r\n\r\nMark"
- id: 31499
  author: "@(X!_!X)@"
  author_email: unrar26@gmail.com
  author_url: ''
  date: '2007-10-18 13:17:31 -0500'
  date_gmt: '2007-10-18 18:17:31 -0500'
  content: this walkthrough is great. there is only one problem i found with these
    directions. you have make sure that your copy of the .dmg file used is not read
    only. i "obtained" a copy of tiger to do this with, but the .dmg was read only,
    which led to hours of frustration until i realized that i had to use disc utility
    to burn the image to cd, then re-rip the cd to a read&#47;write .dmg. at first
    i tried to use the terminal to change the owners and the permissions on the .dmg
    with no success. i might be possible, but it's beyond me. just use disk utility
    and everything will be fine
- id: 33178
  author: John Sawyer
  author_email: johnsawyercjs@yahoo.com
  author_url: ''
  date: '2007-12-12 08:35:46 -0600'
  date_gmt: '2007-12-12 13:35:46 -0600'
  content: The suggestions here work great, particularly Jon Sharp's original suggestions,
    and and Guy Merrit's expanded ones.
- id: 47882
  author: Antibanana
  author_email: bethanyfortuneao@gmail.com
  author_url: http://bethanyfortuneaogmail.com
  date: '2012-05-10 15:59:14 -0500'
  date_gmt: '2012-05-10 20:59:14 -0500'
  content: "This is not a joke. No to Banana! \r\nYes to Anti Banana Legion \r\nJoin
    the struggle now and make This world a better place! \r\n<a>http:&#47;&#47;www.youtube.com&#47;watch?v=Wm1IV5Gjcow<&#47;a>"
- id: 47941
  author: WhoxErrotor
  author_email: tesoroflouple@gmail.com
  author_url: http://hls-ed.blogspot.com/
  date: '2012-05-11 21:04:02 -0500'
  date_gmt: '2012-05-12 02:04:02 -0500'
  content: "<a href=\"http:&#47;&#47;buy.online-no-prescription.net&#47;long-term-chloroquine-prophylaxis&#47;\"
    rel=\"nofollow\">long term chloroquine prophylaxis<&#47;a>\r\n<a href=\"http:&#47;&#47;buy.online-no-prescription.net&#47;benadryl-allergy-ultratabs&#47;\"
    rel=\"nofollow\">benadryl allergy ultratabs<&#47;a>\r\n<a href=\"http:&#47;&#47;buy.online-no-prescription.net&#47;tylenol-3-while-breastfeeding&#47;\"
    rel=\"nofollow\">tylenol 3 while breastfeeding<&#47;a>\r\n \r\n \r\n \r\nHow rapid
    Can easily Results Be anticipated Coming from GER Together with Treatment?"
---
Ok guys, I know what I said earlier about not getting Tiger to install, but I got to thinking about it and I had an idea.  After digging around on the Tiger Install DVD, I found my answer.  Here's what I did to get the installer to install on my Lombard:

First, I created a CD/DVD master image from the Tiger Install DVD using Disk Utility.  Then, I mounted the image.  Then I found the OSInstall.dist file in /System/Installation/Packages/OSInstall.mpkg/Contents on the image.  Near the top of the file is a line that specifies a list of "badMachines", or some such.  In that list is "PowerBook1,1", the model code for the PowerBook G3 Lombard.  I simply modified that entry to read "PowerBook3,1".  I then unmounted the image and burned it to DVD-R.  My Lombard booted right up the installation DVD as it had before, but this time I received no error messages regarding unsupported hardware.

So, there you have it!  It turned out to be much simpler than I had expected.  Now, I must admit that I have not performed the installation of Tiger yet, so I cannot yet verify that the installation will complete successfully, but I plan to install a new HD in the machine and test it out at least before going back to Gentoo.  I really don't think Tiger will perform very well on this old machine, but it's fun to try it out.  :)

Now, a note for Lombard users without a DVD drive:  I would expect that you could perform the same operation on the CD version available as a special order from Apple.
