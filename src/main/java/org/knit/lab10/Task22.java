package org.knit.lab10;

public class Task22 {
    public static void execute() {
        Dictionary<String, Integer> dictionary = new Dictionary<>();
        dictionary.put("Alice", 25);
        dictionary.put("Bob", 30);
        System.out.println(dictionary.get("Alice")); // 25
        dictionary.remove("Alice");
        try {
            dictionary.get("Alice");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        System.out.println(dictionary);
    }
}
