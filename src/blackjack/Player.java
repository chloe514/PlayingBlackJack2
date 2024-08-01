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

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void placeBet(double bet) {
        this.currentBet = bet;
        balance -= bet;
    }

    public void winBet() {
        balance += 2 * currentBet;
    }

    public void pushBet() {
        balance += currentBet;
    }
}


