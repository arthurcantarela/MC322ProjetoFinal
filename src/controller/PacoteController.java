package controller;

import java.util.ArrayList;
import java.util.List;

import model.*;

public class PacoteController {
	private static List<PacoteViagem> pacotes = new ArrayList<>();
		
	public List<PacoteViagem> buscaPacotesPorDestino(String nomeDestino){
		IDestino destino = DestinoController.getDestinoPorNome(nomeDestino);
		List<PacoteViagem> pacotesEncontrados = new ArrayList<>();
		for(PacoteViagem pacote: pacotes) {
			if(pacote.getDestino() == destino && pacote.isDisponivel()) {
				pacotesEncontrados.add(pacote);
			}
		}
		return pacotesEncontrados;
	}
}
