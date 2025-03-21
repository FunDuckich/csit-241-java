package org.knit.lab2sem2;

class TrafficLightController extends Thread {
    private final TrafficLight trafficLight;
    public final int LIGHT_SWITCH_INTERVAL = 5000; // 5 секунд

    public TrafficLightController(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    @Override
    public void run() {
        while (true) {
            try {
                trafficLight.changeColor();
                Thread.sleep(LIGHT_SWITCH_INTERVAL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}