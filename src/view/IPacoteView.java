package view;

import java.util.List;

import controller.PacoteController;
import model.IDestino;
import model.IPacoteViagem;

public interface IPacoteView {
	public void visualizarPacote(IPacoteViagem pacote);
	
	public void visualizarPacotesDisponiveis(List <IPacoteViagem> pacotesDisponiveis);
	
}
