package org.knit.lab4;

import java.util.*;

public class DictionaryStatistic {
    private final List<String> words;
    private final long dictionarySize; // Количество слов
    private int numberOfPalindroms; // Количество слов полиндромов
    private int minWordLength = Integer.MAX_VALUE; // минимальная длина слова в словаре
    private int maxWordLength = Integer.MIN_VALUE; // маскимальная длина слова в словаре
    private final NavigableMap<Character, Integer> alphabet; // буквы алфавита


    public DictionaryStatistic(ArrayList<String> words, long dictionarySize, NavigableMap<Character, Integer> alphabet) {
        this.words = Collections.unmodifiableList(words);
        this.dictionarySize = dictionarySize;
        this.alphabet = alphabet;
        calculateMinMaxLengths();
        calculateCountOfPalindroms();
    }


    // получить случайное слово из словаря
    public String getRandomWord() {
        return words.get((int) (Math.random() * dictionarySize));
    }

    public void printSymbolsStat() {
        for (Map.Entry<Character, Integer> entry : alphabet.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public int getMinWordLength() {
        return minWordLength;
    }

    public int getMaxWordLength() {
        return maxWordLength;
    }

    public int getNumberOfPalindroms() {
        return numberOfPalindroms;
    }

    public void giveMeAllWords(String gameWord) {
        Set<Character> charsInGame = new HashSet<>();
        for (char ch : gameWord.toCharArray()) {
            charsInGame.add(ch);
        }

        Set<Character> charsInCurrentWord = new HashSet<>();
        for (String word : words) {
            charsInCurrentWord.clear();
            for (char ch : word.toCharArray()) {
                charsInCurrentWord.add(ch);
            }

            if (charsInGame.containsAll(charsInCurrentWord)) {
                System.out.println(word);
            }
        }
    }

    private void calculateMinMaxLengths() {
        for (String word : words) {
            minWordLength = Math.min(word.length(), minWordLength);
            maxWordLength = Math.max(word.length(), maxWordLength);
        }
    }

    private void calculateCountOfPalindroms() {
        for (String word : words) {
            boolean currentIsPal = true;
            int i = 0;
            int j = word.length() - 1;
            char[] w = word.toCharArray();
            while (i < j) {
                if (w[i] != w[j]) {
                    currentIsPal = false;
                    break;
                }
                i++;
                j--;
            }
            if (currentIsPal) {
                numberOfPalindroms++;
            }
        }
    }

}