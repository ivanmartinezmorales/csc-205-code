import java.util.*;

public class DynamicFib {
    public static void main(String[] args) {
        System.out.println("Please tell me the number you'd like to calculate.");
        long startTime = System.nanoTime();
        int calculation = fib(new Scanner(System.in).nextInt());
        long stopTime = System.nanoTime();
        long result = (stopTime - startTime)/1000000000;
        
        System.out.printf("The result is: %d, and it took: %d", calculation, result);
    }

    static int fib(int n) {
        int fib_array[] = new int [n + 2];
        int i;
        
        fib_array[0] = 0;
        fib_array[1] = 1;

        for (i = 2; i <= n; i++) {
            fib_array[i] = fib_array[i - 1] + fib_array[i - 2];
            System.out.println(fib_array[i]);
        }

        return fib_array[n];
    }


}