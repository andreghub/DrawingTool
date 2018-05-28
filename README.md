# Drawing Tool Challenge
The DrawingTool class implements a basic Drawing Tool to a Character 2D Canvas. The tool executes a set of commands from the input file and then produces an output file with the result. 

At this time, the functionality of the program is quite limited but this might change in the future.
At the moment, the program supports the following set of commands:

* `C w h`
Create Canvas: Should create a new canvas of width w and height h.

* `L x1 y1 x2 y2`
Create Line: Should create a new line from (x1,y1) to (x2,y2). Currently
only horizontal or vertical lines are supported. Horizontal and vertical
lines will be drawn using the 'x' character.

* `R x1 y1 x2 y2`
Create Rectangle: Should create a new rectangle, whose upper left
corner is (x1,y1) and lower right corner is (x2,y2). Horizontal and
vertical lines will be drawn using the 'x' character.

* `B x y c`
Bucket Fill: Should fill the entire area connected to (x,y) with "colour"
c. The behaviour of this is the same as that of the "bucket fill" tool in
paint programs.

## Getting Started

These instructions will get you a copy of the solution up and running on your local machine for assesment purposes.

### Prerequisites

What things you need to install the software and how to install them

```
Java 1.8 SDK
```

### Running

The provided ZIP file contains a runnable JAR file and a sample input file. So, first extract the provided zip file into a local folder. Then, execute the following commands in a command-line terminal under the root folder:

Run JAR

``
java -jar DrawingTool.jar input.txt output.txt
``

Application will read the commands from input file (input.txt) and it will generate a file called output.txt.

## Authors

* **Andre Oliveira**