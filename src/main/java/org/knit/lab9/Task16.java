package org.knit.lab9;

public class Task16 {
    public void execute() {
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                System.out.println(rank.getLabel() + " " + suit.getLabel());
            }
        }
    }
}
