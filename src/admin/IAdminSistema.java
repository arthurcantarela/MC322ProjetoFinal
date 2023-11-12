package admin;

import model.IPacoteViagem;

public interface IAdminSistema {
    void adicionarPacote(IPacoteViagem pacote);

    void removerPacote(IPacoteViagem pacote);

    void editarPacote(IPacoteViagem pacote, IPacoteViagem novoPacote);
}
