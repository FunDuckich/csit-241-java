package org.knit.lab11;

import java.sql.SQLException;
import java.util.Scanner;

public class Task24 {
    private static boolean programIsAlive = true;

    public static void execute() throws SQLException {
        UserDAOImpl dao = new UserDAOImpl();
        UserService service = new UserService(dao);
        Scanner scanner = new Scanner(System.in);
        ShowHelp();

        while (programIsAlive) {
            System.out.println();
            System.out.print("Введите команду: ");
            String command = getCommandInp(scanner);
            String[] inputData;
            try {
                switch (parseCommand(command)) {
                    case "help":
                        ShowHelp();
                        break;
                    case "add":
                        inputData = command.split(" ");
                        service.registerUser(inputData[1], inputData[2]);
                        System.out.println("Пользователь зарегистрирован успешно!");
                        break;
                    case "list":
                        for (User user : service.listAllUsers()) {
                            System.out.println(user);
                        }
                        break;
                    case "delete":
                        inputData = command.split(" ");
                        service.deleteUser(Integer.parseInt(inputData[1]));
                        System.out.println("Пользователь удалён успешно!");
                        break;
                    case "update":
                        inputData = command.split(" ");
                        service.updateUser(Integer.parseInt(inputData[1]), inputData[2], inputData[3]);
                        System.out.println("Данные пользователя обновлены успешно!");
                        break;
                    case "exit":
                        programIsAlive = false;
                        break;
                    case "unknown":
                        System.out.println("Неизвестная команда!");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }

    private static void ShowHelp() {
        System.out.println("help — выводит это сообщение"
                + "\nadd [name] [email] — добавляет нового пользователя, если email уникален"
                + "\nlist — выводит список всех пользователей"
                + "\ndelete [id] — удаляет пользователя по ID"
                + "\nupdate [id] [new_name] [new_email] — обновляет имя и email пользователя"
                + "\nexit — завершает выполнение программы");
    }

    private static String parseCommand(String input) {
        if (input.equals("help")) return "help";
        if (input.matches("^add \\S+ \\S+$")) return "add";
        if (input.equals("list")) return "list";
        if (input.matches("^delete \\d+$")) return "delete";
        if (input.matches("^update \\d+ \\S+ \\S+$")) return "update";
        if (input.equals("exit")) return "exit";
        return "unknown";
    }

    private static String getCommandInp(Scanner scnr) {
        while (true) {
            if (scnr.hasNextLine()) return scnr.nextLine();
        }
    }
}
