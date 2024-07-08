import java.util.Random;
import java.util.Scanner;

public class numbergame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int roundsWon = 0;
        int totalAttempts = 0;
        boolean playAgain = true;

        while (playAgain) {
            boolean won = playGame(scanner);
            if (won) {
                roundsWon++;
            }
            totalAttempts++;
            System.out.print("Play again (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }

        scanner.close();
        System.out.println("Thank you for using the program");
        System.out.println("Rounds won: " + roundsWon);
        System.out.println("Total attempts: " + totalAttempts);
    }

    public static boolean playGame(Scanner scanner) {
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        int attempt = 0;
        int limit = 5;

        System.out.println("Enter the guess number: ");
        while (attempt < limit) {
            attempt++;
            System.out.print("Attempt " + attempt + ": ");
            int userGuess = scanner.nextInt();

            if (userGuess == randomNumber) {
                System.out.println("Correct number!");
                return true; 
            } else if (userGuess > randomNumber) {
                System.out.println("Too high");
            } else {
                System.out.println("Too low");
            }
        }
        System.out.println("Sorry, you've used all attempts. The correct number was " + randomNumber);
        return false; 
    }
}
