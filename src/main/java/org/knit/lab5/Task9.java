package org.knit.lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task9 {
    final private List<String> words;
    final private int dictionarySize;

    public Task9() throws FileNotFoundException {
        words = getWords();
        this.dictionarySize = words.size();
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        long startTime = System.currentTimeMillis();
        long endTime = 0;
        long currentTimer = endTime - startTime;
        int symbolsWasTyped = 0;
        int wordsWasTyped = 0;
        int corrected = 0;
        System.out.print("Нажми Enter, чтобы начать!");
        String typed = scanner.nextLine();
        while (currentTimer < 1000 * 60) {
            String wordForTyping = getRandomWord();
            System.out.print(wordForTyping + ": ");
            typed = scanner.nextLine();
            endTime = System.currentTimeMillis();
            currentTimer = endTime - startTime;
            wordsWasTyped++;
            if (currentTimer < 1000 * 60) {
                symbolsWasTyped += typed.length();
                if (typed.equals(wordForTyping)) {
                    corrected++;
                }
            }
        }
        DecimalFormat df = new DecimalFormat("#.##");

        System.out.println("\n\nРезультаты:\n" + "Всего было слов - " + wordsWasTyped +
                "\nИз них ты успел правильно ввести - " + corrected +
                "\nТы успел напечатать " + symbolsWasTyped + " символов" +
                "\nСкорость твоей печати составила " + df.format((float) symbolsWasTyped / 60) +
                " симв. в секунду!");
    }

    private String getRandomWord() {
        return words.get((int) (Math.random() * dictionarySize));
    }

    private List<String> getWords() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/main/java/org/knit/lab4/dictionary.txt"));
        List<String> words = new ArrayList<>();
        while (scanner.hasNext()) {
            words.add(scanner.nextLine());
        }
        scanner.close();
        return words;
    }
}
