package org.knit.lab2sem2;

public class Car extends Thread {
    public final int TIME_OF_FILING = 1500;
    private final GasStation gasStation;

    public Car(GasStation gasStation) {
        this.gasStation = gasStation;
    }

    @Override
    public void run() {
        try {
            gasStation.occupy();
            Thread.sleep(TIME_OF_FILING);
            gasStation.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
