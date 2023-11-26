package controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.*;

public class PacoteController implements IPacoteController {
	private static List<PacoteViagem> pacotes = new ArrayList<>();
	
	//Testar
	public List<PacoteViagem> buscaPacotesDisponiveisPorDestino(List<IDestino> destinos){
		//A lista de destinos não pode haver repetição
		List<PacoteViagem> pacotesEncontrados = new ArrayList<>();
		for(IDestino destino: destinos) {
			for(PacoteViagem pacote: pacotes) {
				if(pacote.getDestino() == destino && pacote.isDisponivel()) {
					pacotesEncontrados.add(pacote);
				}
			}
		}
		return pacotesEncontrados;
	}
	
	//Polimorfismo
	public List<PacoteViagem> buscaPacotesDisponiveisPorDestino(IDestino destino){
		//A lista de destinos não pode haver repetição
		List<PacoteViagem> pacotesEncontrados = new ArrayList<>();
		for(PacoteViagem pacote: pacotes) {
			if(pacote.getDestino() == destino && pacote.isDisponivel()) {
				pacotesEncontrados.add(pacote);
			}
		}
		return pacotesEncontrados;
	}
	
	public List<PacoteViagem> listarPacotes() {
		return pacotes;
	}
	

}
