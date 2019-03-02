
/**
 * 	Program Title: MinilabReview.java
 *	Program Author: Ivan Martinez Morales
 *	Program Due Date: 24 January 2019
 *
 *	Program Description:
 *	Minilab Review is a program that will create an array of random integers.
 *	The random integers can be manipulated by the user by user defined inputs.
 */

import java.util.Scanner;
import java.util.Random;

public class MinilabReview {

    private static final int OCCURENCE = 3;
    private static final int LARGEST_INT = 8;
    private static int[] userArray;

    public static void main(String[] args) {
        // Declarations
        Scanner sc = new Scanner(System.in);
        createEnvironment(sc);
        runEnvironment(sc);

    }
    // --------------------------- User Environment ------------------------------
    // //

    /**
     * Creates the first portion of the program leading up to the menu items. asks
     * user to give a non-zero integer in order to proceed.
     *
     * @param kb - Scanner declared in main
     */
    private static void createEnvironment(Scanner kb) {

        System.out.println("Please enter a seed: \n");
        int userSeed = kb.nextInt();

        // Creating array size
        System.out.println("Please enter the size of the array: \n");
        int arraySize = kb.nextInt();

        if (arraySize <= 1) {
            do {
                System.out.println("Array size must be greater than 1.  Please reenter: \n");
                arraySize = kb.nextInt();
            } while (arraySize <= 1);
        }

        fillUserArray(arraySize, userSeed);
    }

    /**
     * This funciton is the contains the user Menu and the operations associated
     * with that option.
     * 
     * @param kb uses scanner to accept inputs.
     */
    private static void runEnvironment(Scanner kb) {
        int userInput;

        do {
            System.out.println(userMenu());
            userInput = kb.nextInt();
            switch (userInput) {

            // Case 1: print the array
            case 1:
                printArray();
                break;

            // Case 2: find the average
            case 2:
                getAverage();
                break;

            // Case 3: Get Largest value in the array
            case 3:
                getLargestInt();
                break;

            // Case 4: Find how many times OCCURENCE occured
            case 4:
                findOccurrences();
                break;

            // Case 5: Count how many elements are less than half of the first element
            case 5:
                lessThanHalf();
                break;

            // Case 6: Find how many times numbers repeat consecutively
            case 6:
                repeatOffenders();
                break;

            // Case 7: Swap the first and last elements
            case 7:
                swapElements();
                break;

            // Case 8: Exit the program
            case 8:
                break;

            // default option in case the user inputs an invalid option:
            default:
                System.out.println("\nIllegal option\n");
            }
        } while (userInput != 8);
    }

    // --------------------------- Background logic
    // --------------------------------- //

    /**
     * fills the userArray with random numbers
     * 
     * @param size       - users defined size of the array
     * @param userRandom - user's random seed that they have chosen
     */
    private static void fillUserArray(int size, int userRandom) {

        userArray = new int[size];
        Random numberFactory = new Random(userRandom);

        for (int i = 0; i < size; i++) {
            userArray[i] = numberFactory.nextInt(LARGEST_INT + 1);
        }
    }

    /**
     * prints the array to the user.
     */
    private static void printArray() {

        System.out.print("\nArray: ");
        for (int i = 0; i < userArray.length; i++) {
            System.out.print(userArray[i] + "  ");
        }
        System.out.println("\n");
    }

    /**
     * Returns the average value of the array
     */
    private static void getAverage() {

        int total = 0;
        for (int i = 0; i < userArray.length; i++) {
            total += userArray[i];
        }

        System.out.println("\nAverage: " + ((float) total / userArray.length) + "\n");
    }

    /**
     * Returns the largest value in the array. Finds the element in a
     * psuedo-bubble-sort fashion.
     */
    private static void getLargestInt() {

        int max = userArray[0];
        for (int i = 1; i < userArray.length; i++) {
            if (userArray[i] > max)
                max = userArray[i];
        }

        System.out.println("\nLargest: " + max + "\n");
    }

    /**
     * Returns the number of times that the OCCURRENCE appears in the array.
     */
    private static void findOccurrences() {

        int count = 0;
        for (int i = 0; i < userArray.length; i++) {
            if (userArray[i] == OCCURENCE)
                count++;
        }
        System.out.println("\n" + OCCURENCE + "Count: " + count + "\n");
    }

    /**
     * Prints the number of elements that are less than half of the first element.
     */
    private static void lessThanHalf() {
        float comparator = userArray[0] / 2;
        int count = 0;

        for (int i = 0; i < userArray.length; i++) {
            if ((float) userArray[i] < comparator) {
                count++;
            }
        }
        System.out.println("\nLess than half of first: " + count + "\n");
    }

    /**
     * Prints the count of elements that repeat consecutively throughout the array.
     */
    private static void repeatOffenders() {
        int lastElement = userArray[0];
        int count = 0;

        for (int i = 1; i < userArray.length; i++) {

            if (userArray[i] == lastElement) {
                count++;
            }
            lastElement = userArray[i];
        }
        System.out.println("\nRepeats: " + count + "\n");
    }

    /**
     * Swaps the first and last elements.
     */
    private static void swapElements() {
        int buffer = userArray[0];
        // assigning the last element to the first position
        userArray[0] = userArray[userArray.length - 1];
        userArray[userArray.length - 1] = buffer;
        System.out.println();

    }

    // --------------------------- User Interfaces
    // ---------------------------------- //

    /**
     * Returns the on-screen menu to the user.
     * 
     * @return: the String of the complete menu with all 8 choices.
     */
    private static String userMenu() {
        String userMenu = "Please choose an option:\n" + "\t1\tPrint the array\n" + "\t2\tFind the average\n"
                + "\t3\tFind the largest element\n" + "\t4\tCount how many times " + OCCURENCE + " occurred\n"
                + "\t5\tCount how many elements are less than half of the first element\n"
                + "\t6\tFind how many times numbers repeat consecutively\n" + "\t7\tSwap the first and last elements\n"
                + "\t8\tExit";

        return userMenu;
    }
}

// TODO: Figure out TESTCASE 5: Test case 5 involves doing the less than half
// Comparison