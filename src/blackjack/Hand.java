package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getHandValue() {
        int value = 0;
        int numberOfAces = 0;

        for (Card card : cards) {
            value += card.getRank().getValue();
            if (card.getRank() == Rank.ACE) {
                numberOfAces++;
            }
        }

        // Adjust value for Aces if necessary
        while (value > 21 && numberOfAces > 0) {
            value -= 10;
            numberOfAces--;
        }

        return value;
    }

    public boolean isBust() {
        return getHandValue() > 21;
    }

    @Override
    public String toString() {
        return "Hand{" +
                "cards=" + cards +
                '}';
    }
}


