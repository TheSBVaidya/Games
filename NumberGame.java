//1. Generate a random number within a specified range, such as 1 to 100.
//2. Prompt the user to enter their guess for the generated number.
//3. Compare the user's guess with the generated number and provide feedback on whether the guess is correct,
// too high, or too low.
//4. Repeat steps 2 and 3 until the user guesses the correct number.
//
//You can incorporate additional details as follows:
//
//5. Limit the number of attempts the user has to guess the number.
//6. Add the option for multiple rounds, allowing the user to play again.
//7. Display the user's score, which can be based on the number of attempts taken or rounds won.

import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        boolean playAgain = true;
        int score = 0;
        int round = 1;
        int maxAttempts = 10;
        int attempt = 0;

        while(playAgain) {
            int randomNum = rand.nextInt(100)+1;
            boolean found = false;

            while(attempt < maxAttempts && !found) {

                attempt++;
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("\t\t\t\t\tRound - " + round);
                System.out.println("\t\t\t\t\tAttempt - " + attempt);
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("Guess the Number: ");
                int guess = sc.nextInt();

                if(guess == randomNum) {
                    System.out.println("\t\t\tCongratulations! You Guessed Correct Number! In " + attempt + " attempts.");
                    found = true;
                    score++;
                    attempt = 0;
                } else if(guess > randomNum) {
                    System.out.println("Too High!, Try Again!");
                } else {
                    System.out.println("Too Low!, Try Again!");
                }
            }

            if(!found) {
                System.out.println("\t\t\tYou Lost!, You used all your attempts");
                System.out.println("\t\t\tThe Number you want guessed is: " + randomNum);
                attempt = 0;
            }
//
            System.out.println("Do you want to play again? (Y/N)");
            String choice = sc.next();


            if(choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
                round++;
            } else {
                playAgain = false;
            }

        }

        System.out.println("\t\t\t\t\tYour score is: " + score);
        sc.close();

    }
}
