package view;


import java.util.List;

import model.*;

public class PacoteView implements IPacoteView{

	@Override
    public void visualizarPacotes(IPacoteViagem pacote) {
    	System.out.println("Destino: " + pacote.getDestino().getNome());
    	System.out.println("Categoria: " + pacote.getDestino().getCategoria());
        System.out.println("Preço: R$ " + pacote.getPreco());
        System.out.println("Data de Início: " + pacote.getDataInicio());
        System.out.println("Data de Fim: " + pacote.getDataFim());
        System.out.println();
    }
	
	public void visualizarPacotes(List <IPacoteViagem> pacotes) {
		int j = 0;
        for (IPacoteViagem pacote : pacotes ) {
        	j++;
        	System.out.println("Pacote " + j + ": ");
        	visualizarPacotes(pacote);
        }
	}
	
}
