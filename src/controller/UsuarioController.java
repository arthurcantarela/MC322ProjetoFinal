package controller;

import model.IUsuario;
import model.Usuario;
import model.UsuarioAdmin;
import model.UsuarioRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsuarioController implements IUsuarioController{
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
    
    
	public Map<String,IUsuario> mapUsuarios (){
    	return usuarios;
    }
	@Override
	public IUsuario adicionarUsuario(String nome, String emailUsuario) {
		IUsuario usuario = new Usuario(nome, emailUsuario);
		usuarios.put(usuario.getEmail(), usuario);
		new UsuarioRepository().salvar(listarUsuarios());
		return usuario;
		
	}
	
	public IUsuario adicionarUsuario(UsuarioAdmin usuario) {
		usuarios.put(usuario.getEmail(), usuario);
		new UsuarioRepository().salvar(listarUsuarios());
		return usuario;
		
	}
	
	
	@Override
	public IUsuario removerUsuario(String emailUsuario) {
		IUsuario usuario = usuarios.remove(emailUsuario);
		new UsuarioRepository().salvar(listarUsuarios());
		return usuario;
		
	}
	

	
}
