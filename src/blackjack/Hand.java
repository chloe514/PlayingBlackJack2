package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private final List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getHandValue() {
        int value = 0;
        int numAces = 0;

        for (Card card : cards) {
            value += card.getValue();
            if (card.getRank() == Rank.ACE) {
                numAces++;
            }
        }

        while (numAces > 0 && value > 21) {
            value -= 10; // Convert Ace from 11 to 1
            numAces--;
        }

        return value;
    }

    public boolean isBust() {
        return getHandValue() > 21;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : cards) {
            sb.append(card).append(" (").append(card.getValue()).append(") - ");
        }
        sb.append("Your Value: ").append(getHandValue());
        return sb.toString();
    }
}



