package admin;

import model.PacoteViagem;
import java.util.ArrayList;
import java.util.List;

public class AdminSistema implements IAdminSistema {
    private List<PacoteViagem> pacotes;

    public AdminSistema() {
        this.pacotes = new ArrayList<>();
    }

    // Implementação do método adicionarPacote
    @Override
    public void adicionarPacote(PacoteViagem pacote) {
        pacotes.add(pacote);
        System.out.println("Pacote adicionado: " + pacote);
    }

    // Implementação do método removerPacote
    @Override
    public void removerPacote(PacoteViagem pacote) {
        if (pacotes.remove(pacote)) {
            System.out.println("Pacote removido: " + pacote);
        } else {
            System.out.println("Pacote não encontrado.");
        }
    }

    // Implementação do método editarPacote
    @Override
    public void editarPacote(PacoteViagem pacoteExistente, PacoteViagem novoPacote) {
        int index = pacotes.indexOf(pacoteExistente);
        if (index != -1) {
            pacotes.set(index, novoPacote);
            System.out.println("Pacote editado: " + novoPacote);
        } else {
            System.out.println("Pacote para editar não encontrado.");
        }
    }

    // Método para exibir todos os pacotes
    public void exibirPacotes() {
        System.out.println("Pacotes disponíveis:");
        for (PacoteViagem pacote : pacotes) {
            System.out.println(pacote);
        }
    }
}
