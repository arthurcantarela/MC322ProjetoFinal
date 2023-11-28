package view;

import java.util.List;

import model.IPacoteViagem;

public interface IPacoteView {
	public void visualizarPacote(IPacoteViagem pacote);

	public void visualizarPacotes(List<IPacoteViagem> PacoteViagem);

}
