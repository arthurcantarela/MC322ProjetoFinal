package model;

public class UsuarioAdmin extends Usuario {
    public UsuarioAdmin(String nome, String email) {
        super(nome, email);
    }
    
    public UsuarioAdmin(IUsuario usuario) {
    	super(usuario.getNome(),usuario.getEmail());
    }
}
