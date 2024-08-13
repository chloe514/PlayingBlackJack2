package blackjack;

public class Player {
    private String name;         // The name of the player
    private double balance;      // The current balance of the player
    private Hand hand;           // The Hand object representing the player's cards
    private double currentBet;   // The current bet amount placed by the player

    // Constructor to initialize a new Player with a given name and initial balance
    public Player(String name, double initialBalance) {
        this.name = name;                 // Initialize the player's name
        this.balance = initialBalance;    // Set the player's initial balance
        this.hand = new Hand();           // Instantiate a new Hand object for the player
    }

    // Getter for the player's hand of cards
    public Hand getHand() {
        return hand;
    }

    // Getter for the player's current balance
    public double getBalance() {
        return balance;
    }

    // Method to place a bet, checking if it is less than or equal to the current balance
    public void placeBet(double bet) {
        if (bet <= balance) {              // Check if the bet amount is within the available balance
            this.currentBet = bet;         // Assign the bet amount to currentBet
            this.balance -= bet;           // Deduct the bet amount from the player's balance
        } else {
            System.out.println("Insufficient balance to place the bet."); // Print an error message if the balance is insufficient
        }
    }

    // Method to handle winning the bet, updating balance and resetting the current bet
    public void winBet() {
        this.balance += currentBet * 2;    // Increase balance by twice the amount of the current bet
        this.currentBet = 0;               // Reset the current bet to zero
    }

    // Method to handle losing the bet, simply resetting the current bet
    public void loseBet() {
        this.currentBet = 0;               // Reset the current bet to zero
    }

    // Method to handle a push (tie), returning the bet amount to the balance
    public void pushBet() {
        this.balance += currentBet;        // Add the current bet amount back to the balance
        this.currentBet = 0;               // Reset the current bet to zero
    }

    // Getter for the player's name
    public String getName() {
        return name;
    }
}

