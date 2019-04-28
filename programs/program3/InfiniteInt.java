
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

    public static InfiniteInt add(InfiniteInt firstInt, InfiniteInt secondInt) {
        // 0. SETTING UP OUR RESPONSE LIST.
        InfiniteInt response = new InfiniteInt();
        int listComparison = Integer.compare(firstInt.size(), secondInt.size());

        switch (listComparison) {
        case 1:
            add(firstInt, secondInt, response);
            break;

        case -1:
            add(secondInt, firstInt, response);
            break;
        default:
            System.out.println("The lists are equal!");
            add(firstInt, secondInt, response);
            break;
        }
        return response;

    }

    private static void add(InfiniteInt longerInt, InfiniteInt shorterInt, InfiniteInt response) {
        DLLNode<Integer> longCursor = longerInt.tail;
        DLLNode<Integer> shortCursor = shorterInt.tail;

        int sum = 0;
        int carryOver = 0;

        if ((longerInt.size() == 1) && (shorterInt.size() == 1)) {
            sum = Integer.sum(longCursor.data, shortCursor.data);

            if (sum >= 1000) {
                carryOver = 1;
                sum = sum - 1000;
            }
            response.addFirst(sum);

            if (carryOver > 0) {
                response.addFirst(carryOver);
            }
        } else {

            for (int i = 0; i < longerInt.size(); i++) {

                if (shortCursor == null) {
                    response.addFirst(longCursor.data + carryOver);
                }
                sum = carryOver + Integer.sum(longCursor.data, shortCursor.data);
                if (sum >= 1000) {
                    carryOver = 1;
                    sum = sum - 1000;
                } else {
                    carryOver = 0;
                }
                response.addFirst(sum);
                sum = 0;
                if (longCursor.prev == null) {
                    // we're at our last node, so add the carry together.
                    int ultimateSum = Integer.sum(carryOver, longerInt.head.data);
                    if (ultimateSum < 1000) {
                        response.addFirst(ultimateSum);
                    } else {
                        response.addFirst(ultimateSum - 1000);
                        response.addFirst(1);
                    }
                } else {
                    longCursor = longCursor.prev;
                }

                shortCursor = shortCursor.prev;
            }

        }
    }

    // TODO: REMOVE THIS METHOD BEFORE TURNING IN ASSIGNMENT
    public static void print(String printedString) {
        System.out.println(printedString);
    }
}