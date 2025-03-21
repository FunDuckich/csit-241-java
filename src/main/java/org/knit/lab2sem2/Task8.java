package org.knit.lab2sem2;

public class Task8 {
    public static void execute() throws InterruptedException {
        TrafficLight trafficLight = new TrafficLight();
        TrafficLightController trafficLightController = new TrafficLightController(trafficLight);
        CarInTrafficLightTask car1 = new CarInTrafficLightTask(trafficLight);
        CarInTrafficLightTask car2 = new CarInTrafficLightTask(trafficLight);
        CarInTrafficLightTask car3 = new CarInTrafficLightTask(trafficLight);

        trafficLightController.start();
        car1.start();
        car2.start();
        car3.start();
    }
}