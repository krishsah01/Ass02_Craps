import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rnd = new Random();

        boolean playAgain = true;

        while (playAgain) {
            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int sum = die1 + die2;

            System.out.println("You rolled: " + die1 + " + " + die2 + " = " + sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You lose.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win.");
            } else {
                System.out.println("The point is: " + sum);
                boolean continueRolling = true;
                while (continueRolling) {
                    int die3 = rnd.nextInt(6) + 1;
                    int die4 = rnd.nextInt(6) + 1;
                    int newSum = die3 + die4;
                    System.out.println("You rolled: " + die3 + " + " + die4 + " = " + newSum);
                    if (newSum == sum) {
                        System.out.println("You made the point! You win.");
                        continueRolling = false;
                    } else if (newSum == 7) {
                        System.out.println("You rolled a seven! You lose.");
                        continueRolling = false;
                    } else {
                        System.out.println("Trying for point...");
                    }
                }
            }

            System.out.println("Do you want to play again? (yes/no)");
            String playAgainResponse = scanner.next().toLowerCase();
            playAgain = playAgainResponse.equals("yes");
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}