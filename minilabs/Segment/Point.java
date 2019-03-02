/**
 * Program Name: Point.java Program author: Ivan Martinez Morales Program Due
 * Date: 03 February 2019
 * 
 * Program Description: This class Point represents a geometric point in a
 * Cartesian plane.
 * 
 */

public class Point implements PointInterface {
    // Data
    private int x;
    private int y;

    // --------------------------- CONSTRUCTORS ------------------------------------
    // Default constructor
    public Point() {
        this.x = 2;
        this.y = -7;
    }

    // Parameterized constructor
    public Point(int xValue, int yValue) {
        this.x = xValue;
        this.y = yValue;
    }

    // Copy constructor
    public Point(Point otherPoint) throws IllegalArgumentException {
        if (otherPoint == null) {
            throw new IllegalArgumentException("The Point has nothing inside of it!");
        }
        this.x = otherPoint.x;
        this.y = otherPoint.y;
    }

    // --------------------------- METHODS ------------------------------------ //

    /**
     * toString returns the string representation of the point. Example: "(2,-7)"
     * Overrides the toSting method native to the Object class.
     */
    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

    /**
     * returns the distance from between this instance of the point, and other
     * point. Throws Exception if other point is null.
     */
    @Override
    public double distanceTo(Point otherPoint) throws IllegalArgumentException {
        if (otherPoint == null) {
            throw new IllegalArgumentException("The point given is null. Cannot use null values.");
        }

        double distance = Math.sqrt(Math.pow((otherPoint.x - this.x), 2) + Math.pow((otherPoint.y - this.y), 2));

        return distance;
    }

    /**
     * Equals() - checks for strict equality between an object and our Point class. Returns true if equality is true
     * Returns false if equality is just not there.  
     */
    @Override
    public boolean equals(Object obj) {
     
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        } 

        // casting the object to a point object.
        Point other = (Point) obj;
        return this.x == other.x && this.y == other.y;
    }

    /**
     * inQuadrant - returns true if our point is in the quadrant specified
     * Throws IllegalArgumentException when quardrant is beyond 1-4.  
     */
    @Override
    public boolean inQuadrant(int quadrant) throws IllegalArgumentException {
        switch(quadrant) {
            case 1:
                return this.x > 0 && this.y > 0;
            case 2:
                return this.x < 0 && this.y > 0;
            case 3:
                return this.x < 0 && this.y < 0;
            case 4:
                return this.x > 0 && this.y < 0;
            default:
                throw new IllegalArgumentException("Quadrant value out of bounds!");
        }
    }

    /**
     * changes the point x's and y's by what is recieved
     * @param xMove - number of units to move x coordinate.
     * @param yMove - number of units to move y coordinate.
     */
    @Override
    public void translate(int xMove, int yMove) {
        this.x += xMove;
        this.y += yMove;
    }

    /**
     * onXAxis() - returns true if Point is on the X-axis
     */
    @Override
    public boolean onXAxis() {
        return this.y == 0;
    }

    /**
     * onYAxis() - returns true if Point is on Y-Axis
     */
    @Override
    public boolean onYAxis() {
        return this.x == 0;
    }


}