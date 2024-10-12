package org.knit.lab4;

import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Task7 {
    private long dictionarySize;
    private Set<Character> alphabet = new HashSet<>();
    private ArrayList<String> words = new ArrayList<>();

    public void execute() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/main/java/org/knit/lab4/dictionary.txt"));
        while (scanner.hasNext()) {
            String word = scanner.nextLine();
            words.add(word);
            dictionarySize += 1;

            for (char ch : word.toCharArray()) {
                alphabet.add(ch);
            }
        }
        scanner.close();

        DictionaryStatistic dictStats = new DictionaryStatistic(words, dictionarySize, alphabet);
        System.out.println(dictStats.getRandomWord());
        dictStats.printSymbolsStat();
    }
}
