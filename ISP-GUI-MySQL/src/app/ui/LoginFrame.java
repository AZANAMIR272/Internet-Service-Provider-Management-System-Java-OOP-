package app.ui;

import app.db.UserDAO;
import app.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {
    private JTextField txtUser;
    private JPasswordField txtPass;

    public LoginFrame() {
        setTitle("ISP System - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 200);
        setLocationRelativeTo(null);
        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel(new GridLayout(4, 1, 5, 5));
        txtUser = new JTextField();
        txtPass = new JPasswordField();

        // Pre-fill with default credentials for easy login
        txtUser.setText("admin");
        txtPass.setText("admin123");

        panel.add(new JLabel("Username:"));
        panel.add(txtUser);
        panel.add(new JLabel("Password:"));
        panel.add(txtPass);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(this::login);
        JPanel bottom = new JPanel();
        bottom.add(btnLogin);

        add(panel, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);
    }

    private void login(ActionEvent e) {
        String username = txtUser.getText().trim();
        String password = new String(txtPass.getPassword()).trim();
        User user = UserDAO.authenticate(username, password);
        if (user != null) {
            JOptionPane.showMessageDialog(this, "Welcome " + user.getUsername() + " (" + user.getRole() + ")");
            dispose();
            java.awt.EventQueue.invokeLater(() -> new MainFrame(user).setVisible(true));
        } else {
            JOptionPane.showMessageDialog(this, "Invalid credentials", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
