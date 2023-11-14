package ui;

import javax.swing.*;
import model.IPacoteViagem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ReservaScreen extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ReservaScreen(List<IPacoteViagem> pacotesDisponiveis) {
        super("Reserva de Pacotes");
        setSize(400, 300);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Escolha um Pacote de Viagem:");
        JComboBox<IPacoteViagem> pacoteComboBox = new JComboBox<>(pacotesDisponiveis.toArray(new IPacoteViagem[0]));
        JButton reservaButton = new JButton("Reservar");

        reservaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementação da reserva
                // Você pode chamar o método para realizar a reserva aqui
            }
        });

        add(label);
        add(pacoteComboBox);
        add(reservaButton);
    }
}
