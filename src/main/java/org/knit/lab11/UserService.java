package org.knit.lab11;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private final UserDAOImpl userDAO;

    public UserService(UserDAOImpl userDAO) {
        this.userDAO = userDAO;
    }

    public void registerUser(String name, String email) {
        if (userDAO.emailExists(email)) {
            throw new IllegalArgumentException("Пользователь с такой почтой уже зареган");
        }
        User user = new User(0, name, email);
        userDAO.create(user);
    }

    public List<User> listAllUsers() {
        return userDAO.findAll();
    }

    public void deleteUser(int id) {
        User user = userDAO.findById(id);
        if (user == null) {
            throw new IllegalArgumentException("Пользователь с ID " + id + " не найден");
        }
        userDAO.delete(id);
    }

    public void updateUser(int id, String newName, String newEmail) throws SQLException {
        User user = userDAO.findById(id);
        if (user == null) {
            throw new IllegalArgumentException("Пользователь с ID " + id + " не найден");
        }

        if (!user.getEmail().equals(newEmail) && userDAO.emailExists(newEmail)) {
            throw new IllegalArgumentException("Пользователь с такой почтой уже зареган");
        }

        user.setName(newName);
        user.setEmail(newEmail);
        userDAO.update(user);
    }
}

