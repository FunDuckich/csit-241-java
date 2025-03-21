package org.knit.lab2sem2;

public class CarInTrafficLightTask extends Thread {
    private final TrafficLight trafficLight;

    public CarInTrafficLightTask(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    @Override
    public void run() {
        while (true) {
            try {
                trafficLight.carApproaches();
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}