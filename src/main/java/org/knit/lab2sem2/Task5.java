package org.knit.lab2sem2;

public class Task5 {
    public static void execute() {
        Restaurant restaurant = new Restaurant();
        Cook cook = new Cook(restaurant);
        Waiter waiter = new Waiter(restaurant);
        cook.start();
        waiter.start();
    }
}
