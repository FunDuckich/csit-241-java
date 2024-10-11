package org.knit.lab2;

public class Task4 {
    public void execute() {
        Container container = new Container(1000);  // Создаем контейнер с объемом 1000

        Shape sphere = new Sphere(5);   // Создаем сферу с радиусом 5
        Shape cube = new Cube(3);       // Создаем куб со стороной 3

        container.add(sphere);  // Проверяем, можно ли добавить сферу
        container.add(cube);    // Проверяем, можно ли добавить куб
    }

    static class Container {
        final double maxSpace;
        private double freeSpace;

        public Container(double maxSpace) {
            this.maxSpace = maxSpace;
            freeSpace = maxSpace;
        }

        public void add(Shape figure) {
            if (freeSpace - figure.volume >= 0) {
                freeSpace -= figure.volume;
                System.out.println("Фигура помещена в контейнер!");
            }
            else {
                System.out.println("Не хватает места в контейнере.");
            }
        }
    }

    static class Shape {
        protected double volume = 0.0;

        public double getVolume() {
            return volume;
        }
    }

    static class Sphere extends Shape {
        public Sphere(double radius) {
            volume = (4 * Math.PI * Math.pow(radius, 3)) / 3;
        }
    }

    static class Cube extends Shape {
        public Cube(double side) {
            volume = Math.pow(side, 3);
        }
    }

    static class Cylinder extends Shape {
        public Cylinder(double radius, double height) {
            volume = Math.PI * Math.pow(radius, 2) * height;
        }
    }
}
