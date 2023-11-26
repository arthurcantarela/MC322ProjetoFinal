package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import model.DestinoRepository;
import model.IDestino;
import model.UsuarioRepository;

public class DestinoController {
	private static Map<UUID,IDestino> destinos = new HashMap<>();
	
	public DestinoController() {
		List<IDestino> listDestinos = new DestinoRepository().carregar();
    	
    	for(IDestino destino: listDestinos) {
    		destinos.put(destino.getId(), destino);
    	}
    	
    }
    // Método para listar usuários
    public static List<IDestino> listarDestinos() {
    	 return new ArrayList<>(destinos.values());
    }
    
    public static IDestino getDestinoPorNome(String destino) {
    	List<IDestino> lista = listarDestinos();
    	IDestino destEncontrado = null;
    	
    	for(IDestino dest:lista) {
    		if(dest.getNome() == destino)
    			destEncontrado = dest;
    	}
    	return destEncontrado;    	
    }
}

