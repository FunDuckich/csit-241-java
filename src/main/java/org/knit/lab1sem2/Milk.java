package org.knit.lab1sem2;

public class Milk extends CoffeeDecorator {
    public Milk(Coffee coffee) {
        super(coffee);
        description = "молоко";
        cost = 0.5;
        calories = 70;
    }
}
