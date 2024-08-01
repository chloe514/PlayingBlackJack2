package blackjack;

public class Dealer extends Player {
    public Dealer() {
        super("Dealer", 0); // Dealer has no balance
    }

    public boolean shouldHit() {
        return getHand().getHandValue() < 17;
    }
}



