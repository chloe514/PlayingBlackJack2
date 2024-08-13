package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Class representing a deck of cards
public class Deck implements DeckActions {
    private List<Card> cards;

    // Constructor to create a new deck of 52 cards and shuffle it
    public Deck() {
        cards = new ArrayList<>();
        // Loop through each suit
        for (Suit suit : Suit.values()) {
            // Loop through each rank
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suit)); // Add a new card to the deck
            }
        }
        shuffle(); // Shuffle the deck
    }

    // Method to shuffle the deck
    @Override
    public void shuffle() {
        Collections.shuffle(cards); // Shuffle the list of cards
    }

    // Method to deal the next card from the deck
    @Override
    public Card dealNextCard() {
        if (cards.isEmpty()) { // Check if the deck is empty
            System.out.println("Deck is empty. Shuffling a new deck.");
            new Deck(); // Create a new shuffled deck
        }
        return cards.remove(cards.size() - 1); // Remove and return the top card
    }

    // Method to print a specified number of cards from the deck
    @Override
    public void printDeck(int numToPrint) {
        for (int i = 0; i < Math.min(numToPrint, cards.size()); i++) {
            System.out.println(cards.get(i)); // Print each card
        }
    }
}



