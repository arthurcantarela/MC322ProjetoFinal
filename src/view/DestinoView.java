package view;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import controller.*;

import model.*;

public class DestinoView implements IDestinoView{
	PacoteView pacoteView = new PacoteView();

	@Override
	public IDestino visualizarDestinosDisponiveis(DestinoController destinoController, PacoteController pacoteController, Scanner scanner) {
		
		System.out.println("\n--- Destinos Disponíveis ---");
        int i = 0;
        List<IDestino> destinosDisponiveis = destinoController.destinosDisponiveis(pacoteController);
        for(IDestino destino: destinosDisponiveis) {
        	i ++;
        	System.out.println(i+ " - " + destino.getNome() + " - " + destino.getCategoria());
        }
        
        System.out.println("Escolha o destino desejado: ");
        
        int opcao = scanner.nextInt();
        IDestino destinoSelecionado = destinosDisponiveis.get(opcao-1);
        
        return destinoSelecionado;
    }
}
	
