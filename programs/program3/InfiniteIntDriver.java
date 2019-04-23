import java.util.*;

public class InfiniteIntDriver {

    private static String[] testCases = {"100,000,000,000", "123,123,123,123", "123", "485,123,127,055", "1", "192,123,123,123,123,123"};
    
    public static void main(String[] args) {
       print("setting up testing environment");
        for (String s : testCases) {
            testCase(s);        
        }
        print("testing complete!");
    }
    
    public static void testCase(String infiniteString) {

        // 1. Create our infinite int.
        System.out.printf("Creating number with: %s\n", infiniteString);
        InfiniteInt number = new InfiniteInt(infiniteString);
        // TEST toString()
        print("Testing .toString() method..");
        print(number.toString());
        print("Should have printed out: " + number.toString());

        // Testing isDivisibleBy5 and 1000.
        print("Testing divisiblibility functions... ");
        System.out.printf("Is %s divisible by 5? %b\n", number.toString(), number.isDivisibleBy5());
        System.out.printf("Is %s divisible by 1000? %b\n", number.toString(), number.isDivisibleBy1000());

        // Testing superToString()
        print("Testing superToString()...");
        System.out.printf("The superToString is: %s\n", number.superToString());

        print("End of testing. Methods not tested: compareTo(), equals(), and add()");
        print("\n\n\n");
    }

    public static void print(String printString) {
        System.out.println(printString);
    }

}