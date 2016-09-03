---
layout: page
#
# Content
#
title: "The End of the Analog Trail"
subheadline: ""
teaser: ""
categories: [embedded]
tags: [tech,embedded,art,ws2812,neopixel,psoc4]
excerpt_separator: <!--more-->
---

I recently had the privilege to work with a local artist on what turned out to
be a very fun project.  Having been introduced through our local maker group,
[NashMicro](https://plus.google.com/u/0/communities/113168301409955370802),
Phil and I sat down for a coffee and he laid out his vision for a new piece he
was sketching out.  Phil is a woodcarver, and a fine one, at that.  His work is
at times whimsical and at others, thought-provoking. (And sometimes both at once)
He was looking to incorporate points of light into his new piece that would
primarily serve as a starry (and stormy) night sky above a carving of a cowboy, 
riding his horse, face lit by the unnatural blue glow of a smartphone.  

<!--more-->

I immediately began thinking of LED cubes and other means to address many
individual LEDs, but landed in the end on NeoPixels (ws2812's) for my solution.
Many of you are no doubt familiar with these great little 
individually-addressable, chainable RGB LEDs.  I had myself seen projects using 
NeoPixels, but was previously unfamiliar with what made them so special.

In the end, we used a combination of nearly 250 flat, SMD and 5mm round ws2812 
RGB LEDs.  I considered a number of microcontrollers, but settled on the PSoC4
from Cypress Semiconductor.  The PSoC4 4200 is a unique part, with a Cortex-M0
core married with a modest amount of programmable logic.  

The code is written in C, and is responsible for a variety of visual elements,
driving the behavior of four discrete groups of LEDs -- a large number of 
"stars", another large group of "lightning" LEDs, a few "campfire" lights and a
single LED for the lit smartphone.  The stars twinkle and fade, through a 
(pseudo-)random pattern of hues, durations and frequencies.  The lightning
fires through another set of randomizations, giving an effect of distant,
cloud-to-cloud lightning. (suggestive of storms on the horizon?)  The campfire
LEDs cycle through random reds, oranges and yellows, suggesting a slowly fading
fire, while the smartphone LED burns a mostly steady blue glow against the face
of the piece's central figure.

In the end, I was proud of how the lighting elements came together, and feel
privileged to have gotten to work together with Phil on this project.  He was
even gracious enough to give me credit on the piece and invite me to the
gallery show where it debuted.  I have to say that it looked great on the
gallery wall and I imagine it will soon add something truly unique to someone's 
home or office.

But without further ado, here are some photographs and video:

