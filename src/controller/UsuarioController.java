package controller;

import model.IUsuario;
import model.Usuario;
import model.UsuarioRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsuarioController{
    private Map<String,IUsuario> usuarios = new HashMap<>();

    public UsuarioController() {
    	List<IUsuario> listUsuarios = new UsuarioRepository().carregar();
    	
    	for(IUsuario usuario: listUsuarios) {
    		usuarios.put(usuario.getEmail(), usuario);
    	}
    	
    }
    // Método para listar usuários
    public List<IUsuario> listarUsuarios() {
    	 return new ArrayList<>(usuarios.values());
    }
}
