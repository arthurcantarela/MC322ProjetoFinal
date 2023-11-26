package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


import controller.*;

import model.*;

public class DestinoView implements IDestinoView{
	PacoteView pacoteView = new PacoteView();

	@Override
	public void visualizarDestinosDisponiveis(List <IDestino> destinosDisponiveis) {
        int i = 0;
        for(IDestino destino: destinosDisponiveis) {
        	i ++;
        	System.out.println(i+ " - " + destino.getNome() + " - " + destino.getCategoria());
        }
    }
	
	public void visualizarCategorias(List<CategoriaDestino> categoriasDestinos) {
		
        int i = 0;
        for(CategoriaDestino categoria: categoriasDestinos) {
        	i ++;
        	System.out.println(i+ " - " + categoria);
        }
		
	}
}
	
