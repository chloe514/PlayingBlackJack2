package blackjack;

// Class representing a playing card with a rank and suit
public class Card {
    private final Rank rank; // The rank of the card (e.g., Ace, King, 2, etc.)
    private final Suit suit; // The suit of the card (e.g., Hearts, Spades, etc.)

    // Constructor to initialize the card's rank and suit
    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    // Getter method to return the card's rank
    public Rank getRank() {
        return rank;
    }

    // Getter method to return the card's suit
    public Suit getSuit() {
        return suit;
    }

    // Method to get the value of the card (specific to blackjack rules)
    public int getValue() {
        return rank.getValue();
    }

    // Method to return a string representation of the card (e.g., "Ace of Spades")
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}



