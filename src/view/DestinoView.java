package view;

import java.util.List;
import model.*;

public class DestinoView implements IDestinoView {
	PacoteView pacoteView = new PacoteView();

	@Override
	public void visualizarDestinos(List<IDestino> destinos) {
		int i = 0;
		for (IDestino destino : destinos) {
			i++;
			System.out.println(i + " - " + destino.getNome());
			System.out.println("\tCategoria: " + destino.getCategoria());
			System.out.println("\tDescrição: " + destino.getDescricao());
		}
	}

	public void visualizarCategorias(List<CategoriaDestino> categoriasDestinos) {

		int i = 0;
		for (CategoriaDestino categoria : categoriasDestinos) {
			i++;
			System.out.println(i + " - " + categoria);
		}

	}
}
