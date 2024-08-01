package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck implements DeckActions {
    private List<Card> myCards;
    private int numCards;

    public Deck() {
        myCards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                myCards.add(new Card(suit, rank));
            }
        }
        numCards = myCards.size();
        shuffle();
    }

    @Override
    public void shuffle() {
        Collections.shuffle(myCards);
    }

    @Override
    public Card dealNextCard() {
        if (myCards.isEmpty()) {
            throw new IllegalStateException("No cards left in the deck.");
        }
        numCards--;
        return myCards.remove(myCards.size() - 1);
    }

    @Override
    public void printDeck(int numToPrint) {
        for (int i = 0; i < numToPrint && i < myCards.size(); i++) {
            System.out.println(myCards.get(i));
        }
    }
}

