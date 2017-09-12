MARS ROVER CHALLENGE
This application is a navigation system for the rover sent to survey mars

Instructions:
-The application allows you to upload a text file containing the bounds of the current zone, the starting position of the rover and instructions on how the rover should move
-The application then displays the new position of the rover after following the instructions.
-The text file must be in the following format:
 --The first line must contain the x and y bounds of the zone e.g. 8 8
 --The second line must contain the coordinates(x and y) of the starting position of the rover along with the direction the rover is facing, e.g. 1 2 E
 --The x and y coordinates(including the zone bounds) must be represented by numbers only
 --Your direction should be represented by a letter, N for North, E for East, W for West and S for South
 --The third line must contain the instructions on how the rover should move and rotate. The rover can only understand the following commands:
 ---M which means that the rover should move forward
 ---L which means that the rover should rotate 90 degrees left
 ---R which means that the rover should rotate 90 degrees right
e.g. If you wanted the rover to move forward, turn right, move forward twice then turn left, your instructions would be: MRMML
 --Here is example of the content your text file should have in the right format:
8 8
2 3 W 
MMRMLMMRRMMML


Design decisions:
-The application only accepts text files
-The application allows you to upload any text file on your computer from any directory you have access to 
-The zone bounds can contain one or more digits
-The rover cannot go past the given zone boundaries
-The application will only display the new position of the rover after following the instructions if the format of the text file is correct

Ensuring code correctness:
-Allowing the user to upload his/her own file removes the risk of the input file not being found.
-Each input line is checked to make sure that it has the correct format using regular expressions.
-Using a try and catch statement to catch the NumberFormatException allows us to make sure that the input values that are supposed to be integers are integers, otherwise, send a relevant, user friendly error message to the user.
-Each letter in the instructions on the third line of the input file is checked, letter by letter, to make sure that each letter used is one of the 3 commands that the rover can understand.
-The position of the rover is checked to make sure it is within the zone bounds of the current zone.
-Using try and catch statements allows the application to catch relevant exceptions and give a description of the error in a more user-friendly way.
-The application is tested with different values(some in the wrong format), to make sure it responds correctly to whatever input it is given.



