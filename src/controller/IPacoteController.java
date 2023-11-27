package controller;

import java.util.List;

import model.*;

public interface IPacoteController {
	public List<IPacoteViagem> buscarPacotesDisponiveis(List<IDestino> destinos);
	public List<IPacoteViagem> buscarPacotesDisponiveis(IDestino destino);
	public List<IPacoteViagem> buscarPacotesDisponiveis(double precoMaximo);
	public List<IPacoteViagem> buscarPacotesDisponiveis(CategoriaDestino categoria);
	public List<IPacoteViagem> listarPacotes();
	public IPacoteViagem adicionarPacote(IPacoteViagem pacote);
	public IPacoteViagem removerPacote(IPacoteViagem pacote);
	
}
