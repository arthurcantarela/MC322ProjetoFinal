package controller;

import admin.AdminSistema;
import model.PacoteViagem;

public class AdminController {
    private AdminSistema adminSistema;

    public AdminController(AdminSistema adminSistema) {
        this.adminSistema = adminSistema;
    }

    // Método para adicionar um pacote de viagem
    public void adicionarPacote(PacoteViagem pacote) {
        adminSistema.adicionarPacote(pacote);
    }

    // Método para remover um pacote de viagem
    public void removerPacote(PacoteViagem pacote) {
        adminSistema.removerPacote(pacote);
    }

    // Método para editar um pacote de viagem
    public void editarPacote(PacoteViagem pacoteExistente, PacoteViagem novoPacote) {
        adminSistema.editarPacote(pacoteExistente, novoPacote);
    }
}
