package view;

import java.util.ArrayList;
import java.util.List;

import model.*;

public class PacoteView implements IPacoteView{

	@Override
    public void visualizarPacote(IPacoteViagem pacote) {
    	System.out.println("Destino: " + pacote.getDestino().getNome());
    	System.out.println("Categoria: " + pacote.getDestino().getCategoria());
        System.out.println("Preço: R$ " + pacote.getPreco());
        System.out.println("Data de Início: " + pacote.getDataInicio());
        System.out.println("Data de Fim: " + pacote.getDataFim());
        System.out.println();
    }
	
	public void visualizarPacotesDisponiveis(List <IPacoteViagem> pacotesDisponiveis) {
		int j = 0;
        for (IPacoteViagem pacote : pacotesDisponiveis ) {
        	j++;
        	System.out.println("Pacote " + j + ": ");
        	visualizarPacote(pacote);
        }
	}
	
}
