package blackjack;
import java.util.Scanner;

public class GameRunner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get player details
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter your starting balance: ");
        double balance = sc.nextDouble();

        // Create and start the game
        Game game = new Game(name, balance);
        game.play();

        // Close the scanner
        sc.close();
    }
}




