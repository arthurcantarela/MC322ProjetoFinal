package controller;
import model.*;
import java.util.List;
import java.util.Map;
public interface IUsuarioController {
	public abstract Map<String,IUsuario> mapUsuarios();
	public abstract List<IUsuario> listarUsuarios();
	public abstract IUsuario adicionarUsuario(String nome, String emailUsuario);
	public abstract IUsuario adicionarUsuario(UsuarioAdmin usuario) ;
	public abstract IUsuario removerUsuario(String emailUsuario);
	
}
