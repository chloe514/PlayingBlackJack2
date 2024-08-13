package blackjack;

// Class representing the dealer in the blackjack game, which is a type of player
public class Dealer extends Player {
    // Constructor to initialize the dealer with the name "Dealer" and no balance
    public Dealer() {
        super("Dealer", 0); // Dealer has no balance
    }

    // Method to determine if the dealer should hit (take another card)
    // Dealer will hit if the hand value is less than 17
    public boolean shouldHit() {
        return getHand().getHandValue() < 17;
    }
}





