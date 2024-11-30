package org.knit.lab8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Task13 {
    private ArrayList<User> users = new ArrayList<>();
    private boolean programIsAlive = true;
    private int choosedOption;
    private final int NUMBER_OF_OPTIONS = 6;

    public void execute() throws IOException, ClassNotFoundException {
        users = UserManager.loadUsers();
        System.out.println("Добро пожаловать в систему управления пользователями!");
        Scanner scanner = new Scanner(System.in);
        while (programIsAlive) {
            showMenu();
            System.out.println();
            choosingMenuOption(scanner);
            switch (choosedOption) {
                case 1:
                    addNewUser(scanner);
                    System.out.println("Пользователь добавлен.");
                    break;
                case 2:
                    deleteUser(scanner);
                    break;
                case 3:
                    showAllUsers();
                    break;
                case 4:
                    UserManager.saveUsers(users);
                    break;
                case 5:
                    users = UserManager.loadUsers();
                    break;
                case 6:
                    programIsAlive = false;
                    break;
            }
        }
    }

    private void showMenu() {
        System.out.println();
        System.out.println("Выберите действие:");
        System.out.println("1. Добавить нового пользователя");
        System.out.println("2. Удалить пользователя");
        System.out.println("3. Показать всех пользователей");
        System.out.println("4. Сохранить список пользователей в файл");
        System.out.println("5. Загрузить список пользователей из файла");
        System.out.println("6. Выйти");
    }

    private void choosingMenuOption(Scanner userInput) {
        while (true) {
            try {
                choosedOption = Integer.parseInt(gettingInputForMenuOption(userInput));
                if (choosedOption < 1 || choosedOption > NUMBER_OF_OPTIONS) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException ignored) {
            }
        }
    }

    private String gettingInputForMenuOption(Scanner userInput) {
        System.out.print("Введите номер действия: ");

        while (true) {
            if (userInput.hasNext()) {
                return userInput.nextLine();
            }
        }
    }

    private void addNewUser(Scanner userInput) {
        String name = gettingName(userInput);
        int age;
        String email;
        while (true) {
            try {
                age = Integer.parseInt(gettingAge(userInput));
                if (age < 1 || age > 100) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException ignored) {
            }
        }
        while (true) {
            email = gettingEmail(userInput);
            if (email.matches("^(.+)@(\\S+)$")) {
                break;
            }
        }
        users.add(new User(name, age, email));
    }

    private String gettingName(Scanner userInput) {
        System.out.print("Введите имя пользователя: ");
        while (true) {
            if (userInput.hasNext()) {
                return userInput.nextLine();
            }
        }
    }

    private String gettingAge(Scanner userInput) {
        System.out.print("Введите возраст: ");
        while (true) {
            if (userInput.hasNext()) {
                return userInput.nextLine();
            }
        }
    }

    private String gettingEmail(Scanner userInput) {
        System.out.print("Введите email: ");
        while (true) {
            if (userInput.hasNext()) {
                return userInput.nextLine();
            }
        }
    }

    private void showAllUsers() {
        System.out.println("Список пользователей:");
        for (int i = 0; i < users.size(); i++) {
            System.out.println(i + 1 + ". " + users.get(i));
        }
    }

    private void deleteUser(Scanner userInput) {
        if (users.isEmpty()) {
            System.out.println("Некого удалять!");
        } else {
            int userId;
            while (true) {
                System.out.print("Введите ID пользователя: ");
                if (userInput.hasNext()) {
                    String gotInput = userInput.nextLine();
                    try {
                        userId = Integer.parseInt(gotInput);
                        if (userId < 1 || userId > users.size()) {
                            throw new NumberFormatException();
                        }
                        users.remove(userId - 1);
                        System.out.println("Пользователь удалён.");
                        break;
                    } catch (NumberFormatException ignored) {
                    }
                }
            }
        }
    }
}
