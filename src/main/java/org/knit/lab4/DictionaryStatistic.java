package org.knit.lab4;

import java.util.*;

public class DictionaryStatistic {
    private final ArrayList<String> words;
    private final long dictionarySize; // Количество слов
    private int polindrom; // Количество слов полиндромов
    private int maxWordLength; // маскимальная длина слова в словаре
    private int minWordLength; // минимальная длина слова в словаре
    private  final Set<Character> alphabet; // буквы алфавита
    private int[] frequency; //частота букв в словаре (в кадой ячейке хранит частоту букв, а индекс - это позиция буквы в alphabet)


    public DictionaryStatistic(ArrayList<String> words, long dictionarySize, Set<Character> alphabet) {
        this.words = words;
        this.dictionarySize = dictionarySize;
        this.alphabet = alphabet;
        calculateSymbolsStats();
    }


    // получить случайное слово из словаря
    public String getRandomWord() {
        return words.get((int) (Math.random() * dictionarySize));
    }

    public void printSymbolsStat() {

    }

    private void calculateSymbolsStats() {

    }

}