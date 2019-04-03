/**
 * the MazeSolver class is a class built to solve beautiful Java mazes given to us in CSC205.
 * This mazeSolver was created by Ivan Martinez Morales, of Glendale Community College,
 * on this day, 1 April 2019.
 */

import java.util.*;
import java.io.*;

public class MazeSolver implements java.io.Serializable {
    
    // DATA
    private Stack<Direction> directionStack;
    private boolean[][] positionArray;
    private Maze aMaze;
    private static MazeDisplay display;
    private static Scanner kb;

    // CONSTRUCTORS
    /**
     * Default constructor builds four things: the Scanner (to accept inputs)
     * @param numRows - number of rows that the user wants to create the maze with.
     * @param numCols - number of columns that the user wants to create the maze with.
     */
    public MazeSolver(int numRows, int numCols) {
        
        
        this.aMaze = new Maze(numRows, numCols);
        this.positionArray = new boolean[numRows][numCols];
        this.directionStack = new Stack<Direction>();

        aMaze.buildMaze(0);
        aMaze.setSolveAnimationDelay(0);
    }

    // METHODS
    /**
    * Method that solves the maze with the do-while loop. Outward facing method in entire class.
    */
    public boolean solve() {

        display = new MazeDisplay(aMaze);
        kb = new Scanner(System.in);
        System.out.println("End of Maze Solver Constructor"); 

        do {
            
            String userInput = kb.nextLine();

            // User enters a q
            if (userInput.matches("[Qq]{1}")) {

                display.dispose(); 
                System.out.println("Now leaving maze. Goodbye!");

            // User enters an s
            } else if (userInput.matches("[Ss]{1}")) {
                
                System.out.println("Please tell me the name of the file you'd like to write.");
                String outboundFileName = kb.nextLine();
                serializeMaze(outboundFileName);
            
            // User hits "enter"
            } else if (userInput.isEmpty()) {
    
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
            
        } while (!aMaze.goalReached());
        display.dispose();
        return true;
    }

    /**
     * Serializes the maze and saves it to the file of the user's choosing.
     * This method handles its exceptions locally. 
     * @param fileName name of the file to record
     */
    private void serializeMaze(String fileName) {

        System.out.printf("Saving file to %s\n", fileName);

        try {
    
            ObjectOutputStream keystone = new ObjectOutputStream(new FileOutputStream(fileName));
            System.out.println("Saving file now...");
            keystone.writeObject(this);
            keystone.close();

        } catch (Throwable e) {
            
            e.printStackTrace();
            System.out.println("Uh oh, something went wrong. Check your file name!");
        
        }

        System.out.println("File saved. Press Enter to continue solving Maze, q to quit, and s to save.");
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
