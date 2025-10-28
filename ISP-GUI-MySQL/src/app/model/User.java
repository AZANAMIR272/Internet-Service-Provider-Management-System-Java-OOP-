package app.model;

public class User {
    private int userId;
    private String username;
    private String role;
    private String password; // Only for in-memory authentication example

    public User(int userId, String username, String role) {
        this.userId = userId;
        this.username = username;
        this.role = role;
    }

    public User(int userId, String username, String role, String password) {
        this.userId = userId;
        this.username = username;
        this.role = role;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return username + " (" + role + ")";
    }
}