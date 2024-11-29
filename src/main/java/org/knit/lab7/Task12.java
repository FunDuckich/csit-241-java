package org.knit.lab7;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Task12 {
    private static long countOfWords = 0;

    public void execute() {
        Path startFrom = Paths.get("src/main/java/org/knit/lab7/lol");
        try {
            Files.walkFileTree(startFrom, new CountWordsVisitor());
        } catch (IOException e) {
            System.out.println("Ошибка при обходе дерева файлов: " + e.getMessage());
        }

        System.out.println("Слов в файлах: " + countOfWords);
    }

    private static long countWords(Path filePath) throws IOException {
        long countOfWordsInFile = 0;

        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                countOfWordsInFile += words.length;
            }
        }

        return countOfWordsInFile;
    }

    private static class CountWordsVisitor implements FileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (!file.toString().endsWith(".txt")) {
                return FileVisitResult.CONTINUE;
            }
            countOfWords += countWords(file);
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            return FileVisitResult.CONTINUE;
        }
    }
}
