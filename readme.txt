v0.1 Update:
- Holds work.
- Due to osu's limitations with speed changes, make sure your holds don't intersect speed changes.
  This includes stops.
- Holds cannot end in other notes. This is an obvious one.
- The code is messy and I need to clean it up. This was literally something I shat out in less than a day.

How to use:

Make sure java is installed.
Download ftb2om.jar
Open up a command prompt window and navigate to where you downloaded your file.
Take the ftb file (.txt, the one that you normally upload to the site) and put it where you put ftb2om.jar.

Enter the following:
   java -jar ftb2om.jar [in file] [out file] [bpm]
[in file] is the file you're converting.
[out file] is the file where the text comes out.
[bpm] is the first bpm of the file.
Don't include brackets. :V

If you do it right, you should get a file with some text in it.
Now make a new file in osu.
Make sure the beatmap is set to osu!mania only.
Set the number of keys to 7, in the difficulty tab.
Save it, and open up the .osu file in Notepad.
Paste the text in. It should be obvious where to paste it in.
Reload the file in osu and all the notes should be there. You might have to fiddle with offset and bpm changes.