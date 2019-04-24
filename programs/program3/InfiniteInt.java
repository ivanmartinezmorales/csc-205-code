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

            if (token.matches("[A-Za-z]") == true) {
                System.out.println(token);
                System.out.println("This string contains invalid characters.");
                throw new IllegalArgumentException("Invalid Character!");
            }

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
                /* Works by first checking the leading term, and then if those two are equal, then continue moving down*/
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
     * Adds two InfiniteInts together and returns the sum as an InfiniteInt.
     * @param firstInt first InfinteInt to be added.
     * @param secondInt second InfinteInt to be added.
     * @return InfinteInt answer - The sum of the two ints.
     */
    // public static InfiniteInt add(InfiniteInt firstInt, InfinteInt secondInt) {
    //     // 0. SET UP OUR ANSWER INFINITEINT FIRST.
    //     InfiniteInt answer = new InfinteInt();
    //     DLLNode<Integer> firstCursor = firstInt.tail;
    //     DLLNode<Integer> secondCursor = secondInt.tail;
        
    //     // FIGURE OUT WHICH ONE IS LONGER:
    //     int lengthComparison = Integer.compare(firstInt.size(), secondInt.size());
    //     switch (lengthComparison) {
    //         case 1: // first list is longer:
    //             while (secondCursor.prev != null) {
    //                 answer.addFirst(Integer.sum(firstInt.data, secondInt.data));
    //                 // do stuff
    //             }
    //         case -1: // second list is longer:
    //             while (firstCursor.prev != null) {
    //                 // do stuff
    //             }
    //         default: // lists are the same length:
    //             while (firstCursor.prev != null) {
    //                 // do stuff
    //             }
    //     }
    //     return answer;
    // }

    public static InfiniteInt add(InfiniteInt firstInt, InfiniteInt secondInt) {
        // 0. SETTING UP OUR RESPONSE LIST.
        InfiniteInt reponse = new InfiniteInt();
        int listComparison = Integer.compare(firstInt.size(), secondInt.size());
        
        switch (listComparison) {
            case 1:
                add(firstInt, secondInt, response);    
                break;
        
            case -1:
                add(secondInt, firstInt, response);
                break;
            default:
                add(firstInt, secondInt, response);
                break;
        }
        return response;

    }

    private static void add(InfiniteInt longerInt, InfiniteInt shorterInt, InfiniteInt response) {
        // START ADDING FROM THE LONGER ONE.
        DLLNode<Integer> longCursor = longerInt.tail;
        DLLNode<Integer> shortCursor = shorterInt.tail;
        int sum = 0;
        int carryOver = 0;
        // START WALKING BACK FROM THE END OF THE LIST (smallest digits, just like how you add numbers in rea life.)
        while (longCursor.prev != null) {
            //  HANDLE IF THERE ARE EXTRA DECIMAL PLACES
            if (shortCursor.data == null) {
                response.addFirst(Integer.sum(longCursor.data, carryOver));
            }

            sum = ++carryOver; // ADDING THE CARRYOVER TO THE SUM BEFORE THE SUM IS RUINED.
            carryOver = 0; // CARRY OVER HAS BEEN EXPENDED MOTHERFUCKER.
            sum = sum + Integer.sum(longCursor.data, shortCursor.data); // ADDING THESE TWO GODDAMN NUMBERS TOGETHER.
            System.out.printf("The sum of the two nodes is: %d\n\n", sum); // TELLING THE USER WHAT WE'VE ADDED
            if (sum >= 1000) { // IF THE GODDAMN NUMBER IS TOO BIG, THEN SUBTRACT 1000, AND INCREMENT THE SUM
                 // PARSE THE INT INTO THE CARRY, AND THE SUM.
                carryOver = 1;
                sum = sum - 1000;
            }
            // NOW, WE HAVE OUR SWEET LIL' SUM THAT WE'RE GOING TO MAKE INTO OUR NODE.
            response.addFirst(sum);
            // NOW GET TEAR ALL THIS SHIT DOWN AND GET IT READY FOR THE NEXT ITERATION
            sum = 0;
            longCursor = longCursor.prev;
            if (shortCursor.data == null) {
                continue;
            }
            shortCursor = shortCursor.prev;
        } 
    }
}