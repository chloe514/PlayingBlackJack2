package blackjack;

// Class representing the dealer in the blackjack game, which is a type of player
public class Dealer extends Player {
    // Constructor to initialize the dealer with the name "Dealer" and a balance of 0
    public Dealer() {
        super("Dealer", 0); // Call the superclass constructor with "Dealer" as name and 0 balance
    }

    // Method to determine if the dealer should hit (take another card)
    // The dealer hits if their hand value is less than 17
    public boolean shouldHit() {
        return getHand().getHandValue() < 17; // Return true if hand value is less than 17, otherwise false
    }
}






