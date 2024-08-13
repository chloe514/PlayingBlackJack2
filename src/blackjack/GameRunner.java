package blackjack;

import java.util.Scanner;

public class GameRunner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Create a Scanner instance for reading user input

        // Prompt the user to enter their name
        System.out.print("Enter your name: ");
        String name = sc.nextLine(); // Read the player's name from input

        // Prompt the user to enter their starting balance
        System.out.print("Enter your starting balance: ");
        double balance = sc.nextDouble(); // Read the player's starting balance from input

        // Instantiate a new Game object with the provided name and balance
        Game game = new Game(name, balance);
        game.play(); // Call the play method to start the game

        // Close the Scanner to release the resources
        sc.close(); // Clean up resources used by the Scanner
    }
}






