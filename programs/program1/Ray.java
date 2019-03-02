/**
 * The Ray class creates an object oriented representation of a Ray, with a
 * start Point and a direction.
 * @author Ivan Martinez Morales
 * @version 1.0
 * @since 2019-01-30
 */

public class Ray {

    // DATA
    protected Point endPoint;
    protected int direction;

    // CONSTRUCTORS

    /**
     * Default construtor creates a Ray with the Point (3,4) and the direction of
     * 135 degrees.
     */
    public Ray() {

        this.endPoint = new Point(3, 4);
        this.direction = 135;
    }

    /**
     * Parameterized Constructor - accepts parameters to create the point and the
     * direction. Tests for proper parameters, and throws IllegalArgumentExpcetion
     * is either is null.
     * @param aPoint     - Point - a Point given by the user, cannot be null.
     * @param aDirection - int - a Direction given by the user. It can be zero.
     */
    public Ray(Point aPoint, int aDirection) {

        // CASE 1: Point is null
        if (aPoint == null) {
            throw new IllegalArgumentException("Illegal argument.  Point cannot be null!");
        }

        // CASE 2: Direction is not between 0 and 359 (including both)
        if ((aDirection < 0) || (aDirection >= 360)) {
            throw new IllegalArgumentException("Illegal Argument.  Direction must be between 0 and 359.");
        }

        // CASE 3: Both arguments are valid
        this.endPoint = aPoint;
        this.direction = aDirection;
    }

    /**
     * Copy Constructor Accepts a Ray, checks if it's null or not and then creates a
     * deep copy of the Ray.
     * @param Ray aRay - a Ray to be defined by the program.
     */
    public Ray(Ray aRay) {

        if (aRay == null) {
            throw new IllegalArgumentException("Cannot create a copy of a null array.");
        }

        this.endPoint = new Point(aRay.endPoint);
        this.direction = aRay.direction;
    }

    // METHODS

    /**
     * toString() - returns a string representation of the class.
     * @return - String representation of Ray i.e. endPoint----->Direction (make
     *           sure there are five dashes)
     */
    @Override
    public String toString() {

        return this.endPoint.toString() + "----->" + this.direction; // 5 DASHES - !IMPORTANT
    }

    /**
     * translate() method that will return nothing and translates, or shifts,
     * itself by the distances passed in
     * @param xMove - int that tells the x-direction to move the ray
     * @param yMove - int that tells the y-direction to move the ray.
     */
    public void translate(int xMove, int yMove) {

        this.endPoint.translate(xMove, yMove);
    }

    /**
     * rotate() Method that alters the direction of the Ray.
     * @param angle - int that must be greater than 0. Throws
     *              IllegalArgumentException
     */
    public void rotate(int angle) {

        // CASE 1: testing if angle is less than 0.
        if (angle < 0) {
            throw new IllegalArgumentException("Illegal Angle - Angle cannot be less than zero.");
        }

        // CASE 2: Angle is greater than or equal to 360.
        else if ((angle + direction) >= 360) {
            int temp = (direction + angle) % 360;
            direction = temp;
        }

        // CASE 3: Parameter and angle are less than 360.
        else if ((angle + direction) < 360) {
            direction += angle;
        }
    }

    /**
     * equals()
     * @param obj Object to compare our Ray instance to.
     * @return Boolean, indicating equality of endpoint and direction of Object that
     *         was recieved.
     */
    @Override
    public boolean equals(Object obj) {

        // CASE 1: Object is null
        if (obj == null) {
            return false;
        }

        // CASE 2: Object is not a Ray.
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        // CASE 3: Object is a ray, now it's time to compare the data within the class.
        Ray objRay = (Ray) obj;
        return (this.endPoint.equals(objRay.endPoint) && (this.direction == objRay.direction));
    }

    /**
     * goesAboveXAxis checks if <b>ANY</b> part of the Ray extends above the x-axis.
     * @return True if Ray resides above the x-axis.
     */
    public boolean goesAboveXAxis() {
            
            // CASE 1:  The endPoint is in the first two quadrants. 
            // This case will always return true, because the endPoint starts above the x axis.
            if (this.endPoint.inQuadrant(1) || this.endPoint.inQuadrant(2)) {
                
                return true;

            // CASE 2:  The endPoint is either below or on the X-axis.
            // This case will need to be tested to see if the direction is: 0 < x < 180.
            } else {
                
                return (this.direction > 0 && this.direction < 180);
            }
    }
}