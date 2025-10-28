package app.db;

import app.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static final List<User> users = new ArrayList<>();
    static {
        // In-memory user data. In a real app, passwords should be hashed.
        users.add(new User(1, "admin", "Administrator", "admin123"));
    }

    public static User authenticate(String username, String password) {
        return users.stream()
                .filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password))
                .findFirst().orElse(null);
    }
}
