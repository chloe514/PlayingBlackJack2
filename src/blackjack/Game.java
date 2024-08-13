package blackjack;

import java.util.Scanner;

public class Game {
    private final Deck deck;        // The deck of cards used in the game
    private final Player player;    // The player participating in the game
    private final Dealer dealer;    // The dealer managing the game

    // Constructor to initialize a new Game with the player's name and starting balance
    public Game(String playerName, double initialBalance) {
        this.deck = new Deck(); // Instantiate a new Deck object
        this.player = new Player(playerName, initialBalance); // Instantiate a new Player object with name and balance
        this.dealer = new Dealer(); // Instantiate a new Dealer object
    }

    // Method to execute the game loop
    public void play() {
        Scanner scanner = new Scanner(System.in); // Create a Scanner for reading user input
        while (true) {
            System.out.println("Welcome to Blackjack!");

            // Deal two cards to the player and two cards to the dealer
            player.getHand().addCard(deck.dealNextCard()); // Deal a card to the player
            player.getHand().addCard(deck.dealNextCard()); // Deal another card to the player
            dealer.getHand().addCard(deck.dealNextCard()); // Deal a card to the dealer
            dealer.getHand().addCard(deck.dealNextCard()); // Deal another card to the dealer

            // Display the dealer's first card (one card hidden) and the player's hand
            System.out.println("Dealer's hand: " + dealer.getHand().getCards().get(0) + " [hidden]");
            System.out.println("Your hand: " + player.getHand());

            // Check if the player has a Blackjack (a total hand value of 21)
            if (player.getHand().getHandValue() == 21) {
                System.out.println("Blackjack! You win.");
                player.winBet(); // Increase player's balance by winning the bet
                continue; // Start a new round
            }

            // Player's turn to hit (take another card) or stand (keep current hand)
            while (true) {
                System.out.print("Would you like to: 1) Hit or 2) Stand? ");
                String choice = scanner.nextLine();
                if (choice.equals("1")) {
                    player.getHand().addCard(deck.dealNextCard()); // Player chooses to hit and draws a card
                    System.out.println("Your hand: " + player.getHand());

                    // Check if the player busts (hand value exceeds 21)
                    if (player.getHand().isBust()) {
                        System.out.println("You bust! Dealer wins.");
                        return; // End the game
                    }
                } else if (choice.equals("2")) {
                    break; // Player chooses to stand, ending their turn
                }
            }

            // Dealer's turn to draw cards until they stand (hand value 17 or more)
            System.out.println("Dealer's hand: " + dealer.getHand());
            while (dealer.shouldHit()) {
                dealer.getHand().addCard(deck.dealNextCard()); // Dealer draws a card
                System.out.println("Dealer draws: " + dealer.getHand().getCards().get(dealer.getHand().getCards().size() - 1));
            }

            // Determine the winner based on hand values
            if (dealer.getHand().isBust()) {
                System.out.println("Dealer busts! You win.");
                player.winBet(); // Player wins
            } else {
                int playerValue = player.getHand().getHandValue(); // Get player's hand value
                int dealerValue = dealer.getHand().getHandValue(); // Get dealer's hand value

                if (playerValue > dealerValue) {
                    System.out.println("You win!");
                    player.winBet(); // Player wins
                } else if (playerValue < dealerValue) {
                    System.out.println("Dealer wins!"); // Dealer wins
                } else {
                    System.out.println("It's a push!"); // A tie
                    player.pushBet(); // Return player's bet
                }
            }

            // Display the player's current balance
            System.out.println("Player balance: $" + player.getBalance());

            // Check if the player is out of money
            if (player.getBalance() <= 0) {
                System.out.println("You are out of money! Game over.");
                break; // End the game
            }

            // Prompt the player to play another round
            System.out.print("Do you want to play again (Y/N)? ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("Y")) {
                break; // End the game if player chooses not to continue
            }

            // Prepare for the next round: clear hands and shuffle the deck
            player.getHand().getCards().clear(); // Clear the player's hand
            dealer.getHand().getCards().clear(); // Clear the dealer's hand
            deck.shuffle(); // Shuffle the deck for a new round
        }

        scanner.close(); // Close the Scanner when done
    }
}


