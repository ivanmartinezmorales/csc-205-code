public class MazeSolver {
    
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
    public boolean Solve() {
        
        do {
        // User decides to exit.
        if (userInput.equalsIgnoreCase('q')) {
            // Need to find a way to find a way to kill this program without using system.exit()
        }

        else if (userInput.equalsIgnoreCase('s')) {
            // TODO: Do serialization stuff
                // Read the README... s
            
        } else if (userInput == "") {
            
            // Here's where the logic to get us our maze solver would go.
            if (aMaze.isOpen(Direction.DOWN) && !positionArray[aMaze.getCurrentRow()][aMaze.getCurrentCol()]) {

                aMaze.move(Direction.DOWN);

                System.out.println("Moved DOWN.");
                directionStack.push(Direction.DOWN);
                positionArray[aMaze.getCurrentRow()][aMaze.getCurrentCol()] = true;

            } else if (aMaze.isOpen(Direction.RIGHT) && !positionArray[aMaze.getCurrentRow()][aMaze.getCurrentCol()]) {

                aMaze.move(Direction.RIGHT);

                System.out.println("Moved RIGHT.");
                directionStack.push(Direction.RIGHT);
                positionArray[aMaze.getCurrentRow()][aMaze.getCurrentCol()] = true;

            } else if (aMaze.isOpen(Direction.LEFT) && !positionArray[aMaze.getCurrentRow()][aMaze.getCurrentCol()]) {

                aMaze.move(Direction.LEFT);

                System.out.println("Moved LEFT.");
                directionStack.push(Direction.LEFT);
                positionArray[aMaze.getCurrentRow()][aMaze.getCurrentCol()] = true;

            } else if (aMaze.isOpen(Direction.UP) && !positionArray[aMaze.getCurrentRow()][aMaze.getCurrentCol()]) {

                aMaze.move(Direction.UP);

                System.out.println("Moved UP.");
                directionStack.push(Direction.UP);
                positionArray[aMaze.getCurrentRow()][aMaze.getCurrentCol()] = true;


            } else {

                // 1. Popping the stack.
                temp = directionStack.pop();
                System.out.println("Popped the stack!")
                // 2. Run the direction that's popped throught the switch.
                switch (temp) {

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

        } while (!aMaze.goalReached());
    }
}