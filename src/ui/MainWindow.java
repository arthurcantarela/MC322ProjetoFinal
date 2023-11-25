package ui;

import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.*;
import exceptions.ReservaIndisponivelException;
import model.*;


public class MainWindow extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
//        MainWindow window = new MainWindow();
//        window.setVisible(true);
    	Usuario usuario = new Usuario("Nome", "email@email.com");
    	Destino destino = new Destino("Destino", "Descricao", CategoriaDestino.AVENTURA);
    	PacoteViagem pacote = new PacoteViagem(destino, 100, true, LocalDate.now(), LocalDate.now());
    	
    	//primeira tentativa
    	try {
			ReservaController.ReservarPacote(usuario, pacote);
		} catch (ReservaIndisponivelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	// segunda tentativa
    	
    	try {
			ReservaController.ReservarPacote(usuario, pacote);
		} catch (ReservaIndisponivelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}
