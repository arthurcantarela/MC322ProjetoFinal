package view;

import java.util.List;

import model.IReserva;

public class ReservaView implements IReservaView{
	private static IPacoteView pacoteView = new PacoteView();
	@Override
	public void visualizarReservas(List<IReserva> reservas) {
		for(IReserva reserva: reservas) {
			pacoteView.visualizarPacotes(reserva.getPacote());
		}
		
	}

}
