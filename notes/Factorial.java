public class Factorial {
    public static void main(String[] args) {
        int num = 5;
        System.out.println(num + "! is " + factorial(num));
    }

    public static int factorial(int n) {
        int answer;
        System.out.println("Calculating " + n + "!");
        if (n == 0) {
            answer = 1;
        } else {
            answer = n * factorial(n-1);
        }

        System.out.println("returning: " + answer);
        return answer;
    }
}