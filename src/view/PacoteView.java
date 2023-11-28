package view;

import java.time.format.DateTimeFormatter;
import java.util.List;

import model.*;

public class PacoteView implements IPacoteView {

	@Override
	public void visualizarPacote(IPacoteViagem pacote) {
		System.out.println("\tDestino: " + pacote.getDestino().getNome());
		System.out.println("\tCategoria: " + pacote.getDestino().getCategoria());
		System.out.println("\tPreço: R$ " + pacote.getPreco());
		System.out
				.println("\tData de Início: "
						+ pacote.getDataInicio().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		System.out.println("\tData de Fim: " + pacote.getDataFim().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		System.out.println();
	}

	@Override
	public void visualizarPacotes(List<IPacoteViagem> pacotes) {
		int j = 0;
		for (IPacoteViagem pacote : pacotes) {
			j++;
			System.out.println("Pacote " + j + ": ");
			visualizarPacote(pacote);
		}
	}

}
