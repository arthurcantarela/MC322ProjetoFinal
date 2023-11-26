package controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.*;

public class PacoteController implements IPacoteController {
	@Override
	public void removerPacote(IPacoteViagem pacote) {
		// TODO Auto-generated method stub
		
	}

	private static List<IPacoteViagem> pacotes = new ArrayList<>();
	
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
		//todo
	}

}
