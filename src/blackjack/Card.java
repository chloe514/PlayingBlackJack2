package blackjack;

// Class representing a playing card with a rank and suit
public class Card {
    private final Rank rank; // The rank of the card (e.g., Ace, King, 2, etc.)
    private final Suit suit; // The suit of the card (e.g., Hearts, Spades, etc.)

    // Constructor to initialize the card's rank and suit
    public Card(Rank rank, Suit suit) {
        this.rank = rank; // Set the rank of the card
        this.suit = suit; // Set the suit of the card
    }

    // Getter method to return the card's rank
    public Rank getRank() {
        return rank; // Return the rank of the card
    }

    // Getter method to return the card's suit
    public Suit getSuit() {
        return suit; // Return the suit of the card
    }

    // Method to get the value of the card according to blackjack rules
    public int getValue() {
        return rank.getValue(); // Return the value associated with the card's rank
    }

    // Method to return a string representation of the card (e.g., "Ace of Spades")
    @Override
    public String toString() {
        return rank + " of " + suit; // Format the card as "rank of suit"
    }
}




