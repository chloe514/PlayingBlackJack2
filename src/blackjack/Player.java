package blackjack;

public class Player {
    private String name;
    private double balance;
    private double currentBet;
    private Hand hand;

    public Player(String name, double initialBalance) {
        this.name = name;
        this.balance = initialBalance;
        this.hand = new Hand();
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void placeBet(double bet) {
        if (bet > balance) {
            System.out.println("Insufficient balance to place the bet.");
            return;
        }
        this.currentBet = bet;
        balance -= bet;
    }

    public void winBet() {
        balance += currentBet * 2; // Win pays 2:1
    }

    public void pushBet() {
        balance += currentBet; // Return the bet amount on a push
    }

    public Hand getHand() {
        return hand;
    }

    // Other methods like bust check and hand management
}




