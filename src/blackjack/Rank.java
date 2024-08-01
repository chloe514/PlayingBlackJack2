package blackjack;

public enum Rank {
    TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
    JACK(10), QUEEN(10), KING(10), ACE(11);

    private final int value;

    // Constructor for the enum
    Rank(int value) {
        this.value = value;
    }

    // Method to get the value of the rank
    public int getValue() {
        return value;
    }
}

