package org.knit.lab2sem2;

public class Cook extends Thread {
    public final int TIME_OF_COOKING = 1000;
    private final Restaurant restaurant;

    public Cook(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 5) {
            try {
                i++;
                Thread.sleep(TIME_OF_COOKING);
                restaurant.cookDish();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}