package org.knit.lab1sem2;

public class Chocolate extends CoffeeDecorator {
    public Chocolate(Coffee coffee) {
        super(coffee);
        description = "шоколад";
        cost = 1.0;
        calories = 80;
    }
}
