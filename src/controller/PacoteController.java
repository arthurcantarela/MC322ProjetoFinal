package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import model.*;

public class PacoteController implements IPacoteController {
	private static List<IPacoteViagem> pacotes = new ArrayList<>();
	
	public PacoteController() {
		//map destinos
		List<IDestino> listDestinos = new DestinoRepository().carregar();
		HashMap<UUID, IDestino> destinos = new HashMap<>();
    	for(IDestino destino: listDestinos) {
			destinos.put(destino.getId(), destino);
    	}	
		//map usuarios
    	HashMap<String,IUsuario> usuarios = new HashMap<>();
    	List<IUsuario> listUsuarios = new UsuarioRepository().carregar();
    	for(IUsuario usuario: listUsuarios) {
    		usuarios.put(usuario.getEmail(), usuario);
    	}
		pacotes = new PacoteViagemRepository(destinos, usuarios).carregar();
	}
	
	@Override
	public void removerPacote(IPacoteViagem pacote) {
		// TODO Auto-generated method stub
		
	}

	//Testar
	public List<IPacoteViagem> buscarPacotesDisponiveis(List<IDestino> destinos){
		//A lista de destinos não pode haver repetição
		List<IPacoteViagem> pacotesEncontrados = new ArrayList<>();
		for(IDestino destino: destinos) {
			for(IPacoteViagem pacote: pacotes) {
				if(pacote.getDestino() == destino && pacote.isDisponivel()) {
					pacotesEncontrados.add(pacote);
				}
			}
		}
		return pacotesEncontrados;
	}
	
	//Polimorfismo
	public List<IPacoteViagem> buscarPacotesDisponiveis(IDestino destino){
		//A lista de destinos não pode haver repetição
		List<IPacoteViagem> pacotesEncontrados = new ArrayList<>();
		for(IPacoteViagem pacote: pacotes) {
			if(pacote.getDestino() == destino && pacote.isDisponivel()) {
				pacotesEncontrados.add(pacote);
			}
		}
		return pacotesEncontrados;
	}
	
	public List<IPacoteViagem> buscarPacotesDisponiveis(double precoMaximo) {
		List <IPacoteViagem> pacotesEncontrados = new ArrayList<>();
        for (IPacoteViagem pacote : pacotes) {
            if (pacote.getPreco() <= precoMaximo && pacote.isDisponivel()) {
            	pacotesEncontrados.add(pacote);
            }
        }
        return pacotesEncontrados;
	}
	
	public List<IPacoteViagem> buscarPacotesDisponiveis (CategoriaDestino categoria) {
		List <IPacoteViagem> pacotesEncontrados = new ArrayList<>();
        for (IPacoteViagem pacote : pacotes) {
        	if (pacote.getDestino().getCategoria().equals(categoria) && pacote.isDisponivel()) {
            	pacotesEncontrados.add(pacote);
            }
        }
        return pacotesEncontrados;
	}
	
	public List<IPacoteViagem> listarPacotes() {
		return pacotes;
	}
	
	public void adicionarPacote(IPacoteViagem pacote) {
		//map destinos
		List<IDestino> listDestinos = new DestinoRepository().carregar();
		HashMap<UUID, IDestino> destinos = new HashMap<>();
		for(IDestino destino: listDestinos) {
			destinos.put(destino.getId(), destino);
		}	
		//map usuarios
		HashMap<String,IUsuario> usuarios = new HashMap<>();
		List<IUsuario> listUsuarios = new UsuarioRepository().carregar();
		for(IUsuario usuario: listUsuarios) {
			usuarios.put(usuario.getEmail(), usuario);
		}
		pacotes.add(pacote);
		new PacoteViagemRepository(destinos, usuarios).salvar(pacotes);
		
	}

}
