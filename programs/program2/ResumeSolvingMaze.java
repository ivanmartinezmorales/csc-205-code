/**
 * ResumeSolvingMaze
 */

import java.io.*;
import java.util.*;

 public class ResumeSolvingMaze {

    private ObjectInputStream keystone;
    
    public ResumeSolvingMaze(String fileName) throws FileNotFoundException, IOException {

        keystone = new ObjectInputStream(new FileInputStream(fileName));
    }
    public static void main(String[] args) {
        
        

    }
    
}