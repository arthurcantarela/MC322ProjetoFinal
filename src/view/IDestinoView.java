package view;

import java.util.List;
import java.util.Scanner;

import controller.*;
import model.*;


public interface IDestinoView {
	
	public abstract void visualizarDestinos(List<IDestino> destinos);
	public abstract void visualizarCategorias(List<CategoriaDestino> destinos);
	
}
