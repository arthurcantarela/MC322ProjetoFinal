package controller;

import model.UsuarioBase;

import java.util.ArrayList;
import java.util.List;

public class UsuarioController {
    private List<UsuarioBase> usuarioBases;

    public UsuarioController() {
        this.usuarioBases = new ArrayList<>();
    }

    // Método para adicionar um novo usuário
    public void adicionarUsuario(UsuarioBase usuarioBase) {
        usuarioBases.add(usuarioBase);
        System.out.println("Usuário adicionado: " + usuarioBase.getNome());
    }

    // Método para listar usuários
    public void listarUsuarios() {
        for (UsuarioBase usuarioBase : usuarioBases) {
            System.out.println(usuarioBase);
        }
    }
}
