import java.util.ArrayList;


public class EvenDeck implements EvenDeckInterface {

    /** DATA **/

    private ArrayList<Integer> cardDeck;

    /** CONSTRUCTORS **/

    /**
     * Constructs a deck of cards with the specified initial capacity.
     * @param deckSize - instantiate the arrayList with deckSize
     * @throws IllegalArgumentException if deckSize < 0 or deckSize is odd.
     */
    public EvenDeck(int deckSize) throws IllegalArgumentException {

        // Deck size is less than 0 or Deck Size is odd, throw IAE
        if ((deckSize <= 0)  || (deckSize % 2 != 0)) {
            throw new IllegalArgumentException("Illegal deckSize.  Deck Size must be greater than 0 and even.");
        }
        
        // Creating and filling out our Deck.
        cardDeck = new ArrayList<Integer>();
        for (int i=0; i<deckSize; i++) {

            this.cardDeck.add(i+1);
        }
    }

    /**
     * Constructs an deck of cards with 8 cards inside of it.
     */
    public EvenDeck() {
        this(8);
    }

    /**
     * Copy constructor creates a deck of cards with the same as the argument's.
     */
    public EvenDeck(EvenDeck another) {

        if (another == null) {
            throw new IllegalArgumentException("Cannot copy a null EvenDeck.");
        }
    
        this.cardDeck = new ArrayList<Integer>();
        for(int n : another.cardDeck) {
            this.cardDeck.add(n);
        }
    }


    /** Methods **/
    
    /**
     * Returns a String representation of the object.
     */
    @Override
    public String toString() {

        return cardDeck.toString();
    }

    /**
     * Indicates whether some other object is "equal to" this object.
     * @param obj Reference Object we're comparin'
     * @return True if the EvenDeck is the same as the obj argument; false otherwise.
     */
    public boolean equals(Object obj) {

        // CASE 1: obj is null
        if (obj == null) {
            return false;
        }

        // CASE 2: obj is not an EvenDeck
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        // Casting obj to an EvenDeck class and comparing the ArrayLists inside.
        EvenDeck otherDeck = (EvenDeck) obj;

        return (this.cardDeck.equals(otherDeck.cardDeck));
    
    }
    /**
     * Performs a single "Perfect Shuffle" as seen on RosettaCode.
     */
    public void perfectShuffle() {

        // SETUP
        int half = this.cardDeck.size() / 2;
        ArrayList<Integer> cardDeckCopy = new ArrayList<Integer>();
        
        // POPULATE ARRAYLIST
        for (int n : this.cardDeck) {cardDeckCopy.add(n);}

        // DO THE PERFECT SHUFFLE (techno music plays)
        for (int i = 0; i < half; i++) {
            
            cardDeck.set((2 * i), cardDeckCopy.get(i));
            cardDeck.set((2*i+1), cardDeckCopy.get(i + half));
        }
    }

    /**
     * Returns the number of perfect shuffles it takes to return the given deck of cards back to its original.
     * @return The number of shuffles it takes to get back to the Array's original state.
     */
    public int numShuffles() {

        // 1. Create copy and populate ArrayList to compare.        
        ArrayList<Integer> originalCardDeck = new ArrayList<Integer>();
        // 2. Populate ArrayList.
        for (int n : this.cardDeck) originalCardDeck.add(n);
        // 3. Setup counter
        int counter = 0;
        // 4. Do the perfect shuffle (techno music ensues)
        do {
            perfectShuffle();
            counter++;
        } while (!cardDeck.equals(originalCardDeck));
        
        return counter;
    }

}
