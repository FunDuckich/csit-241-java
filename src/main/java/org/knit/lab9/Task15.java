package org.knit.lab9;

public class Task15 {
    public void execute() {
        for (Season season : Season.values()) {
            System.out.println(season + " - " + season.getInfo());
        }
    }
}
