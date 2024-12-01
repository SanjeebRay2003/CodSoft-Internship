import java.util.Random;
import java.util.Scanner;

public class NumberGame
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        Random RandomNumber = new Random();
        int Chance = 0;
        int maxChance = 5;
        int MinNumber = 1;
        int MaxNumber = 100;
        int Score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true)
        {
            int SecretNumber = RandomNumber.nextInt(MaxNumber - MinNumber + 1) + MinNumber;
            int Chances = 0;

            System.out.println("I guess a secret number between 1 - 100, can you guess it.");

            System.out.println("Round " + (Chance + 1) + ":");
            System.out.println("Try to choose a number between 1 - 100 Try to guess it!");

            while (Chances < maxChance)
            {
                System.out.print("Enter your guess: ");
                int YourNumber = input.nextInt();
                Chances++;

                if (YourNumber == SecretNumber)
                {
                    System.out.println("Congratulations! You guessed the correct number in " + Chances + " Chances.");
                    Score++;
                    break;
                }
                else if (YourNumber < SecretNumber)
                {
                    System.out.println("Your guess is too LOW. Try HIGH number !.");
                }
                else
                {
                    System.out.println("Your guess is too HIGH. Try LOW number !.");
                }

                if (Chances == maxChance)
                {
                    System.out.println("\nSorry, your chances are over.\nThe secret number is: " + SecretNumber);
                }
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = input.next();

            if (!playAgain.equalsIgnoreCase("yes"))
            {
                System.out.println("Thanks for playing! Your total Score is: " + Score + " out of " + (Chance + 1) + " Chance won.");
                break;
            }

            Chance++;
        }

        input.close();
    }
}


