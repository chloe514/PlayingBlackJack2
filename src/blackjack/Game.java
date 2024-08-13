package blackjack;

import java.util.Scanner;

public class Game {
    private final Deck deck;        // The deck of cards used in the game
    private final Player player;    // The player participating in the game
    private final Dealer dealer;    // The dealer managing the game

    // Constructor to initialize a new game with the player’s name and starting balance
    public Game(String playerName, double initialBalance) {
        this.deck = new Deck(); // Create a new deck of cards
        this.player = new Player(playerName, initialBalance); // Create a player with the given name and balance
        this.dealer = new Dealer(); // Create a new dealer
    }

    // Method to run the game loop
    public void play() {
        Scanner scanner = new Scanner(System.in); // Scanner for user input
        while (true) {
            System.out.println("Welcome to Blackjack!");

            // Deal two cards to the player and two cards to the dealer
            player.getHand().addCard(deck.dealNextCard());
            player.getHand().addCard(deck.dealNextCard());
            dealer.getHand().addCard(deck.dealNextCard());
            dealer.getHand().addCard(deck.dealNextCard());

            // Show the dealer's first card and the player's hand
            System.out.println("Dealer's hand: " + dealer.getHand().getCards().get(0) + " [hidden]");
            System.out.println("Your hand: " + player.getHand());

            // Check if the player has a Blackjack (21 points)
            if (player.getHand().getHandValue() == 21) {
                System.out.println("Blackjack! You win.");
                player.winBet(); // Increase player's balance
                continue; // Start a new round
            }

            // Player's turn: choose to hit (take another card) or stand (keep current hand)
            while (true) {
                System.out.print("Would you like to: 1) Hit or 2) Stand? ");
                String choice = scanner.nextLine();
                if (choice.equals("1")) {
                    player.getHand().addCard(deck.dealNextCard()); // Add a card to the player's hand
                    System.out.println("Your hand: " + player.getHand());

                    // Check if the player busts (goes over 21 points)
                    if (player.getHand().isBust()) {
                        System.out.println("You bust! Dealer wins.");
                        return; // End the game
                    }
                } else if (choice.equals("2")) {
                    break; // End player's turn
                }
            }

            // Dealer's turn: reveal dealer's hand and draw cards until the dealer stands
            System.out.println("Dealer's hand: " + dealer.getHand());
            while (dealer.shouldHit()) {
                dealer.getHand().addCard(deck.dealNextCard()); // Dealer draws a card
                System.out.println("Dealer draws: " + dealer.getHand().getCards().get(dealer.getHand().getCards().size() - 1));
            }

            // Determine the winner based on the hands
            if (dealer.getHand().isBust()) {
                System.out.println("Dealer busts! You win.");
                player.winBet(); // Player wins
            } else {
                int playerValue = player.getHand().getHandValue();
                int dealerValue = dealer.getHand().getHandValue();

                if (playerValue > dealerValue) {
                    System.out.println("You win!");
                    player.winBet(); // Player wins
                } else if (playerValue < dealerValue) {
                    System.out.println("Dealer wins!"); // Dealer wins
                } else {
                    System.out.println("It's a push!"); // Tie
                    player.pushBet(); // Return player's bet
                }
            }

            // Display the player's balance
            System.out.println("Player balance: $" + player.getBalance());

            // Check if the player is out of money
            if (player.getBalance() <= 0) {
                System.out.println("You are out of money! Game over.");
                break; // End the game
            }

            // Ask the player if they want to play another round
            System.out.print("Do you want to play again (Y/N)? ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("Y")) {
                break; // End the game
            }

            // Prepare for the next round: clear hands and shuffle the deck
            player.getHand().getCards().clear();
            dealer.getHand().getCards().clear();
            deck.shuffle();
        }

        scanner.close(); // Close the scanner when done
    }
}

