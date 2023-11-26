package view;

import java.util.List;

import controller.PacoteController;
import model.IDestino;
import model.IPacoteViagem;

public interface IPacoteView {
	public void imprimirPacote(IPacoteViagem pacote);
	
	public List<IPacoteViagem> selecionarPacotesDisponiveis(IDestino destinoSelecionado, PacoteController pacoteController);
}
