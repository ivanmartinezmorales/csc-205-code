import java.io.*;
import java.util.*;

public class MazeSolver implements Serializable {
    

    // DATA
    private Stack<Direction> directionStack;
    private boolean[][] positionArray;
    private Maze aMaze;
    private static MazeDisplay display;
    private Scanner kb;


    // CONSTRUCTORS
    /**
     * Default constructor builds
     */
    public MazeSolver(int numRows, int numCols) {
        
        // 0. Set up Scanner
        this.kb = new Scanner(System.in);

        // 1. Set up the maze.
        this.aMaze = new Maze(numRows, numCols);

        // 2. Set up positionArray
        this.positionArray = new boolean[numRows][numCols];

        // 3. Set up directionStack;
        this.directionStack = new Stack<Direction>();

        // 4. Set up trippy visuals (the maze, duh)
        display = new MazeDisplay(aMaze);
        aMaze.buildMaze(0);
        aMaze.setSolveAnimationDelay(1);
        System.out.println("End of Maze Solver Constructor");


    }

    // METHODS
    /**
    * Method that solves the maze with the do-while loop. Outward facing method in entire class.
    */
    public void solve() throws FileNotFoundException, IOException {
        
        do {

            solve(kb.nextLine());
            
        } while (!aMaze.goalReached());

        System.out.println("Completed Maze!");
        kb.close();
    }
    
    /**
    * solves the Maze one step at a time, with userInput.
    * @param userInput, given from the user.
     * @throws IOException
     * @throws FileNotFoundException
    */
    private void solve(String userInput) throws FileNotFoundException, IOException {
        
        if (userInput.matches("[Qq]{1}")) {
            // Need to find a way to find a way to kill this program without using system.exit()
            quitMaze();

        } else if (userInput.matches("[Ss]{1}")) {
            
            System.out.println("Please tell me the name of the file you'd like to write.");
            String outboundFileName = kb.nextLine();
            serializeMaze(outboundFileName);

        } else if (userInput.isEmpty()) {
            
            /**
             * Navigating the maze: 
             * - First, check if DOWN is open and unvisited, then go down. Do the same thing for each direction in 
             *   this order: DOWN, RIGHT, LEFT, UP.
             * - If we meet that condition, then call moveMaze(Direction [direction]).
             * - If we're backed up in a corner, then call popDirection() to go back the way you came.
             */

            if (aMaze.isOpen(Direction.DOWN) && !positionArray[aMaze.getCurrentRow() + 1][aMaze.getCurrentCol()]) {

                moveMaze(Direction.DOWN);

            } else if (aMaze.isOpen(Direction.RIGHT) && !positionArray[aMaze.getCurrentRow()][aMaze.getCurrentCol() + 1]) {

                moveMaze(Direction.RIGHT);

            } else if (aMaze.isOpen(Direction.LEFT) && !positionArray[aMaze.getCurrentRow()][aMaze.getCurrentCol() - 1]) {

                moveMaze(Direction.LEFT);

            } else if (aMaze.isOpen(Direction.UP) && !positionArray[aMaze.getCurrentRow() - 1][aMaze.getCurrentCol()]) {

                moveMaze(Direction.UP);

            } else {

                popDirection();

            }

        }

    }

    /**
     * Serializes the maze and saves it to the file of the user's choosing.
     * @throws IOException
     * @throws FileNotFoundException
     * @param fileName name of the file to record
     */
    private void serializeMaze(String fileName) throws FileNotFoundException, IOException {
        
        // Acquiring the file name        
        System.out.println("Saving file to: " + fileName);

        // Serializing the file, variable name keystone to the infamous keystone pipeline!
        ObjectOutputStream keystone = new ObjectOutputStream(new FileOutputStream(fileName));
        keystone.writeObject(this);

        // Closing the keystone pipeline, very importante as we don't want to leak that precious oil.
        keystone.close();

    }

    /**
     * Quits the maze gracefully.
     */
    private void quitMaze() {

        display.dispose(); 
        System.out.println("Now leaving maze. Goodbye!");

    }


    /**
     * Moves the maze in the givend
     * @param direction - a direction, i.e. UP, DOWN, LEFT, RIGHT.
     */
    private void moveMaze(Direction direction) {

        aMaze.move(direction);
        System.out.println("Moved " + direction);
        directionStack.push(direction);
        moveBooleanArray();

    }

    /**
     * Changes the visited Array's values to true for a given point.
     */
    private void moveBooleanArray() {

        positionArray[aMaze.getCurrentRow()][aMaze.getCurrentCol()] = true;

    }
    
    /**
     * Method that goes in the reverse direction, from the top of the stack.
     */
    private void popDirection() {

        // 1. Popping the stack.
        Direction poppedDirection = directionStack.pop();
        System.out.println("Popped the stack!");

        // 2. Run the direction that's popped throught the switch.
        switch (poppedDirection) {

            case UP:
                moveOpposite(Direction.UP, Direction.DOWN);    
                break;
            
            case DOWN:
                moveOpposite(Direction.DOWN, Direction.UP);
                break;
            
            case LEFT:
                moveOpposite(Direction.LEFT, Direction.RIGHT);
                break;
            
            case RIGHT:
                moveOpposite(Direction.RIGHT, Direction.LEFT);
                break;

            default:
                break;
        
        }

    }

    /**
     * Helper function that moves the maze in the opposite direction.
     * @param direction Direction that was popped from directionStack.
     * @param oppositeDirection Opposite direction to move in.
     */
    private void moveOpposite(Direction direction, Direction oppositeDirection) {

        System.out.printf("Popped: %s, moving: %s", direction, oppositeDirection);
        aMaze.move(oppositeDirection);
    }

}
