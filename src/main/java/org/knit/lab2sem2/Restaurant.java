package org.knit.lab2sem2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private final BlockingQueue<String> dishQueue;

    public Restaurant() {
        int MAX_NUMBER_OF_DISHES = 3;
        this.dishQueue = new LinkedBlockingQueue<>(MAX_NUMBER_OF_DISHES);
    }

    public void cookDish() throws InterruptedException {
        String dish = "Dish";
        dishQueue.put(dish);
        System.out.println("Блюдо готовят. Блюд ещё не отнесено гостям: " + dishQueue.size());
    }

    public void deliverDish() throws InterruptedException {
        dishQueue.take();
        System.out.println("Блюдо подают. Осталось подать: " + dishQueue.size());
    }
}