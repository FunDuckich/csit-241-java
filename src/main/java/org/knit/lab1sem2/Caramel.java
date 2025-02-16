package org.knit.lab1sem2;

public class Caramel extends CoffeeDecorator {
    public Caramel(Coffee coffee) {
        super(coffee);
        description = "карамель";
        cost = 0.75;
        calories = 60;
    }
}
