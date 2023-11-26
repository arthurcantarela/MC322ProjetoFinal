package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import model.*;

public class DestinoController implements IDestinoController {
	private static Map<UUID,IDestino> destinos = new HashMap<>();
	
	public DestinoController() {
		List<IDestino> listDestinos = new DestinoRepository().carregar();
    	
    	for(IDestino destino: listDestinos) {
    		destinos.put(destino.getId(), destino);
    	}
    	
    }
    // Método para listar usuários
    public List<IDestino> listarDestinos() {
    	 return new ArrayList<>(destinos.values());
    }
    
    public IDestino getDestinoPorNome(String destino) {
    	List<IDestino> lista = listarDestinos();
    	IDestino destEncontrado = null;
    	
    	for(IDestino dest:lista) {
    		if(dest.getNome() == destino)
    			destEncontrado = dest;
    	}
    	return destEncontrado;    	
    }
    
	public List<IDestino> destinosDisponiveis(IPacoteController pacoteController) {
		//Set para não repetir os destinos disponíveis
		Set<IDestino> destinosExibidos = new HashSet<>();
		
		//Lista para armazenar os destinos que 
		//estão disponiveis e não são repetidos
		List<IDestino> listaAux = new ArrayList<>();
		
		int i = 0;
		for (IPacoteViagem pacote : pacoteController.listarPacotes() ) {
        	if(pacote.isDisponivel() && destinosExibidos.add(pacote.getDestino())) {
        		listaAux.add(i, pacote.getDestino());
        		i ++;	
        	}
        }
		return listaAux;
	}
	public List<CategoriaDestino> categoriasDisponiveis() {
		return Arrays.asList(CategoriaDestino.values());
	}
	@Override
	public void adicionarDestino(IDestino destino) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removerDestino(IDestino destino) {
		// TODO Auto-generated method stub
		
	}

	 
    	
    
}

