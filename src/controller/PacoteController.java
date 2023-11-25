package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.*;

public class PacoteController {
	private static List<PacoteViagem> pacotes = new ArrayList<>();
		
	public List<PacoteViagem> buscaPacotesPorDestino(Destino destino){
		List<PacoteViagem> pacotesEncontrados = new ArrayList<>();
		for(PacoteViagem pacote: pacotes) {
			if(pacote.getDestino() == destino && pacote.isDisponivel()) {
				pacotesEncontrados.add(pacote);
			}
		}
		return pacotesEncontrados;
	}
}
