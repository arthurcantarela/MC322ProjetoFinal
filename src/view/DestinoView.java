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
	public void visualizarDestinos(List <IDestino> destinos) {
        int i = 0;
        for(IDestino destino: destinos) {
        	i ++;
        	System.out.println(i+ " - " + destino.getNome() + " - " + destino.getCategoria());
        	System.out.println("Descrição " + destino.getDescricao());
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
	
