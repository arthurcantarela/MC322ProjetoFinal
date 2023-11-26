package controller;

import java.util.List;

import model.*;

public interface IPacoteController {
	public List<PacoteViagem> buscaPacotesDisponiveisPorDestino(List<IDestino> destinos);
	public List<PacoteViagem> buscaPacotesDisponiveisPorDestino(IDestino destino);
	public List<PacoteViagem> listarPacotes();
	
}
