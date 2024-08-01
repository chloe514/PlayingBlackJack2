package blackjack;

import java.util.Scanner;

public class Game {
    private final Deck deck;
    private final Player player;
    private final Dealer dealer;

    public Game(String playerName, double initialBalance) {
        this.deck = new Deck();
        this.player = new Player(playerName, initialBalance);
        this.dealer = new Dealer();
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to Blackjack!");

            // Initial dealing of cards
            player.getHand().addCard(deck.dealNextCard());
            player.getHand().addCard(deck.dealNextCard());
            dealer.getHand().addCard(deck.dealNextCard());
            dealer.getHand().addCard(deck.dealNextCard());

            System.out.println("Dealer's hand: " + dealer.getHand().getCards().get(0) + " [hidden]");
            System.out.println("Your hand: " + player.getHand());

            // Check for Blackjack
            if (player.getHand().getHandValue() == 21) {
                System.out.println("Blackjack! You win.");
                player.winBet(); // Adjust player's balance
                continue; // Start a new round
            }

            // Player's turn
            while (true) {
                System.out.print("Would you like to: 1) Hit or 2) Stand? ");
                String choice = scanner.nextLine();
                if (choice.equals("1")) {
                    player.getHand().addCard(deck.dealNextCard());
                    System.out.println("Your hand: " + player.getHand());

                    if (player.getHand().isBust()) {
                        System.out.println("You bust! Dealer wins.");
                        return; // End the game
                    }
                } else if (choice.equals("2")) {
                    break; // End player's turn
                }
            }

            // Dealer's turn
            System.out.println("Dealer's hand: " + dealer.getHand());
            while (dealer.shouldHit()) {
                dealer.getHand().addCard(deck.dealNextCard());
                System.out.println("Dealer draws: " + dealer.getHand().getCards().get(dealer.getHand().getCards().size() - 1));
            }

            // Determine the winner
            if (dealer.getHand().isBust()) {
                System.out.println("Dealer busts! You win.");
                player.winBet(); // Player wins
            } else {
                int playerValue = player.getHand().getHandValue();
                int dealerValue = dealer.getHand().getHandValue();

                if (playerValue > dealerValue) {
                    System.out.println("You win!");
                    player.winBet();
                } else if (playerValue < dealerValue) {
                    System.out.println("Dealer wins!");
                } else {
                    System.out.println("It's a push!");
                    player.pushBet();
                }
            }

            System.out.println("Player balance: $" + player.getBalance());

            if (player.getBalance() <= 0) {
                System.out.println("You are out of money! Game over.");
                break; // End the game
            }

            System.out.print("Do you want to play again (Y/N)? ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("Y")) {
                break; // End the game
            }

            // Reset hands and shuffle deck
            player.getHand().getCards().clear();
            dealer.getHand().getCards().clear();
            deck.shuffle();
        }

        scanner.close();
    }
}


