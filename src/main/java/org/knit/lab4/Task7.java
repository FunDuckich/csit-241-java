package org.knit.lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Task7 {
    private long dictionarySize;
    final private NavigableMap<Character, Integer> alphabet = new TreeMap<>();
    final private ArrayList<String> words = new ArrayList<>();

    public void execute() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/main/java/org/knit/lab4/dictionary.txt"));
        while (scanner.hasNext()) {
            String word = scanner.nextLine();
            words.add(word);
            dictionarySize += 1;

            for (char ch : word.toCharArray()) {
                alphabet.putIfAbsent(ch, 0);
                alphabet.put(ch, alphabet.get(ch) + 1);
            }
        }
        scanner.close();

        DictionaryStatistic dictStats = new DictionaryStatistic(words, dictionarySize, alphabet);
        dictStats.giveMeAllWords("Библиотека");
    }
}
