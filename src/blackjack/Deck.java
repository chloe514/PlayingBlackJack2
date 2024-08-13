package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Class representing a deck of cards
public class Deck implements DeckActions {
    private List<Card> cards; // List to hold the cards in the deck

    // Constructor to initialize a deck of 52 cards and shuffle it
    public Deck() {
        cards = new ArrayList<>(); // Create a new ArrayList for the deck
        // Loop through each suit in the Suit enum
        for (Suit suit : Suit.values()) {
            // Loop through each rank in the Rank enum
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suit)); // Add a new Card object to the deck
            }
        }
        shuffle(); // Shuffle the deck after initialization
    }

    // Method to shuffle the deck
    @Override
    public void shuffle() {
        Collections.shuffle(cards); // Shuffle the list of cards using Collections.shuffle
    }

    // Method to deal the next card from the deck
    @Override
    public Card dealNextCard() {
        if (cards.isEmpty()) { // Check if the deck is empty
            System.out.println("Deck is empty. Shuffling a new deck.");
            new Deck(); // Instantiate a new Deck to refill the cards
        }
        return cards.remove(cards.size() - 1); // Remove and return the card at the top of the deck
    }

    // Method to print a specified number of cards from the deck
    @Override
    public void printDeck(int numToPrint) {
        // Print up to the specified number of cards or the size of the deck
        for (int i = 0; i < Math.min(numToPrint, cards.size()); i++) {
            System.out.println(cards.get(i)); // Print each card in the specified range
        }
    }
}




