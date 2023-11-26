package controller;
import model.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public interface IUsuarioController {
	abstract Map<String,IUsuario> mapUsuarios();
	abstract List<IUsuario> listarUsuarios();
}
