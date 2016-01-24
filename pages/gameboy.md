---
layout: page
title: "Gameboy Ethernet Project"
permalink: "/projects/gameboy/"
---

Overview
--------

The goal of this project was to allow a Nintendo Gameboy Color to 
function as a remote reporting tool via a standard Ethernet connection. 
This was accomplished using various hardware. Using a custom built 
RS232 convertor circuit, the Gameboy connects to the serial port of 
a special Java embedded device named [TINI](http://www.ibutton.com/TINI). 
The TINI hardware also includes an Ethernet interface, making the 
TINI essentially an Ethernet-to-Serial adapter. The TINI establishes 
a socket connection with our Java server which sends useful information 
back to the TINI which sends the output directly to the Gameboy's 
LCD screen. Read the following sections for the details of each component.

Hardware
--------

 * Nintendo Gameboy Color
 * Dallas Semiconductor's TINI
 * Homemade RS232 signal convertor circuit

GB Software
-----------

The Gameboy software was written in assembly language (The Gameboy 
has a Z80 workalike CPU.) and assembled using Rednex Gameboy Development 
System. [RGBDS](http://www.otakunozoku.com/rgbds/index.html)
The assembled ROM image was then flashed to a 4Mb [Bung](http://www.bung.com.hk)
flash cartridge via Bung's GB Xchanger. The original design and 
code are [Ken Kaarvik's](http://www.geocities.com/kkaarvik/gameboy.html).
Many thanks go to Ken for the inspiration for this 
project, his code and permission to expand on his very excellent 
idea. The original code is available on Ken's page. Click below 
for the modified code used in this project.

 * [Source](/files/commboy.asm)
 * [Full archive](/files/commboyv09.zip) (includes build file and include files)

Java Client
-----------

The Java client code runs on the TINI providing the Gameboy with 
the connection to the Java server running on our Linux workstation. 
The client code begins by creating a serial port object and opening 
it. Then it opens a socket connection to the Java server. When the 
server sends the information to client, the client then outputs 
directly to Gameboy over the serial port. This is a simple application 
providing the Gameboy an Ethernet interface.

 * [Source](/files/GBClient.java)

Java Server
-----------

The Java server is on a Linux system and remains open to connections 
while running. The server waits until a client connects and then 
sends out system information such as uptime and cpu temperature. 
We hope to eventually allow two way communication between the Gameboy 
and the server so that the server's host can be controlled by the 
Gameboy.

 * [Source](/files/GBServer.java)

Project Notes
-------------

Many things were required to pull this project off. First, we had 
to learn assembly for which McKee Library proved helpful. Then we 
had to learn about the Gameboy's hardware. The Internet is full 
of [great resources](http://www.devrs.com/gb) for that. 
The MAX232CPE circuit was constructed in under 3 hours. The TINI 
we used is running TINI Firmware 1.01. In order to allow our Java 
client software to execute without invoking it manually, (telnet 
over the Ethernet device) we had to add a line to Slush's (TINI's 
shell) /etc/.startup file. All coding was done using
[VIM](http://www.vim.org).

Special thanks to [Dr. Halterman](http://www.cs.southern.edu/~haltermn)
for his help in this project! Here are some of the 
project costs: 

 * TINI w/ board - $75
 * Gameboy Color - $70
 * Bung Flash cart and Xchanger - $90
 * Parts for RS232 circuit - ~$15
 * Hours of mad coding - _priceless_

Pictures
--------

![Gameboy Color][proj1] Start with the Gameboy Color

![RS232 Converter][proj6] Build a circuit around Maxim's MAX232CPE 16-pin DIP

![Project Box][proj3] Put it in an attractive project box

![The TINI][proj4] Get your TINI...

![All together][proj2] and put it all together!

Summary
-------

This was a great project that was a lot of fun. We feel that we've 
done so much that no one has ever done or even thought to do before. 
It was a great learning experience for us. We had to learn how to 
implement the various things we've learned about in CPTR 328 as 
code that was useful. We hope to someday improve upon this project 
with newer features and functionality, but until then we can
appreciate our accomplishments.

[proj1]: /images/proj1.jpg
[proj2]: /images/proj2.jpg
[proj3]: /images/proj3.jpg
[proj4]: /images/proj4.jpg
[proj6]: /images/proj6.jpg
