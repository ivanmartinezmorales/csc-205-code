
/**************************************************************************
 * Program Title: Program 3
 * Program author: Ivan Martinez Morales
 * Program due date: 30 April 2019
 **************************************************************************/

import java.util.*;

public class InfiniteInt extends DLList<Integer> implements Comparable<InfiniteInt> {

    /**************************************************************************
     * DATA
     **************************************************************************/
    private StringTokenizer tokenizer;

    /**************************************************************************
     * CONSTRUCTORS
     **************************************************************************/
    /**
     * Default contructor accepts no agruments and builds a null linked list.
     */
    public InfiniteInt() {
        super();
    }

    /**
     * Paramaterized contructor recieves a String as an argument and then builds a
     * linked list.
     * 
     * @param integerString the string that will be parsed by the constructor.
     */
    public InfiniteInt(String integerString) {

        tokenizer = new StringTokenizer(integerString, ",");
        // System.out.printf("The number of tokens that I will create are: %d\n",
        // tokenizer.countTokens());

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            addLast(Integer.parseInt(token));
        }
    }

    /**************************************************************************
     * METHODS
     **************************************************************************/
    /**
     * Returns a string represenatation of the number.
     * 
     * @return a string in the format: xxx,xxx,xxx,xxx for the given InfiniteInt.
     */
    public String toString() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Cannot iterate over empty list.");
        }

        String answer = "";

        // stuff belongs here in the middle.
        DLLNode<Integer> cursor = this.head;
        while (cursor != null) {

            int numberString = cursor.data.intValue();

            if (cursor == this.head) {
                answer = answer.concat(Integer.toString(numberString));
            } else {
                answer = answer.concat(String.format("%03d", numberString));
            }

            if (cursor.next != null) {
                answer = answer.concat(",");
            }
            cursor = cursor.next;
        }
        return answer; // DONE!
    }

    /**
     * Method that tests for equality between an infiniteint and an object.
     * 
     * @param o The object to be compared.
     * @return true if the two InfiniteInts are identical.
     */
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }
        InfiniteInt objInfInt = (InfiniteInt) o;
        return this.toString().equals(objInfInt.toString());
    }

    /**
     * Method that class the parent class's toString().
     * 
     * @return a String representation of the underlying doubly-linked list.
     */
    public String superToString() {
        return super.toString();
    }

    /**
     * Returns true if the InfiniteInt is divisible by 5.
     * 
     * @return true if the InfiniteInt is divisible by 5.
     */
    public boolean isDivisibleBy5() {
        return this.tail.data.intValue() % 5 == 0;
    }

    /**
     * Returns true if the InfiniteInt is divisible by 1000.
     * 
     * @return true if the InfinteInt is divisible by 1000.
     */
    public boolean isDivisibleBy1000() {
        return this.tail.data.intValue() == 0;
    }

    /**
     * compareIntegers compares the inner numbers inside of each DLL Node. Just like
     * compareTo, it will return a 1 when the int is larger.
     * 
     * @param comparedInt the InfiniteInt to compare our own class' int to.
     * @return
     */
    public int compareTo(InfiniteInt comparedInt) {

        if (this.equals(comparedInt)) {
            return 0;
        }

        DLLNode<Integer> ourHead = this.head;
        DLLNode<Integer> comparedHead = comparedInt.head;
        int sizeComparison = Integer.compare(this.size(), comparedInt.size());

        switch (sizeComparison) {
        case 1: // first list is bigger
            sizeComparison = 1;
            break;
        case -1: // second list is bigger
            sizeComparison = -1;
            break;
        default:
            /*
             * Works by first checking the leading term, and then if those two are equal,
             * then continue moving down
             */
            while (ourHead.next != null) {
                if (ourHead.data.compareTo(comparedHead.data) == 1) {
                    sizeComparison = 1;
                    break;

                } else if (ourHead.data.compareTo(comparedHead.data) == -1) {
                    sizeComparison = -1;
                    break;

                } else {
                    ourHead = ourHead.next;
                    comparedHead = comparedHead.next;
                }
            }
        }

        return sizeComparison;
    }

    /**
     * Adds two InfiniteInts together piece by piece.
     * 
     * @param firstInt  the first InfiniteInt to be added.
     * @param secondInt the second InfiniteInt to be added.
     * @return InfiniteInt response, where the result is given.
     */
    public static InfiniteInt add(InfiniteInt firstInt, InfiniteInt secondInt) {
        int sum = 0;
        int carry = 0;

        // CREATE OUR NEW LIST
        InfiniteInt response = new InfiniteInt();

        // SUMMON CURSORS
        DLLNode<Integer> firstCursor = firstInt.tail;
        DLLNode<Integer> secondCursor = secondInt.tail;

        /**
         * 3 DISTINCT CASES: 1. The cursors are both not null - in which case, we will
         * add both numbers together 2. The first cursor is null - in which case, add
         * the carry with the second cursor. 3. The second cursor is null - add the
         * first cursor and the carry.
         * 
         * Lastly, if there are any remaining carry bits, then add those to the list
         * too.
         */
        while (firstCursor != null || secondCursor != null) {
            if (firstCursor != null && secondCursor != null) {
                sum = (firstCursor.data + secondCursor.data + carry) % 1000;
                carry = (firstCursor.data + secondCursor.data + carry) / 1000;
                firstCursor = firstCursor.prev;
                secondCursor = secondCursor.prev;
            } else if (firstCursor == null && secondCursor != null) {
                sum = (secondCursor.data + carry) % 1000;
                carry = (secondCursor.data + carry) / 1000;
                secondCursor = secondCursor.prev;
            } else if (firstCursor != null && secondCursor == null) {
                sum = (firstCursor.data + carry) % 1000;
                carry = (firstCursor.data + carry) / 1000;
                firstCursor = firstCursor.prev;
            }
            response.addFirst(sum);
        }
        // Lastly, if our carry bit is 1 then we should prepend it to the list.
        if (carry != 0) {
            response.addFirst(carry);
        }

        return response;
    }
}
