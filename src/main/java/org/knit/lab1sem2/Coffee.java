package org.knit.lab1sem2;

public abstract class Coffee {
    String description = "Простой кофе";
    double cost = 0;
    int calories = 0;

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }

    public int getCalories() {
        return calories;
    }
}
