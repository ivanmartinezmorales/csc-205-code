/**
 * ResumeSolvingMaze
 */

import java.io.*;
import java.util.*;
import java.lang.Throwable.*;

 public class ResumeSolvingMaze {

    private static ObjectInputStream keystone;
    private static MazeSolver resumeMazeSolver;
    private static Scanner kb;
    private static String fileName;
    private static boolean mazeComplete;

    public static void main(String[] args) {

        kb = new Scanner(System.in);
        System.out.println("Hi, in this program we will rebuild your old maze and keep runnin' it!"); 

        try {
        
            System.out.println("Hi, please tell me the file you would like to import.");
            
            fileName = kb.nextLine();
            keystone = new ObjectInputStream(new FileInputStream(fileName));        
            
            System.out.printf("Creating Maze from file %s", fileName);
            resumeMazeSolver = (MazeSolver) keystone.readObject();
        
        } catch (Exception ex) {
            
            System.out.println("Could not read that file - please try again.");

        }

        System.out.println("Created the maze. Startings solve... Please wait.");
        
        try {

            mazeComplete = resumeMazeSolver.solve();

        } catch (Exception ex) {

            System.out.println("An expception occured!");
            ex.printStackTrace();

        }

        if (mazeComplete == true)
            System.out.println("Maze complete!");
    }

    
}