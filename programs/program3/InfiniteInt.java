/**************************************************************************
 * Program Title: Program 3
 * Program author: Ivan Martinez Morales
 * Program due date: 30 April 2019
 **************************************************************************/

import java.util.*;

public class InfiniteInt extends DLList<Integer> implements Comparable<InfiniteInt> {

    /**************************************************************************
     *                                  DATA
     **************************************************************************/
    private StringTokenizer tokenizer;

    /**************************************************************************
     *                               CONSTRUCTORS
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
        // System.out.printf("The number of tokens that I will create are: %d\n", tokenizer.countTokens());

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            addLast(Integer.parseInt(token));
        }
    }

    /**************************************************************************
     *                                  METHODS
     **************************************************************************/
    /**
     * Returns a string represenatation of the number.
     * @return a string in the format: xxx,xxx,xxx,xxx for the given InfiniteInt.
     */
    public String toString() {
        String answer = "";
        // stuff belongs here in the middle.
        DLLNode<Integer> cursor = this.head;
        while (cursor != null) {

            int numberString = cursor.data.intValue();
            answer = answer.concat(String.format("%03d", numberString));
            
            if (cursor.next != null) {
                answer = answer.concat(",");
            }
            cursor = cursor.next;
        } 
        return answer; // DONE!
    }

    /**
     * Method that tests for equality between an infiniteint and an object.
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
     * @return a String representation of the underlying doubly-linked list.
     */
    public String superToString() {
        return super.toString(); 
    }

    /**
     * Returns true if the InfiniteInt is divisible by 5.
     * @return true if the InfiniteInt is divisible by 5. 
     */
    public boolean isDivisibleBy5() {
        return (this.tail.data.intValue() % 5 == 0);
    }

    /**
     * Returns true if the InfiniteInt is divisible by 1000.
     * @return true if the InfinteInt is divisible by 1000.
     */
    public boolean isDivisibleBy1000() {
        return (this.tail.data.intValue()) == 0 && (this.tail != this.head);
    }

    /**
     * compareIntegers compares the inner numbers inside of each DLL Node. Just like
     * compareTo, it will return a 1 when the int is larger.
     * @param comparedInt the InfiniteInt to compare our own class' int to.
     * @return 
     */
    public int compareTo(InfiniteInt comparedInt) {

        if (this.equals(comparedInt)) {
            return 0;
        }

        DLLNode<Integer> ourTail = this.tail;
        DLLNode<Integer> comparedTail = comparedInt.tail;
        int sizeComparison = Integer.compare(this.size(), comparedInt.size());

        switch (sizeComparison) {
            case 1: // first list is bigger
                sizeComparison = 1;
                break;
            case -1: // second list is bigger
                sizeComparison = -1;
                break;
            default: // the lists are of equal length
                while (ourTail.prev != null) {
                    if (ourTail.data.compareTo(comparedTail.data) == 1) {
                        sizeComparison = 1;
                        break;

                    } else if (ourTail.data.compareTo(comparedTail.data) == -1) {
                        sizeComparison = -1;
                        break;

                    } else {
                        ourTail = ourTail.prev;
                        comparedTail = comparedTail.prev;
                    }
                }
        }

        return sizeComparison;
    }

    /**
     * Adds two InfiniteInts together and returns the sum as an InfiniteInt.
     * @param firstInt first InfinteInt to be added.
     * @param secondInt second InfinteInt to be added.
     * @return InfinteInt answer - The sum of the two ints.
     */
    // public static InfiniteInt add(InfiniteInt firstInt, InfinteInt secondInt) {
    //     // 0. SET UP OUR ANSWER INFINITEINT FIRST.
    //     InfiniteInt answer = new InfinteInt();
    //     // 0. TRAVERSE EACH LIST SIMUTANIOUSLY
    //     DLLNode<Integer> firstCursor = firstInt.tail;
    //     DLLNode<Integer> secondCursor = secondInt.tail;
    //     int carryOver = 0;
    //     // TRAVERSE THE LISTS SIMUATNIOUSLY (spelling D:)
    //     while (firstInt.prev != null) {
    //         int temp = firstCursor.data.intValue() + secondCursor.data.intValue();
    //         if (temp >= 1000) {
    //             carryOver = 1;
    //             sum = temp - 1000;

    //         } 
    //     }
    //     // 1. WHILE TRAVERSING, ADD THE TWO NUMBERS TOGETHER
    //     // 2. IF THE NUMBER IS GREATER THAN 1,000, THEN CARRY THE VALUE OVER TO THE NEXT INT
    //     // 3. CLEAR THE CARRY OVER BECAUSE YOU'LL RUIN YOUR DAY IF YOU DON'T. 
    // }

}