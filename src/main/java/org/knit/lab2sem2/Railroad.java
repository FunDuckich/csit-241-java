package org.knit.lab2sem2;

public class Railroad {
    private boolean trainApproaching = false; // Состояние: приближается ли поезд

    public synchronized void trainApproaches() throws InterruptedException {
        trainApproaching = true;
        System.out.println("Поезд приближается! Переезд закрыт для машин.");
        Thread.sleep(5000);
        trainLeaves();
    }

    public synchronized void trainLeaves() {
        trainApproaching = false;
        System.out.println("Поезд проехал. Переезд открыт для машин.");
        notifyAll();
    }

    public synchronized void carCrossRailroad() throws InterruptedException {
        while (trainApproaching) {
            wait();
        }
        System.out.println("Автомобиль проехал.");
    }
}