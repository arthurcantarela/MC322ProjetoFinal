package view;

import java.util.List;

import model.*;


public interface IDestinoView {
	
	public abstract void visualizarDestinos(List<IDestino> destinos);
	public abstract void visualizarCategorias(List<CategoriaDestino> destinos);
	
}
