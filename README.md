

#Virtual LED Display

-------------------------------------------------------------
1. What is it?
-------------------------------------------------------------

Virtiual LED display is display that generated using single strip of LEDs. 
Currently we used 20 leds for complete this project. The LEDs are attached
to a blade which is horizontal to the ground. The LED strip is attach to the
blade virtical to the ground. So the LED strip can rotate in cylindrical manner.

By lighting up all leds, it can display a whole cylinder. But it can use to
display various patterns and words by changing each leds on/off time. So a 
character bank is generated for do that thing. It currently supports
to A-Z, a-z, 0-9,space,dot only. 


-----------------------------------------------------------------
2. Design
------------------------------------------------------------------
A arduino mega 2560 is used to control the 20 leds. So 3 ports of
it used for that purpose. The character bank codes are written in way
to support that. A - Z, 0-9 and a -z are supplied in this repo.

----------------------------------------------------------------------
3. Files
----------------------------------------------------------------------

i . Map.java

This can use to generate a letter has resolution 20x10.
It will generate code which needed for each port. 

ii. code.py

This needs if the letters are mirrored. If the propeler is rotataing 
other direction to the letters it will mirror the word. So this 
code can rearrange the code to support the propeler.
