/**
 * ResumeSolvingMaze
 */

import java.io.*;
import java.util.*;

 public class ResumeSolvingMaze {

    private ObjectInputStream keystone;
    private MazeSolver resumeMazeSolver;
    
    public ResumeSolvingMaze(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {

        keystone = new ObjectInputStream(new FileInputStream(fileName));

        resumeMazeSolver = (MazeSolver) keystone.readObject();
        keystone.close();
        resumeMazeSolver.solve();

    }
    public static void main(String[] args) {
        
        

    }
    
}