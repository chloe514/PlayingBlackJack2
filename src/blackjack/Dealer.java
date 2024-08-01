package blackjack;

public class Dealer {
    private Hand hand;

    public Dealer() {
        this.hand = new Hand();
    }

    public Hand getHand() {
        return hand;
    }

    public boolean shouldHit() {
        return hand.getHandValue() < 17; // Example rule: Dealer hits if hand value is less than 17
    }

    @Override
    public String toString() {
        return "Dealer{" +
                "hand=" + hand +
                '}';
    }
}


