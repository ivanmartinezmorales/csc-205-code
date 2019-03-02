//This is the interface for the Segment class

public interface SegmentInterface
{
	//toString - returns its representation as a String in the form "Segment" then endpoint1 then endpoint2
 @Override
	public String toString();

	//length - returns the length
	public double length();

	//translate - shifts the whole segment by xmove (in x direction) and ymove (in y direction)
	public void translate(int xmove, int ymove);

	//isAnEndpoint - returns true if the received Point is an endpoint of this Segment
	public boolean isAnEndpoint(Point p);

	//equals - returns true if this Segment is equal to the one that is passed in (endpoints can be in either order)
 @Override
	public boolean equals(Object other);
}
