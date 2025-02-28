package org.knit.lab1sem2;

public class Task2 {
    public static void execute() {
        Coffee espresso = new Espresso();
        System.out.println(espresso.getDescription() + " | Цена: $" + espresso.getCost() + " | Калорийность: " + espresso.getCalories() + " ккал");

        Coffee americano = new Americano();
        americano = new Milk(americano);
        americano = new Caramel(americano);
        System.out.println(americano.getDescription() + " | Цена: $" + americano.getCost() + " | Калорийность: " + americano.getCalories() + " ккал");

        Coffee latte = new Latte();
        latte = new SizeDecorator(latte, "large");
        latte = new Chocolate(latte);
        System.out.println(latte.getDescription() + " | Цена: $" + latte.getCost() + " | Калорийность: " + latte.getCalories() + " ккал");

        Coffee cappuccino = new Cappuccino();
        cappuccino = new SizeDecorator(cappuccino, "medium");
        cappuccino = new Milk(cappuccino);
        cappuccino = new Caramel(cappuccino);
        cappuccino = new Caramel(cappuccino);
        System.out.println(cappuccino.getDescription() + " | Цена: $" + cappuccino.getCost() + " | Калорийность: " + cappuccino.getCalories() + " ккал");
    }
}

