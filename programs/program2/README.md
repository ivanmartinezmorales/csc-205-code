# Program 2


## Program 2 Notes:
It will be due two weeks after spring break is due.

This program includes:

- File I/O
- Serialization
- Enumerated data types

## Serialization

 - The ability to take the class and save it. Serialization allows us to save the exact state of the code.
 - Serialization allows us to reboot the class at any time. It saves the file as a .jar file.

 - You don't have to write anything to separate files, but rather save every variable.

 You can restart the file with two statements.

 ## Enumerated data types:

 - e.g. Putting numbers to the directions, years, etc.

## File I/O

- We read the file with our Scanner class, using the FileInputStream() class. 

To new scanner thing:
```java
import java.util.*;
import java.io.*;

try { 

Scanner input = new Scanner(new FileInputStream(inboundFileName));

} catch(throwable Exception) {

    Exception.printStackTrace(); // Exception is the parent class of all other exceptions.
}

while(input.hasNextLine()) { // This is a look ahead.
    String inString = input.nextLine(); // Reading line by line
    System.out.println("line ==>" + inString);
}
```

Now to call our file, let's use:
```bash
javac runProgram.java
java runProgram
# Prompt here: What program do you want to run?
... Then the program compiles.

>>> What file should we read?
FileIO520pm.java

# Now the program will read that file, line by line.
```

## Writing to a file:

```java
// Saving our outBound File
String outboundFile = new Scanner(System.in).nextLine();

// There is a class in java called printWriter. Let's call it.
PrintWriter printer = new PrintWriter(new FileOutputStream(outboundFile)); 

// Each line will be written to the file.
printer.println("Hello world!");
printer.println("ummmmmmmmm uhhhhh");
printer.close(); // Make sure you close the printer at the end.
```

## IMPORTANT FOR PROGRAM 2!
>Serialization is the process of writing/reading a class to a binary file. This allows the class to be read/written, where only the class data is included in the binary file. Every class that is serialized must have `implements Serializable` in the class signature. 

Sometimes the code may try and serialize itself. You have to tell it to serialize itself. The way you do that is this way:

```java
import java.io.*;
String inBoundFile = new Scanner(System.in).nextLine().close();
String fileName = new Scanner(System.in).nextLine().close();

// Part 1: Opening the file.
ObjectOutputStream pipe = new ObjectOutputStream(new FileOutputStream(inBoundfile));
pipe.writeObject(fileName); // 

```

## Unserializing an Object

```java
ObjectInputStream inboundSerial = new ObjectInputStream(new FileOutputStream(inBoundFile));
Object ourObject = (Object) inBoundSerial.readObject();
```


## 5 given methods
### `goalReached()`
### `getCurrentRow()`
### `getCurrentCol()`
### `move(enumerated data types here)`
### `isOpen(enumerated dat types here)`

## Enumerated Data Type: Direction
- Direction.UP
- Direction.DOWN
- Direction.LEFT
- Direction.RIGHT

## What you have to write:

### MazeSolver.java
- `MazeSolver.solve()` - Solves the maze. 
- MazeSolver - a do while loop. It'll have a stack withd riections, and a 2D array for your visited rows.
- Tell the maze to build itself
- Create your stack.
- Create a 2D array of boolean, and initializing them to false.
- Solve - every time you create a new maze display.
- Create a scanner for the enter.

- do While Grab the next line, if s, ask to save. oos.writeObject(this), then close.
- if the input is q, then quit.
- grab current row and col
- mark row as visited
- then set your 5 cases. up, down, left, and right and each direction has not been visited.push it to the stack and then move. 
else if maze.isopen(Maze.direction.left) && not visited[at current index]
- else condition: pop the stack and reverse the direction.


### StartSolvingMaze.java
- This program is a driver for the maze.

### StopSolvingMaze.java

>Here's how you should do it! You're going to have to keep track of a stack. This keeps track of the moves that you've been there. 

>You're going to need a 2 dimensional array of booleans. Automatically populated with false's. we'll call it: `boolean visited[][]`, or you can create an arraylist that can keep track of the rows and columns together, like the Point class.

>Don't hardcode the .ser, whatever the user puts in is what they put in. What ends up being saved is the mazeSolver, your dataStructure, and your maze.

### resumeSolvingMaze.java

>Please enter the file to save.