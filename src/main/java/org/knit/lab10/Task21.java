package org.knit.lab10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Task21 {
    public static <T> List<T> filter(List<T> values, Predicate<T> checkingValue) {
        List<T> result = new ArrayList<>();
        for (T value : values) {
            if (checkingValue.test(value)) {
                result.add(value);
            }
            else {
                System.out.println(value + " не удовлетворяет условию");
            }
        }
        return result;
    }

    public static void execute() {
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        List<String> filtered = filter(words, s -> s.startsWith("b"));
        System.out.println(filtered); // [banana]
    }
}
