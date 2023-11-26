package view;

import java.util.List;
import java.util.Scanner;

import controller.*;
import model.*;


public interface IDestinoView {

	public abstract void visualizarDestinosDisponiveis(List<IDestino> destinosDisponiveis);
	public abstract void visualizarCategorias(List<CategoriaDestino> destinos);
	
}
