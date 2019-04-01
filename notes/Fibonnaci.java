import java.util.*;
import java.util.PrimitiveIterator.OfInt;

public class Fibonnaci {
    public static void main(String[] args) {

        System.out.println("Please enter the number that you would like to calculate with the fibbonacci sequence.");
        Scanner kb = new Scanner(System.in);        
        int number = kb.nextInt();
        int response = fibonnaci(number);

        System.out.printf("Calculating fibonnaci sequence for n=%d\n", number);        
        System.out.printf("Answer for fibonnaci sequence at n=%d is %d\n", number, response);
        
    }

    private static int fibonnaci(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Numbers cannot be less than zero.");
        }
        
        if (n == 1 || n == 2) {
            return 1;
        }
        // System.out.println(n);
        return fibonnaci(n-1) + fibonnaci(n-2);
    }
}