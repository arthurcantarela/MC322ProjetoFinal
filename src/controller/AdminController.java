package controller;

import admin.IAdminSistema;
import model.IPacoteViagem;

public class AdminController {
    private IAdminSistema adminSistema;

    public AdminController(IAdminSistema adminSistema) {
        this.adminSistema = adminSistema;
    }

    // Método para adicionar um pacote de viagem
    public void adicionarPacote(IPacoteViagem pacote) {
        adminSistema.adicionarPacote(pacote);
    }

    // Método para remover um pacote de viagem
    public void removerPacote(IPacoteViagem pacote) {
        adminSistema.removerPacote(pacote);
    }

    // Método para editar um pacote de viagem
    public void editarPacote(IPacoteViagem pacoteExistente, IPacoteViagem novoPacote) {
        adminSistema.editarPacote(pacoteExistente, novoPacote);
    }
}
