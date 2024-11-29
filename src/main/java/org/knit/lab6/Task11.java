package org.knit.lab6;

import java.util.Scanner;

public class Task11 {
    private String inp = "";
    private boolean mustStopProgram = false;

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        StudentsList students = new StudentsList();

        while (!mustStopProgram) {
            ShowMenu();
            inp = TakingOption(scanner);

            switch (inp) {
                case "1":
                    System.out.print("Введите имя студента: ");
                    students.AddNewStudent(TakingInputForOption(scanner));
                    break;
                case "2":
                    System.out.print("Введите имя студента: ");
                    students.RemoveStudent(TakingInputForOption(scanner));
                    break;
                case "3":
                    students.ShowAllStudents();
                    break;
                case "4":
                    System.out.print("Введите имя студента: ");
                    students.FindStudent(TakingInputForOption(scanner));
                    break;
                case "5":
                    mustStopProgram = true;
                    break;
            }
        }
    }

    private void ShowMenu() {
        System.out.println("\nМеню:");
        System.out.println("1. Добавить студента");
        System.out.println("2. Удалить студента");
        System.out.println("3. Показать всех студентов");
        System.out.println("4. Найти студента");
        System.out.println("5. Выйти");
    }

    private String TakingOption(Scanner s) {
        System.out.print("Выберите опцию: ");
        while (true) {
            if (s.hasNext()) {
                return s.nextLine();
            }
        }
    }

    private String TakingInputForOption(Scanner s) {
        while (true) {
            if (s.hasNext()) {
                return s.nextLine();
            }
        }
    }
}
