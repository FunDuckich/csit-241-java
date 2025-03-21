package org.knit.lab2sem2;

public class Part {
    private final int id;

    public Part(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Заготовка " + id;
    }
}