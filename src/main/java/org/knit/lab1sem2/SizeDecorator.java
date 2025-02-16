package org.knit.lab1sem2;

public class SizeDecorator extends CoffeeDecorator {
    private final String size; // Размер кофе

    public SizeDecorator(Coffee coffee, String size) {
        super(coffee);
        this.size = size;
        this.description = size.toUpperCase() + " ";
        if (this.size.equalsIgnoreCase("medium")) {
            this.cost = 0.5;
            this.calories = 20;
        } else if (this.size.equalsIgnoreCase("large")) {
            this.cost = 1.0;
            this.calories = 40;
        } else {
            this.cost = 0.0;
            this.calories = 0;
        }
    }

    @Override
    public String getDescription() {
        return description + coffee.getDescription();
    }
}
