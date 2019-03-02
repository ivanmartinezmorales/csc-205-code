//This is the interface for a Point class (which will represent a 2-dimensional Point)

public interface PointInterface {
    // toString
    // returns a String representing this instance in the form (x,y) (WITHOUT a
    // space after the ,)
    @Override
    public String toString();

    // distanceTo
    // throws a new IllegalArgumentException(<your descriptive String> if null is
    // received
    // returns the distance from this Point to the Point that was received
    // NOTE: there is a static method in the Math class called hypot can be useful
    // for this method
    public double distanceTo(Point otherPoint);

    // equals - returns true if it is equal to what is received (as an Object)
    @Override
    public boolean equals(Object obj);

    // inQuadrant
    // returns true if this Point is in the quadrant specified
    // throws a new IllegalArgumentException if the quadrant is out of range (not
    // 1-4)
    public boolean inQuadrant(int quadrant);

    // translate
    // changes this Point's x and y value by the what is received (thus
    // "translating" it)
    // returns nothing
    public void translate(int xMove, int yMove);

    // onXAxis
    // returns true if this Point is on the x-axis
    public boolean onXAxis();

    // onYAxis
    // returns true if this Point is to the on the y-axis
    public boolean onYAxis();

    // =============================================
    // The method definitions below are commented out and
    // do NOT have to be implemented
    // //=============================================

    // halfwayTo
    // throws a new IllegalArgumentException(<your descriptive String> if null is
    // received
    // returns a new Point which is halfway to the Point that is received
    // public Point halfwayTo(Point another);

    // slopeTo
    // throws a new IllegalArgumentException(<your descriptive String> if null is
    // received
    // returns the slope between this Point and the one that is received.
    // since the slope is (changeInY/changeInX), then first check to see if
    // changeInX is 0
    // if so, then return Double.POSITIVE_INFINITY; (since the denominator is 0)
    // public double slopeTo(Point anotherPoint)
}
