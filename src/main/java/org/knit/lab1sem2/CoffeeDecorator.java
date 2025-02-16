package org.knit.lab1sem2;

public abstract class CoffeeDecorator extends Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", " + description;
    }

    @Override
    public double getCost() {
        return coffee.getCost() + cost;
    }

    @Override
    public int getCalories() {
        return coffee.getCalories() + calories;
    }
}
