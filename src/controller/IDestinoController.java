package controller;

import java.util.List;

import model.CategoriaDestino;
import model.IDestino;

public interface IDestinoController {
	public IDestino getDestinoPorNome(String destino);
	public List<IDestino> destinosDisponiveis(IPacoteController pacoteController);
	public List<CategoriaDestino> categoriasDisponiveis();
	public IDestino adicionarDestino(IDestino destino);
	public IDestino removerDestino(IDestino destino);
	public List<IDestino> listarDestinos();
}
