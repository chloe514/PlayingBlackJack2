package blackjack;

public interface DeckActions {
    void shuffle();
    Card dealNextCard();
    void printDeck(int numToPrint);
}

