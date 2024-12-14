package org.knit.lab10;

public class Task19 {
    public static <T extends Comparable<T>> T findMax(T[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Массив пуст или null :(");
        }

        T maxValue = array[0];
        for (T element : array) {
            if (element.compareTo(maxValue) > 0) {
                maxValue = element;
            }
        }

        return maxValue;
    }

    public static void execute() {
        Integer[] numbers = {1, 2, 3, 4, 5};
        System.out.println(findMax(numbers)); // 5

        String[] words = {"apple", "banana", "cherry"};
        System.out.println(findMax(words)); // cherry
    }
}
