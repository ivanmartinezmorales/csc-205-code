//This class will simulate a Die (half a pair of dice)

public class Die {
	// ------- data
	private int numSides;
	private java.util.Random rGen;

	// ------- constructors
	public Die() {
		this(6); // call parameterized constructor, as if 6 were passed in
	}

	public Die(int theSides) {
		if (theSides < 4)
			throw new IllegalArgumentException("A Die cannot have less than 4 sides");

		numSides = theSides;
		rGen = new java.util.Random(numSides);
	}

	// ------- methods
	// getNumSides - returns the number of sides
	public int getNumSides() {
		return numSides;
	}

	// roll - returns a random number from 1-numSides. The seed for the random
	// number generator should be the numSides
	// (so everyone's results are the same...)
	public int roll() {
		return rGen.nextInt(numSides) + 1;
	}

}