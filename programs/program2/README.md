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
```

