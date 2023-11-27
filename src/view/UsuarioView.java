package view;

import java.util.List;

import model.IUsuario;
import model.UsuarioAdmin;

public class UsuarioView implements IUsuarioView {
	
	public void visualizarUsuarios(List<IUsuario> usuarios) {
		int j = 0;
        for (IUsuario usuario : usuarios ) {
        	j++;
        	if(usuario instanceof UsuarioAdmin) {
        		System.out.println(j +" - Usuário:" + usuario.getNome() + "(Administrador)");
        	} else {
        		System.out.println(j +" - Usuário:" + usuario.getNome());
        	}
        	System.out.println("Email:" + usuario.getEmail());
        	System.out.println("");

        }
	}
	
}
