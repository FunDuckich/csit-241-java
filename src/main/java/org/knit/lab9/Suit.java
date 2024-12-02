package org.knit.lab9;

public enum Suit {
    SPADES("пики"),
    HEARTS("черви"),
    DIAMONDS("бубны"),
    CLUBS("трефы");

    private final String label;

    Suit(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
