
//This shows all 3 sorting methods - bubbleSort, quickSort, and mergeSort.

import java.util.*;

public class Sort {
    // if turned on, EXPLAIN will trigger explanations as the code runs
    private final static boolean EXPLAIN = false;

    public static void main(String[] args) {
        // reminder message about EXPLAIN facility
        System.out.println("(to get more/less information change EXPLAIN flag and recompile...)\n");

        // create an array and fill it with random numbers between 1-100

        // int randArray[] = {5, 8, 2, 7, 2, 3, 2, 8, 4, 5, 3, 8, 7, 4};
        Random numberGenerator = new Random(65377); // a new random number generator
        int randArray[] = new int[200000]; // arraysize starts at 25, so using 25 random numbers
        for (int i = 0; i < randArray.length; i++)
            randArray[i] = 1 + numberGenerator.nextInt(10000); // generate random numbers between 1-100 (1 plus 0-99)

        // print it unsorted
        // System.out.println("Unsorted array:");
        // printArray(randArray);

        // ****** now sort it using one of the sort routines ******
        long startTime = System.nanoTime();
        quickSort(randArray);
        long endTime = System.nanoTime();
        System.out.printf("The test completed in: %f", ((endTime - startTime) / 1000000000.0));
        // print it sorted
        // System.out.print("\n\nSorted array: ");
        // printArray(randArray);

        System.out.println("\n\nDONE!");
    }

    // *****************************************************************
    // bubbleSort - uses the bubblesort algorithm to sort the array that
    // is passed in.
    public static void bubbleSort(int[] theArray) {
        // explanation...
        // if (EXPLAIN) {
        // System.out.println("\n\nusing bubblesort...");
        // }

        // find the largest remaining value and place into theArray[i]
        for (int i = theArray.length - 1; i > 0; i--) {
            // move large values to the top
            for (int j = 0; j < i; j++) {
                if (EXPLAIN) {
                    // System.out.print("\ncomparing \t\t\t");
                    printArray(theArray, j, j + 1);
                }

                if (theArray[j] > theArray[j + 1]) // if out of order
                {
                    int temp = theArray[j]; // then swap
                    theArray[j] = theArray[j + 1];
                    theArray[j + 1] = temp;
                }

            }

            // if (EXPLAIN) {
            // System.out.print("\n\t\t\t\t");
            // printArray(theArray);
            // }
        }
    }

    // ***************************************************************
    // mergeSort - uses the mergesort algorithm to sort the array that
    // is passed in.
    public static void mergeSort(int[] theArray) {
        // explanation...
        if (EXPLAIN) {
            System.out.println("\n\nusing mergesort...");
        }

        // call the recursive version and tell it to sort the whole thing
        mergeSort(theArray, 0, theArray.length - 1);
    }

    // mergeSort - recursive version which looks at the first and last
    // indexes, calls itself recursively to sort 2 halves,
    // and then calls merge to merge them together.
    private static void mergeSort(int[] theArray, int low, int high) {
        if (low < high) {
            int pivot = (low + high) / 2; // midpoint is the pivot

            // if (EXPLAIN) {
            // System.out.print("\nsorting 1st half \t\t");
            // printArray(theArray, low, pivot);
            // // for (int i=0; i<theArray.length; i++)
            // // System.out.print(theArray[i] + " ");
            // }

            mergeSort(theArray, low, pivot); // sort first half

            // if (EXPLAIN) {
            // System.out.print("\nsorting 2nd half \t\t");
            // printArray(theArray, pivot + 1, high);
            // // for (int i=0; i<theArray.length; i++)
            // // System.out.print(theArray[i] + " ");
            // }
            mergeSort(theArray, pivot + 1, high); // sort second half

            merge(theArray, low, high); // merge together

            // if (EXPLAIN) {
            // System.out.print("\nmerged \t\t");
            // printArray(theArray, low, high);
            // // for (int i=0; i<theArray.length; i++)
            // // System.out.print(theArray[i] + " ");
            // }

        }
    }

    // merge - keeps taking the smallest elements from the halves into
    // a temporary array. When finished, copies the temporary
    // array back to theArray.
    private static void merge(int[] theArray, int first, int last) {
        // create a temporary array
        int[] temp = new int[last - first + 1];

        // figure out the midpoint and the starting places for
        // temp and the 2 halves of the array to be merged
        int mid = (first + last) / 2;
        int i1 = 0;
        int i2 = first;
        int i3 = mid + 1;

        // compare next values of the 2 halves - merge the smallest into
        // temp as long as they both halves have elements to merge
        while (i2 <= mid && i3 <= last) {
            if (theArray[i2] < theArray[i3])
                temp[i1++] = theArray[i2++];
            else
                temp[i1++] = theArray[i3++];
        }

        // if the first half has finished merging, then fill in the 2nd half
        if (i2 > mid)
            while (i3 <= last)
                temp[i1++] = theArray[i3++];
        // otherwise the 2nd half has finished so fill in the first half
        else
            while (i2 <= mid)
                temp[i1++] = theArray[i2++];

        // copy the contents of temp back into the correct place in theArray
        int j = 0;
        for (int i = first; i <= last; i++)
            theArray[i] = temp[j++];
    }

