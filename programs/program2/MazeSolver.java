import java.io.*;

public class MazeSolver implements Serializable {
    
    private static final long serialVersionUID = 1L;

    // DATA
    private Stack<Direction> directionStack;
    private boolean[][] positionArray;
    private Maze aMaze;
    
    // CONSTRUCTORS
    public MazeSolver(int numRows, int numCols) {
        
        // 1. Set up the maze.
        aMaze = new Maze(numRows, numCols);
        // 2. Set up positionArray
        positionArray = new boolean[numRows][numCols];
        // 3. Set up directionStack;
        directionStack = new Stack<Direction>();
        
        // 4. Set up trippy visuals (the maze, duh)
        // TODO: SET UP MAZE VISUALS BRO
    }

    // METHODS
    public boolean solve() {
        
        Scanner kb = new Scanner(System.in);
        do {

            solve(kb.nextLine());
            
        } while (!aMaze.goalReached());
    }

    private void solve(String userInput) {
        
        if (userInput.equalsIgnoreCase('q')) {
            // Need to find a way to find a way to kill this program without using system.exit()
            quitMaze();

        } else if (userInput.equalsIgnoreCase('s')) {
            
            serializeMaze();

        } else if (userInput == "") {
            
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
     */
    private void serializeMaze() {
        
        // Acquiring the file name        
        System.out.println("Please tell me the name of the file you would like to write. ");
        String outBoundFile = new Scanner(System.in).nextline(); // Scanner is closed because its only temporarily instantiated
        System.out.println("Saving file to: " + outBoundFile);

        // Serializing the file, variable name keystone to the infamous keystone pipeline!
        ObjectOutputStream keystone = new ObjectOutputStream(new FileOutputStream(outBoundFile));
        keystone.writeObejct(this);
        // Closing the keystone pipeline, very importante as we don't want to leak that precious oil.
        keystone.close();
    }

    /**
     * Quits the maze gracefully. TODO: Find out how to quit the maze gracefully without affecting the functionality of the tester.
     */
    private void quitMaze() {
        System.out.println("Now leaving maze. Goodbye!");
        // TODO: Add feature to exit maze.
    }


    /**
     * Moves the maze in the given direction.
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
        poppedDirection = directionStack.pop();
        System.out.println("Popped the stack!");

        // 2. Run the direction that's popped throught the switch.
        switch (poppedDirection) {

            case Direction.UP:
                
                aMaze.move(Direction.DOWN);
                System.out.println("Moving in the opposite direction: DOWN");
                break;
            
            case Direction.DOWN:
                aMaze.move(Direction.UP);
                System.out.println("Moving in the opposite direction: UP ");
                break;
            
            case Direction.LEFT:
                aMaze.move(Direction.RIGHT);
                System.out.println("Moving in the opposite direction: RIGHT ");
                break;
            
            case Direction.RIGHT:
                aMaze.move(Direction.LEFT);
                System.out.println("Moving in the opposite direction: LEFT ");
                break;

            default:
                break;
        
        }

    }

}