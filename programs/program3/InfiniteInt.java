/**
 *  
 */

import java.util.*;

public class InfiniteInt extends DLList<Integer> implements Comparable<InfiniteInt> {

    /**************************************************************************
     *                                  DATA
     **************************************************************************/
    private StringTokenizer tokenizer;

    /**************************************************************************
     *                                  CONSTRUCTORS
     **************************************************************************/
    /**
     *  Default contructor accepts no agruments and builds a null linked list. 
     */
    public InfiniteInt() {
        super();
    }
    /**
     * Paramaterized contructor recieves a String as an argument and then builds a linked list. 
     * @param integerString the string that will be parsed by the constructor.
     */
    public InfiniteInt(String integerString) {

        tokenizer = new StringTokenizer(integerString, ",");
        System.out.printf("The number of tokens that I will create are: %d\n", tokenizer.countTokens());
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            addLast(Integer.parseInt(token));
        }
        System.out.println(super.toString());
        System.out.println(this.getClass());
    }

    /**************************************************************************
     *                                  METHODS
     **************************************************************************/
    /**
     * Returns a string represenatation of the number.
     */
    public String toString() {
        String answer = "";
        // stuff belongs here in the middle.
        DLLNode<Integer> cursor = this.head;
        while (cursor != null) {

            int numberString = cursor.data.intValue();
            answer = answer.concat(String.format("%03d", numberString));
            
            // Sprinkling in those commas:
            if (cursor.next != null) {
                answer = answer.concat(",");
            }
            cursor = cursor.next;
        } 

        return answer; // DONE!
    }

    /**
     * Method that tests for equality between an infiniteint and an object.
     */
    public boolean equals(Object o) {
        if (o == null) {
            return false;

        } else if (o.getClass() != this.getClass()) {
            return false;

        } else {
            // TODO: Add cast to InfiniteInt class here.
        }
        return false; // scaffolding
    }
    
    /**
     * Method that class the parent class's toString().
     */
    public String superToString() {
        return super.toString(); 
    }

    /**
     * Returns true if the InfiniteInt is divisible by 5.
     * The the method works by checking the tail, since we can have an
     * infinitismally large number like 124,245,235,235,205 and the number
     * would return true because the number ends in 5, meeting the criteria 
     * for being divisible by 5. The same can be said about test cases like:
     * 777,777,777,775 where the value would return true as well.
     */
    public boolean isDivisibleBy5() {
        return (this.tail.data.intValue() % 5 == 0);
    }

    /**
     * Returns true if the InfiniteInt is divisible by 1000.
     * The method works by checking if the tail is 0. If the tail is zero,
     * then the last three digits of the InfiniteInt are technically zero.
     * Also, we need to check that the tail is not the head, as this would mean that
     * the InfiniteInt is only zero.
     */
    public boolean isDivisibleBy1000() {
        return (this.tail.data.intValue()) == 0 && (this.tail != this.head);
    }

    /**
     * Compares two InfiniteInts against eachother.
     */
    public int compareTo(InfiniteInt o) {
        return -1; // scaffolding
    }


}