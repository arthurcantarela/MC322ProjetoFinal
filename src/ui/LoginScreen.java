package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JFrame {
    public LoginScreen() {
        super("Login");
        setSize(300, 200);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JLabel userLabel = new JLabel("Usuário:");
        JTextField userTextField = new JTextField();
        JLabel passwordLabel = new JLabel("Senha:");
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementação do login
                // Você pode chamar o método de autenticação aqui
            }
        });

        add(userLabel);
        add(userTextField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
    }
}
