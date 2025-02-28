package org.knit.lab2sem2;

public class Task4 {
    public static void execute() {
        GasStation gasStation = new GasStation();

        for (int i = 1; i <= 10; i++) {
            Car car = new Car(gasStation);
            car.start();
        }
    }
}
