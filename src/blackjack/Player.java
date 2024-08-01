package blackjack;

public class Player {
    private String name;
    private double balance;
    private Hand hand;
    private double currentBet;

    public Player(String name, double initialBalance) {
        this.name = name;
        this.balance = initialBalance;
        this.hand = new Hand();
    }

    public Hand getHand() {
        return hand;
    }

    public double getBalance() {
        return balance;
    }

    public void placeBet(double bet) {
        if (bet <= balance) {
            this.currentBet = bet;
            this.balance -= bet;
        } else {
            System.out.println("Insufficient balance to place the bet.");
        }
    }

    public void winBet() {
        this.balance += currentBet * 2;
        this.currentBet = 0;
    }

    public void loseBet() {
        this.currentBet = 0;
    }

    public void pushBet() {
        this.balance += currentBet;
        this.currentBet = 0;
    }

    public String getName() {
        return name;
    }
}

