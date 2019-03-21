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

    }

    // METHODS
    public boolean solve() {
        
        do {
        // User decides to exit.
            

        } while (!aMaze.goalReached());
    }

    private boolean solve(String userInput) {
        
        if (userInput.equalsIgnoreCase('q')) {
            // Need to find a way to find a way to kill this program without using system.exit()
            System.exit(0);
        } else if (userInput.equalsIgnoreCase('s')) {
            // TODO: Do serialization stuff
                // Read the README... s
            
        } else if (userInput == "") {
            
            // Here's where the logic to get us our maze solver would go.
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
        
        System.out.println("Please tell me the name of the file you would like to write. ");
        String outBoundFile = new Scanner(System.in).nextline().close(); // Closing the Scannvi
        System.out.println("Saving file to: " + outBoundFile);

        // Serializing the file, variable name keystone to the infamous keystone pipeline!
        ObjectOutputStream keystone = new ObjectOutputStream(new FileOutputStream(outBoundFile));
        keystone.writeObejct(this);
        // Closing the keystone pipeline, very importante
        keystone.close();
    }

    /**
     * Quits the maze gracefully. TODO: Find out how to quit the maze gracefully without affecting the functionality of the tester.
     */
    private void quitMaze() {

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