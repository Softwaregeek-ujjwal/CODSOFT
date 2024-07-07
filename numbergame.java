import java.util.Random;
import java.util.Scanner;

public class numbergame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        playGame(scanner);
        scanner.close();
        System.out.println("Thank you for using the program");
    }

    public static void playGame(Scanner scanner) {

        Random random = new Random();
   
        int randomNumber = random.nextInt(100);
        int attempt=0;
        int limit=5;
        
            System.out.print("Enter the guess number: ");
            while (attempt < limit ) {
                           
                attempt++;

                System.out.print("attempt" + attempt + ": ");

                int userguess = scanner.nextInt(); 

                if (userguess == randomNumber) {
                    System.out.println("correct number");
                    break;
                }
                else if(userguess > randomNumber){
                    System.out.println("too high");
                }
                else{
                    System.out.println("too low");
                }
             } 
             System.out.print("play again (yes/no): ");

             String playAgain = scanner.next();

             if (playAgain.equalsIgnoreCase("yes")) {

                playGame(scanner);
           }
    }   
}