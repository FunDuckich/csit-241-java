package org.knit.lab2sem2;

public class GasStation {
    private int availableNumberOfFuelDispensers = 2;

    public synchronized void occupy() {
        while (availableNumberOfFuelDispensers <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        availableNumberOfFuelDispensers--;
        System.out.println("Колонка занята. Осталось свободных: " + availableNumberOfFuelDispensers);
        notifyAll();
    }

    public synchronized void release() {
        int NUM_OF_FUEL_DISPENSERS = 2;
        while (availableNumberOfFuelDispensers >= NUM_OF_FUEL_DISPENSERS) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        availableNumberOfFuelDispensers++;
        System.out.println("Колонка освободилась. Свободно: " + availableNumberOfFuelDispensers);
        notifyAll();
    }
}
