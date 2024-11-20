package org.knit.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Task10 {
    private String typed = "";
    private String currentWord = "0";
    private Character[] currentState = new Character[0];
    private boolean continueGame = true;
    private long dictionarySize;
    private final ArrayList<String> words = new ArrayList<>();
    private final HashSet<Integer> idxsOfCorrectChars = new HashSet<>();
    private final HashSet<Character> alreadyCorrected = new HashSet<>();

    public void execute() throws FileNotFoundException {
        prepareDict();
        Scanner scanner = new Scanner(System.in);
        while (continueGame) {
            int canTryFor = 6;
            currentWord = getRandomWord();
            currentState = new Character[currentWord.length()];
            inPlacePlaceholder();
            while (canTryFor > 0 && stillUnfound() > 0) {
                showCurrentState();
                System.out.println();
                System.out.print("Введите букву: ");
                if (scanner.hasNextLine()) {
                    typed = scanner.nextLine();

                    if (typed.length() != 1 || alreadyCorrected.contains(typed.charAt(0))) {
                        continue;
                    }
                    findCrosses();
                    if (idxsOfCorrectChars.isEmpty()) {
                        canTryFor--;
                        System.out.println("Неверно! Осталось попыток: " + canTryFor);
                    } else {
                        alreadyCorrected.add(typed.charAt(0));
                        inPlaceCorrectChar();
                    }
                }
            }
            if (stillUnfound() == 0) {
                System.out.println("Поздравляю, ты отгадал слово '" + currentWord + "'!");
            } else {
                System.out.println("К сожалению, у тебя не получилось отгадать слово '" + currentWord + "'");
            }
            continueGameOrCancel(scanner);
        }
        scanner.close();
    }


    private void inPlaceCorrectChar() {
        for (int idx : idxsOfCorrectChars) {
            currentState[idx] = typed.charAt(0);
        }
    }

    private void prepareDict() throws FileNotFoundException {
        Scanner fscanner = new Scanner(new File("src/main/java/org/knit/lab4/dictionary.txt"));
        while (fscanner.hasNext()) {
            String word = fscanner.nextLine();
            words.add(word);
            dictionarySize += 1;
        }
        fscanner.close();
    }

    private String getRandomWord() {
        return words.get((int) (Math.random() * dictionarySize));
    }

    private void inPlacePlaceholder() {
        for (int i = 0; i < currentWord.length(); i++) {
            currentState[i] = '_';
        }
    }

    private void showCurrentState() {
        System.out.print("Загаданное слово: ");
        for (char c : currentState) {
            System.out.print(c + " ");
        }
    }

    private void findCrosses() {
        idxsOfCorrectChars.clear();
        for (int i = 0; i < currentWord.length(); i++) {
            if (typed.charAt(0) == currentWord.charAt(i)) {
                idxsOfCorrectChars.add(i);
            }
        }
    }

    private int stillUnfound() {
        int ans = 0;
        for (char c : currentState) {
            if (c == '_') {
                ans++;
            }
        }
        return ans;
    }

    private void continueGameOrCancel(Scanner scan) {
        while (true) {
            System.out.print("Желаешь продолжить игру? Ответ(y/n): ");
            if (scan.hasNextLine()) {
                String ans = scan.nextLine().trim();
                if (ans.equalsIgnoreCase("n")) {
                    continueGame = false;
                    break;
                } else if (ans.equalsIgnoreCase("y")) {
                    continueGame = true;
                    break;
                } else {
                    System.out.println("Пожалуйста, введи 'y' для продолжения или 'n' для завершения.");
                }
            }
        }
    }

}
