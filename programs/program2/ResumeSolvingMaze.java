/**
 * ResumeSolvingMaze loads the ol' maze up, and then begins to run 
 * through it as if we were picking up where we left off. 
 * Written by Ivan Martinez Morales, for CSC205
 */

import java.io.*;
import java.util.*;

 public class ResumeSolvingMaze {

    // DATA
    private static ObjectInputStream keystone;
    private static MazeSolver resumeMazeSolver;
    private static Scanner kb;
    private static String fileName;
    private static boolean mazeComplete;

    // MAIN 
    public static void main(String[] args) {

        kb = new Scanner(System.in);
        System.out.println("Hi, in this program we will rebuild your old maze and keep runnin' it!"); 
    
        // 1. Ask user to give you the name of the file.
        try {

            System.out.println("Please give me the name of the file you would like to open.");
             
            fileName = kb.nextLine();
            System.out.printf("the file is: %s\n\n", fileName);
            keystone = new ObjectInputStream(new FileInputStream(fileName));
            resumeMazeSolver = (MazeSolver) keystone.readObject();
            System.out.printf("File %s has been opened! Press enter to continue.");

            kb.nextLine();
            keystone.close();

        } catch (Throwable e) {

            System.out.println("Something went wrong... Please check your filename and try again.");
            
        }

        // Running the MazeSolver.
        mazeComplete = resumeMazeSolver.solve();
            
        if (mazeComplete == true) {
            System.out.println("Maze is complete! Thanks for playing.");
        }

    }
}