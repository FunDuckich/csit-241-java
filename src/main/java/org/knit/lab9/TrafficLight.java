package org.knit.lab9;

public enum TrafficLight {
    RED("Стоп!"),
    YELLOW("Внимание!"),
    GREEN("Старт!");

    private final String shortExplanation;

    TrafficLight(String shortExplanation) {
        this.shortExplanation = shortExplanation;
    }

    public String getShortExplanation() {
        return shortExplanation;
    }

    public TrafficLight getNextLight() {
        switch (this) {
            case RED:
                return YELLOW;
            case YELLOW:
                return GREEN;
            case GREEN:
                return RED;
        }
        return null;
    }
}
