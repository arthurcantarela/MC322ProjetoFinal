package controller;

import model.IUsuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioController {
    private List<IUsuario> usuarios;

    public UsuarioController() {
        this.usuarios = new ArrayList<>();
    }

    // Método para adicionar um novo usuário
    public void adicionarUsuario(IUsuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuário adicionado: " + usuario.getNome());
    }

    // Método para listar usuários
    public void listarUsuarios() {
        for (IUsuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }
}
