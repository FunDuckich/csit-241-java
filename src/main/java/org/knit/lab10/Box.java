package org.knit.lab10;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Number> {
    private final ArrayList<T> numbers;

    public Box() {
        numbers = new ArrayList<>();
    }

    public Box(T[] numbers) {
        this.numbers = new ArrayList<>(List.of(numbers));
    }

    public void add(T number) {
        numbers.add(number);
    }

    public double sum() {
        double answer = 0;
        for (T number : numbers) {
            answer += number.doubleValue();
        }
        return answer;
    }
}
