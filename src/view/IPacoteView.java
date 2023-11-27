package view;

import java.util.List;


import model.IPacoteViagem;

public interface IPacoteView {
	public void visualizarPacotes(IPacoteViagem pacote);
	
	public void visualizarPacotes(List <IPacoteViagem> pacotes);
	
}
