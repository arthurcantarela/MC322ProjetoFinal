package view;

import java.util.List;

import model.IPacoteViagem;
import model.IUsuario;

public class UsuarioView implements IUsuarioView {
	
	public void visualizarUsuarios(List<IUsuario> usuarios) {
		int j = 0;
        for (IUsuario usuario : usuarios ) {
        	j++;
        	System.out.println(j +" -  Usuario:" + usuario.getNome());
        	System.out.println("Email:" + usuario.getEmail());
        }
	}
	
}
