package blackjack;

public interface DeckActions {
    // Shuffle the deck to randomize the order of cards
    void shuffle();

    // Deal the next card from the deck
    Card dealNextCard();

    // Print the specified number of cards from the top of the deck
    void printDeck(int numToPrint);
}


