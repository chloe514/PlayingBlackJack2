package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck implements DeckActions {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
        shuffle();
    }

    @Override
    public void shuffle() {
        Collections.shuffle(cards);
    }

    @Override
    public Card dealNextCard() {
        if (cards.isEmpty()) {
            System.out.println("Deck is empty. Shuffling a new deck.");
            new Deck(); // Creates a new shuffled deck
        }
        return cards.remove(cards.size() - 1);
    }

    @Override
    public void printDeck(int numToPrint) {
        for (int i = 0; i < Math.min(numToPrint, cards.size()); i++) {
            System.out.println(cards.get(i));
        }
    }
}


