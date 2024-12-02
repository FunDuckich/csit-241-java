package org.knit.lab9;

public enum Rank {
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    JACK("валет"),
    QUEEN("дама"),
    KING("король"),
    ACE("туз");

    private final String label;

    Rank(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
