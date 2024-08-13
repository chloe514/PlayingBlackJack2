package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards; // List to store the cards in the hand

    // Constructor to initialize the Hand with an empty list of cards
    public Hand() {
        this.cards = new ArrayList<>(); // Instantiate the ArrayList to hold cards
    }

    // Method to add a Card object to the hand
    public void addCard(Card card) {
        cards.add(card); // Add the specified card to the list
    }

    // Getter method to retrieve the list of cards in the hand
    public List<Card> getCards() {
        return cards; // Return the list of cards
    }

    // Method to calculate the total value of the hand
    public int getHandValue() {
        int value = 0; // Initialize total value of the hand
        int aceCount = 0; // Counter for the number of Aces in the hand

        // Iterate through each card in the hand to sum their values
        for (Card card : cards) {
            value += card.getValue(); // Add the card's value to the total
            if (card.getRank() == Rank.ACE) {
                aceCount++; // Increment ace count if the card is an Ace
            }
        }

        // Adjust the total value for Aces if the hand's value exceeds 21
        while (aceCount > 0 && value > 21) {
            value -= 10; // Adjust the value of an Ace from 11 to 1
            aceCount--;  // Decrease the count of Aces
        }

        return value; // Return the adjusted total value of the hand
    }

    // Method to check if the hand's value exceeds 21 (bust)
    public boolean isBust() {
        return getHandValue() > 21; // Return true if the hand value is greater than 21
    }

    // Override the toString method to provide a string representation of the hand
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); // Create a StringBuilder to build the string
        for (Card card : cards) {
            sb.append(card).append(" - "); // Append each card's string representation
        }
        sb.append("Valued at: ").append(getHandValue()); // Append the total hand value
        return sb.toString(); // Return the complete string representation of the hand
    }
}

