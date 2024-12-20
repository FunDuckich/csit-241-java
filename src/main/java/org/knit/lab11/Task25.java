package org.knit.lab11;

import java.sql.SQLException;
import java.util.Scanner;

public class Task25 {
    private static boolean programIsAlive = true;

    public static void execute() throws SQLException {
        FileDAOImpl fileDAO = new FileDAOImpl();
        FileService service = new FileService(fileDAO);
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
                    case "list":
                        service.ShowFiles();
                        break;
                    case "saveLocal":
                        inputData = command.split(" ");
                        service.saveFileLocally(Integer.parseInt(inputData[1]),
                                "src\\main\\java\\org\\knit\\lab11\\saved_local_files");
                        System.out.println("Файл сохранён на комп успешно!");
                        break;
                    case "saveToDB":
                        inputData = command.split(" ");
                        service.saveFilesFromDirectory("src\\main\\java\\org\\knit\\lab11\\files_for_DB");
                        System.out.println("Файл успешно сохранен в базу данных!");
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
                + "\nlist — выводит список файлов с их названиями и ID из базы данных"
                + "\nsaveLocal [id] — сохраняет файл из БД по [id] в локальную папку текущего проекта"
                + "\nsaveToDB — сохраняет файлы, которые меньше 10Мб в БД"
                + "\nexit — завершает выполнение программы");
    }

    private static String parseCommand(String input) {
        if (input.equals("help")) return "help";
        if (input.equals("list")) return "list";
        if (input.matches("^saveLocal \\d+$")) return "saveLocal";
        if (input.equals("saveToDB")) return "saveToDB";
        if (input.equals("exit")) return "exit";
        return "unknown";
    }

    private static String getCommandInp(Scanner scnr) {
        while (true) {
            if (scnr.hasNextLine()) return scnr.nextLine();
        }
    }
}
