package ui;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainWindow extends JFrame {
    public MainWindow() {
        super("Plataforma Digital de Turismo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adicionar elementos à janela principal
        JLabel label = new JLabel("Bem-vindo à Plataforma de Turismo!");
        add(label);

        // Outros componentes e layouts podem ser adicionados aqui
    }

    public static void main(String[] args) {
        MainWindow window = new MainWindow();
        window.setVisible(true);
    }
}
