package org.knit.lab8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private static final String FILE_NAME = "users.ser";

    public static void saveUsers(List<User> users) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(users);
        }
    }

    public static ArrayList<User> loadUsers() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (ArrayList<User>) ois.readObject();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        }
    }
}