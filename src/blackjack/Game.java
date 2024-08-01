package blackjack;

import java.util.Scanner;

public class Game {
    private Deck deck;
    private Player player;
    private Dealer dealer;

    public Game(String playerName, double initialBalance) {
        this.deck = new Deck();
        this.player = new Player(playerName, initialBalance);
        this.dealer = new Dealer();
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to Blackjack!");
            System.out.print("Enter your bet: ");
            double bet = scanner.nextDouble();
            player.placeBet(bet);

            dealInitialCards();
            playerTurn();
            if (!player.getHand().isBust()) {
                dealerTurn();
            }
            determineWinner();

            System.out.println("Player balance: $" + player.getBalance());
            if (player.getBalance() <= 0) {
                System.out.println("You are out of money! Game over.");
                break;
            }

            System.out.print("Do you want to play again (Y/N)? ");
            scanner.nextLine(); // consume newline
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("Y")) {
                break;
            }

            resetHands();
        }
    }

    private void dealInitialCards() {
        player.getHand().addCard(deck.dealNextCard());
        player.getHand().addCard(deck.dealNextCard());
        dealer.getHand().addCard(deck.dealNextCard());
        dealer.getHand().addCard(deck.dealNextCard());

        System.out.println(player);
        System.out.println("Dealer shows: " + dealer.getHand().toString().split(",")[0] + " ...");
    }

    private void playerTurn() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(player);
            if (player.getHand().isBust()) {
                System.out.println(player.getName() + " busts!");
                break;
            }
            System.out.print("Do you want to hit (H) or stand (S)? ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("H")) {
                player.getHand().addCard(deck.dealNextCard());
            } else if (choice.equalsIgnoreCase("S")) {
                break;
            }
        }
    }

    private void dealerTurn() {
        while (dealer.shouldHit()) {
            dealer.getHand().addCard(deck.dealNextCard());
        }
        System.out.println(dealer);
        if (dealer.getHand().isBust()) {
            System.out.println("Dealer busts!");
        }
    }

    private void determineWinner() {
        if (player.getHand().isBust()) {
            System.out.println("Dealer wins!");
        } else if (dealer.getHand().isBust() || player.getHand().getHandValue() > dealer.getHand().getHandValue()) {
            System.out.println(player.getName() + " wins!");
            player.winBet();
        } else if (player.getHand().getHandValue() < dealer.getHand().getHandValue()) {
            System.out.println("Dealer wins!");
        } else {
            System.out.println("It's a push!");
            player.pushBet();
        }
    }

    private void resetHands() {
        player.getHand().getCards().clear();
        dealer.getHand().getCards().clear();
        deck = new Deck();
    }
}
