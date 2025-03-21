package org.knit.lab2sem2;

public class Task6 {
    public static void execute() throws InterruptedException {
        Railroad railroad = new Railroad();
        Train train = new Train(railroad);
        CarInTrainTask car = new CarInTrainTask(railroad);

        train.start();
        car.start();
    }
}