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
        solveMaze = new MazeSolver(numRows, numCols);


        try {

            mazeComplete = solveMaze.solve();

        } catch (Exception ex) {

            ex.printStackTrace();
        } 
        
        if (mazeComplete == true) {

            System.out.println("Completed the Maze. Thanks for playing!");
        }

    }

}
    