import java.util.Scanner;

/**
 * StartSolvingMaze
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
        solveMaze = new MazeSolver(numRows, numCols, kb);
        System.out.println("The maze has been created. Use q to quit, s to solve, and hit ENTER to solve the maze.");
        // Must flush the return from the Scanner
        kb.nextLine();

        mazeComplete = solveMaze.solve();
        if (mazeComplete == true) {

            System.out.println("The maze is completed! Thanks for playing.");
        }


    }

}
    