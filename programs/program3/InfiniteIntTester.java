
public class InfiniteIntTester {

    private static String[] testCases = { "100,000,000,000", "123,123,123,123", "123", "485,123,127,055", "1",
            "192,123,123,123,123,123" };

    public static void main(String[] args) {

        /**
         * ROUND ONE OF TESTING! Testing toString, and divisibility functions.
         */
        // print("setting up testing environment");
        // for (String s : testCases) {
        // testCase(s);
        // }
        // print("First batch of testing complete!");

        /**
         * ROUND TWO OF TEST CASES: TESTING compareTo, add, and equals
         */
        // print("Setting up testing environment for second round of tests");
        // for (int i = 1; i < testCases.length; i++) {
        // testCompareTo(testCases[i], testCases[i-1]);
        // }

        // print("Second round of test cases complete.");

        // testCompareTo("123", "456");
        testAdd();

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

    public static void testCompareTo(String infiniteString, String infiniteStringTwo) {
        System.out.printf("Creating number with: %s\n", infiniteString);
        InfiniteInt number = new InfiniteInt(infiniteString);
        System.out.printf("Creating second number with: %s\n", infiniteStringTwo);
        InfiniteInt number2 = new InfiniteInt(infiniteStringTwo);

        print("Testing compareTo method");
        System.out.printf("The return of the comparison is: %d", number.compareTo(number2));
        print("Finished comparing two numbers.");
    }

    public static void print(String printString) {
        System.out.println(printString);
    }

    public static void testAdd() {
        // 1. LOAD TEST CASES.
        String[] addCases = { "1,001,000", "999" };
        for (int i = 1; i < addCases.length; i++) {
            InfiniteInt numOne = new InfiniteInt(addCases[i]);
            InfiniteInt numTwo = new InfiniteInt(addCases[i - 1]);
            // System.out.printf("Testing add... adding %s and %s, should equal: %d",
            // addCases[i], addCases[i-1],
            // Integer.sum(Integer.parseInt(addCases[i]), Integer.parseInt(addCases[i-1])));

            InfiniteInt result = InfiniteInt.add(numOne, numTwo);
            System.out.printf("The result is: %s", result.toString());

            print("Moving on to next test.");
        }
    }
}