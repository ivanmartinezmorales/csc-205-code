/**
 * infinite int - 
 * 
 * 
 */
import java.util.*;

public class InfiniteInt extends DLList<Integer> {
    
    // DATA
    private StringTokenizer numberMaker;

    // CONSTRUCTORS
    public InfiniteInt(String number) {

        numberMaker = new StringTokenizer(number);
        System.out.println("The number of tokens will be: " + numberMaker);
        while (numberMaker.hasMoreTokens()) {
        
            String token = numberMaker.nextToken();
            System.out.println("the next token to be processed is: " + token);
            // Save the token into the linkedList.
            
        }
    }
    // METHODS
}