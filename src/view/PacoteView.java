package view;

import java.util.ArrayList;
import java.util.List;

import controller.PacoteController;
import model.IDestino;
import model.IPacoteViagem;

public class PacoteView implements IPacoteView{

	@Override
    public void imprimirPacote(IPacoteViagem pacote) {
    	System.out.println("Destino: " + pacote.getDestino().getNome());
    	System.out.println("Categoria: " + pacote.getDestino().getCategoria());
        System.out.println("Preço: R$ " + pacote.getPreco());
        System.out.println("Data de Início: " + pacote.getDataInicio());
        System.out.println("Data de Fim: " + pacote.getDataFim());
        System.out.println();
    }
	
	public List<IPacoteViagem> selecionarPacotesDisponiveis(IDestino destinoSelecionado, PacoteController pacoteController) {
		int j = 0;
		List<IPacoteViagem> pacotes = new ArrayList<>();
        System.out.println("\n--- Pacotes Disponíveis - Destino " + destinoSelecionado.getNome() + " ---");
        for (IPacoteViagem pacote : pacoteController.buscaPacotesDisponiveisPorDestino(destinoSelecionado)) {
        	j++;
        	System.out.println("Pacote " + j + ": ");
        	imprimirPacote(pacote);
        	pacotes.add(pacote);
        }
        return pacotes;
	}
	
}
