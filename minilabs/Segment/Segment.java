/**
 * Program title: Segment.java
 * Program author: Ivan Martinez Morlaes
 * Program Due Date: 04 Feb 2019
 * Program Description: Segment class implements the Segment Interface.
 *                      The class creates a line segment between two 
 *                      Points.  Has three constructors that create three
 *                      Different types of points. 
 */

public class Segment implements SegmentInterface {

    // DATA
    private Point firstEndpoint;
    private Point secondEndpoint;

    // CONSTRUCTORS
    /**
     * DEFAULT CONSTRUCTOR - creates a line segment based on the
     * these points:
     *      (1,1) and (7,7)
     */
    public Segment() {
        this.firstEndpoint = new Point(1,1);
        this.secondEndpoint = new Point(7,7);
    }

    /**
     * 2-PARAMETER CONSTRUCTOR - accepts two points
     * and sets the end points to those received
     * @param Point firstPoint - first Point in the segment
     * @param Point secondPoint - second Point in the segment
     */
    public Segment(Point firstPoint, Point secondPoint) throws IllegalArgumentException {

        // first checking if eithe point is null
        if ((firstPoint == null) || (secondPoint == null)) {
            throw new IllegalArgumentException("Can't create anything with null points. Please check your points and try again");

        } else if (firstPoint.equals(secondPoint)) {
            throw new IllegalArgumentException("Segment length is zero. Cannot create this.");

        } else {
            this.firstEndpoint = firstPoint;
            this.secondEndpoint = secondPoint;
        }
    }

    /**
     * 1-PARAMETER CONSTRUCTOR - creates a line segment where the first point is (0, 0)
     * @param aPoint - A Point that the user designates.
     */
    public Segment(Point aPoint) {
        this(new Point(0,0), aPoint);
    }

    /**
     * COPY CONSTRUCTOR - creates a deep copy of the line segment.
     */
    public Segment(Segment copySegment) throws IllegalArgumentException {

        if (copySegment == null) {
            throw new IllegalArgumentException("Cannot copy a null segment.");
        }
        this.firstEndpoint = new Point(copySegment.firstEndpoint);
        this.secondEndpoint = new Point(copySegment.secondEndpoint);
    }


    // METHODS 
    /**
     * toString() - returns a string representation of the class in the format"
     *  @return "Segment" + firstEndpoint + secondEndpoint
     */
    @Override
    public String toString() {
        return "Segment" + firstEndpoint.toString() + secondEndpoint.toString();
    }

    /**
     * Length() - returns the length of the segment
     * @return - length of segmenet as a double
     */
    @Override
    public double length() {
        return firstEndpoint.distanceTo(secondEndpoint);
    }

    /**
     * Translate - shifts the whole segment by the given parameters. 
     * @param int xMove - the x-coordinate shift of the segment
     * @param int yMove - the y-coordinate shift of the segment
     */
    @Override
    public void translate(int xmove, int ymove) throws IllegalArgumentException {
        this.firstEndpoint.translate(xmove, ymove);
        this.secondEndpoint.translate(xmove, ymove);
    }

    /**
     * isAnEndpoint
     * @param Point p, a point that the user uses to test if the point is an endpoint. 
     * @return boolean True if point given is an endpoint and false otherwise.
     */
    @Override
    public boolean isAnEndpoint(Point p) throws IllegalArgumentException {
        // test for null first
        if (p == null) {
            throw new IllegalArgumentException("Cannot compare a null point. ");
        }
        return (firstEndpoint.equals(p) || secondEndpoint.equals(p));
    }

    /**
     * equals() - method to test equality between two segments.
     * @param Object of the user's choosing.  
     * @return returns true if and only if Segment is equal to other segment. 
     */
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }

        if (this.getClass() != other.getClass()) {
            return false;
        }

        Segment seg = (Segment) other;
        return ((seg.firstEndpoint.equals(this.firstEndpoint) && (seg.secondEndpoint.equals(this.secondEndpoint))
                || (seg.firstEndpoint.equals(this.secondEndpoint) && seg.secondEndpoint.equals(this.firstEndpoint)))) ;
    }
}