# DSLR Intervalometer

There are a number of Canon DSLRs that allow for an external shutter release using a 3-terminal 2.5mm audio jack. You can purchase the hand-held intervalometers online, but using those can be somewhat inconvenient. They either don't save their last configuration, or they can't store any for later use. Not to mention configuring the device can be a pain in the butt. 

The purpose of this project is to replace the clunky battery-powered intervalometer with a USB powered device. You can now automate the DSLR's exposure time using a desktop application and a piece of electronics. The application will save your DSLR profiles and make it a lot easier to configure. 

## How does it work
As it turns out it's quite simple. The three terminals from the 2.5mm jack will give you two 3V and a ground wire. In my case these wires are; White (left channel), Red (right channel) and Yellow (ground). When you short the red and yellow wire the camera will begin to focus if the lens is set on auto-focus. Shorting the white and yellow wire will make the camera take a picture. 

The exposure time depends on the camera's configuration. Camera's set in Aperature(Av) or Time(Tv) priority mode will expose for a given amount of time. When set to Manual(M) mode the exposure can be set to "bulb" and give full control over the expose time. As long as the shutter wire is shorted to ground the shutter remains open.

## Schematic
![schematic](https://raw.githubusercontent.com/NullpointerWorks/dslr-usb-intervalometer/main/schematic/schema.png)

## Supported DSLR's
I believe most(if not all) Canon DSLRs come equipped with a 2.5mm external shutter release interface. I own a Canon 350D (astro-modified) and 1100D and confirmed it works on both of them. 
