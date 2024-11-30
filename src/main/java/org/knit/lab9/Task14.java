package org.knit.lab9;

public class Task14 {
    public void execute() {
        TrafficLight red = TrafficLight.RED;
        TrafficLight yellow = TrafficLight.YELLOW;
        TrafficLight green = TrafficLight.GREEN;

        TrafficLight[] lights = {red, yellow, green};

        for (TrafficLight light : lights) {
            System.out.println("Если горит " + light + " - " + light.getShortExplanation() +
                    ", дальше - " + light.getNextLight());
        }
    }
}
