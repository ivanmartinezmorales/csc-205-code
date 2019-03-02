/**
 * Array Operations contains a single method called .sum2D()
 */

 public class ArrayOperations {
    public static int sum2D(int[][] theArray) {
        int sum = 0;
        // method consists of two for loops to add up the arrays.
        // FIRST ROWS.
        for (int i=0; i < theArray.length; i++) {
            // THEN COLUMNS.
            for (int j=0; j < theArray[i].length; j++) {
                sum += theArray[i][j];
            }
        }
        return sum;
    }
}