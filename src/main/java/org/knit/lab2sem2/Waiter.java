package org.knit.lab2sem2;

public class Waiter extends Thread {
    public final int TIME_OF_DELIVERING = 2500;
    private final Restaurant restaurant;

    public Waiter(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 5) {
            try {
                i++;
                restaurant.deliverDish();
                Thread.sleep(TIME_OF_DELIVERING);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}