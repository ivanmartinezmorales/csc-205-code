import java.util.ArrayList;

public class Tester {

    public static void main(String[] args) {
        ArrayList<Integer> testAL = new ArrayList<Integer>();

        for (int i=0; i<10; i++) {
            testAL.add(i+1);
        }
        
        System.out.println(testAL.toString());
        // Testing making a deep copy of testAL

        ArrayList<Integer> secondAL = new ArrayList<Integer>();
        
        for (int n : testAL) {
            secondAL.add(n);
            System.out.println("Copied over: " + n);
        }

        System.out.println(secondAL.toString());

        if (testAL.toString().equals(secondAL.toString())) {
            
            System.out.println("They're equal, bro.");
        } 

    }
}