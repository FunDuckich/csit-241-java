package org.knit.lab2;

import java.util.ArrayList;

public class Task5 {
    public void execute() {
        File file1 = new File("file1.txt", 100);
        File file2 = new File("file2.txt", 200);
        File file3 = new File("file3.txt", 300);

        // Создаем папки
        Folder folder1 = new Folder("Folder1");
        Folder folder2 = new Folder("Folder2");

        // Добавляем файлы в папки
        folder1.add(file1);
        folder1.add(file2);

        folder2.add(file3);
        folder2.add(folder1); // Вложенная папка

        // Выводим структуру файловой системы
        folder2.display("");

        // Выводим общий размер папки 2
        System.out.println("Total size of Folder2: " + folder2.getSize() + " bytes");
    }

    static class FileSystemComponent {
        final String name;

        public FileSystemComponent(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    static class File extends FileSystemComponent {
        final int size;

        public File(String name, int size) {
            super(name);
            this.size = size;
        }

        public int getSize() {
            return size;
        }
    }

    static class Folder extends FileSystemComponent {
        private ArrayList<FileSystemComponent> inclds = new ArrayList<FileSystemComponent>();

        public Folder(String name) {
            super(name);
        }

        public void add(FileSystemComponent smth) {
            inclds.add(smth);
        }

        public void remove(FileSystemComponent smth) {
            inclds.remove(smth);
        }

        public int getSize() {
            int summarySize = 0;
            for (FileSystemComponent smth : inclds) {
                if (smth instanceof Folder) {
                    summarySize += ((Folder) smth).getSize();
                } else {
                    summarySize += ((File) smth).getSize();
                }
            }
            return summarySize;
        }

        public void display(String indent) {
            System.out.println(indent + name);
            String baseIndent = "  " + indent;
            for (FileSystemComponent smth : inclds) {
                if (smth instanceof Folder) {
                    ((Folder) smth).display(baseIndent);
                } else {
                    System.out.println(baseIndent + smth.getName() + "(" + ((File) smth).getSize() + " bytes)");
                }
            }
        }
    }
}
