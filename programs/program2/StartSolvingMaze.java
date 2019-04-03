import java.util.Scanner;

/**
 * StartSolvingMaze
 * StartSolvingMaze is the driver for the MazeSolver class. Loads the Maze up and makes that thing run.
 * Written by Ivan Martinez Morales, for CSC205, Program 2, 1 April 2019.
 */
public class StartSolvingMaze {

    // DATA
    private static Scanner kb;
    private static MazeSolver solveMaze;
    private static boolean mazeComplete;


    public static void main(String[] args) {

        kb = new Scanner(System.in);

        System.out.println("Please enter the dimensions of the maze you would like to create: ");
        
        int numRows = kb.nextInt();
        int numCols = kb.nextInt();
        
        System.out.printf("Creating maze with %d rows and %d columns.\n", numRows, numCols);
        solveMaze = new MazeSolver(numRows, numCols);
        System.out.println("The maze has been create. Use q to quit, s to save, and hit ENTER to solve the maze.");
        // Must flush the return from the Scanner
        kb.nextLine();

        mazeComplete = solveMaze.solve();
        if (mazeComplete == true) {
            System.out.println("The maze is completed! Thanks for playing.");
        }
        
    }

}
    