    // ***************************************************************
    // quickSort - calls its recursive version to sort the whole array
    public static void quickSort(int theArray[]) {
        // explanation...
        // if (EXPLAIN) {
        // System.out.println("\n\nusing quicksort...");
        // }
        quickSort(theArray, 0, theArray.length - 1);
    }

    // qSort - recursive version that sorts an array between indices
    // minIndex and maxIndex.
    private static void quickSort(int[] data, int minIndex, int maxIndex) {
        int indexOfPartition;

        if (maxIndex > minIndex) {
            // Create partitions
            indexOfPartition = findPartition(data, minIndex, maxIndex);
            if (EXPLAIN) {
                System.out.println("\npivot element is: " + data[indexOfPartition]);
            }

            // sort the left side
            if (EXPLAIN) {
                System.out.println("\nsorting:");
                printArray(data, minIndex, indexOfPartition - 1);
            }
            quickSort(data, minIndex, indexOfPartition - 1);

            // sort the right side
            if (EXPLAIN) {
                System.out.print("\nsorting: \t\t\t");
                printArray(data, indexOfPartition + 1, maxIndex);
            }
            quickSort(data, indexOfPartition + 1, maxIndex);
        }
    }

    // findPartition: rearranges the elements in the sort area into two partitions
    private static int findPartition(int[] data, int minIndex, int maxIndex) {
        int left, right;
        int temp, pivotElement;

        // use the first element as the pivot element
        pivotElement = data[minIndex];
        left = minIndex;
        right = maxIndex;

        if (EXPLAIN)
            System.out.println("\npivot element is: " + pivotElement);

        while (left < right) {
            // move left up until an element > the pivot element is found
            // (it will belong on the other side). Don't go past right.
            while (data[left] <= pivotElement && left < right) {
                left++;
            }

            // move right down until an element < the pivot element is found
            // (it will belong on the other side).
            while (data[right] > pivotElement) {
                right--;
            }

            // left has stopped at an element that is > pivotElement and right has
            // stopped at an element that is < pivotElement. They each belong on
            // the other side, so swap them.
            if (left < right) {
                temp = data[left];
                data[left] = data[right];
                data[right] = temp;

                if (EXPLAIN) {
                    System.out.println("\nswap: " + data[left] + " with " + data[right]);
                    print2Elements(data, left, right);
                    printArray(data, minIndex, maxIndex);
                }
            }
        }

        // move pivotElement to partition index
        temp = data[minIndex];
        data[minIndex] = data[right];
        data[right] = temp;

        if (EXPLAIN) {
            System.out.println("\nswapping the pivot: " + data[minIndex] + " with " + data[right] + "\t");
            print2Elements(data, minIndex, right);
            printArray(data, minIndex, maxIndex);
        }

        return right;
    }

    // printArray - prints the whole array (with every entry the same width, even if
    // single vs. double digit)
    private static void printArray(int[] theArray) {
        printArray(theArray, 0, theArray.length - 1); // call other method
    }

    // printArray - prints part of the array (with every entry the same width, even
    // if single vs. double digit)
    private static void printArray(int[] theArray, int start, int end) {
        System.out.print("\t\t\t");
        for (int i = 0; i < theArray.length; i++) {
            if (i < start || i > end) // don't print this entry
                System.out.print("   "); // 3 spaces
            else {
                if (theArray[i] < 10)
                    System.out.print(" " + theArray[i]); // 1 digit number - print space, then number
                else
                    System.out.print(theArray[i]); // 2 digit number - print the whole thing
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    // print2Elements - prints 2 elements of the array (with every entry the same
    // width, even if single vs. double digit)
    private static void print2Elements(int[] theArray, int elt1, int elt2) {
        System.out.print("\t\t\t");
        for (int i = 0; i < theArray.length; i++) {
            if (i != elt1 && i != elt2) // skip these, so just print...
                System.out.print("   "); // ...3 spaces
            else {
                if (theArray[i] < 10)
                    System.out.print(" " + theArray[i]); // 1 digit number - print space, then number
                else
                    System.out.print(theArray[i]); // 2 digit number - print the whole thing
                System.out.print(" ");
            }
        }
        System.out.println();
    }

}
