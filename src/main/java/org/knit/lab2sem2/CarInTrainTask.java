package org.knit.lab2sem2;

public class CarInTrainTask extends Thread {
    private final Railroad railroad;

    public CarInTrainTask(Railroad railroad) {
        this.railroad = railroad;
    }

    @Override
    public void run() {
        while (true) {
            try {
                railroad.carCrossRailroad();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}