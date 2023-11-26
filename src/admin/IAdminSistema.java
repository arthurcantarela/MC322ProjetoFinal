package admin;

import model.PacoteViagem;

public interface IAdminSistema {
	public void adicionarPacote(PacoteViagem pacote);

    public void removerPacote(PacoteViagem pacote);

    public void editarPacote(PacoteViagem pacote, PacoteViagem novoPacote);
}
