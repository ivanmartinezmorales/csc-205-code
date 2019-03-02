
/**
 * Program Name: MinilabDiceGame.java 
 * Program Author: Ivan Martinez Morales
 * Program Due Date: 30 January 2019 
 * Program Description: A dice game to be
 *      played between two players. The first die will have 6 sides, and the second
 *      Die will have anywhere between 4 and n sides. The die has a method roll(),
 *      which returns an int as the result.
 * 
 *      SCORING - If the total is less than 5 then Player recieves 3 dollars. If the
 *      total is exactly 5, then you will get 8 dollars. If the total is greater than
 *      5, then you must give 2 dollars.
 */
import java.text.NumberFormat;
import java.util.Scanner;

public class DiceGame {

    public static void main(String[] args) {
        NumberFormat money = NumberFormat.getCurrencyInstance();
        Scanner kb = new Scanner(System.in);
        Die firstDie = new Die();

        // Asking the user for input:
        System.out.println("How many sides should the second die have?\n");
        int secondDieSides = kb.nextInt();
        Die secondDie = new Die(secondDieSides);

        System.out.println("How many times should we roll the dice?\n");
        int rollCount = kb.nextInt();

        System.out.println("How often should we print the results?\n");
        int printCount = kb.nextInt();

        System.out.println("What is your name?\n");
        kb.nextLine(); // Flushing the extra enter from the input stream
        String userName = kb.nextLine();
        System.out.println(userName);
        if (userName.length() > 5) {
            // If the userName is longer than 5 characters, truncate it
            userName = userName.substring(0, 5);

        }

        System.out.println("\nExperiment by: " + userName + "\n");

        // Loop that will calculate the total earnings and the average earnings
        int earnings = 0;
        float averageEarnings = 0;

        for (int i = 1; i <= rollCount; i++) {
            int roundResult = firstDie.roll() + secondDie.roll();
            // System.out.println("result of round: " + roundResult);
            if (roundResult < 5) {
                earnings += 3.0;

            } else if (roundResult == 5) {
                earnings += 8.0;

            } else if (roundResult > 5) {
                earnings -= 2.0;
            }

            if (i % printCount == 0) {
                averageEarnings = (float) earnings / i;

                // Print out results:
                System.out.println("Rolls: " + i + "\tAverage winning per roll: " + money.format(averageEarnings));

            }
        }
        System.out.println(
                "Rolls: " + rollCount + "\tAverage winning per roll: " + money.format((float) earnings / rollCount));
    }
}