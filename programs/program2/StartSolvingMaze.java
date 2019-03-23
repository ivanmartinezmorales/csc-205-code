/**
 * StartSolvingMaze
 */
public class StartSolvingMaze {
    public static void main(String[] args) {

        MazeSolver solveMaze = new MazeSolver(5, 5);
        System.out.println("Created new maze.");
        solveMaze.solve();
        }
    }
    