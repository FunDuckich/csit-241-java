package org.knit.lab10;

public class Task18 {
    public static void execute() {
        Pair<String, Integer> pair1 = new Pair<>("A", 1);
        System.out.println(pair1);
        System.out.println();
        Pair<String, Integer> pair2 = new Pair<>("B", 2);
        System.out.println(pair2);
        System.out.println();
        Pair<String, Integer> pair3 = new Pair<>(pair1);
        System.out.println(pair3.equals(pair1));
    }
}
