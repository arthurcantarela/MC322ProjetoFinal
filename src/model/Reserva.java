package model;

public class Reserva implements IReserva {
	private IUsuario reservante;
	private IPacoteViagem pacote;
	
	public Reserva  (IUsuario usuario, IPacoteViagem pacote){
		this.pacote = pacote;
		this.reservante = usuario;
	}
	
	// geters ans seters
	public IUsuario getReservante() {
		return reservante;
	}

	public IPacoteViagem getPacote() {
		return pacote;
	}

	public void setReservante(IUsuario reservante) {
		this.reservante = reservante;
	}

	public void setPacote(IPacoteViagem pacote) {
		this.pacote = pacote;
	}

	@Override
	public String toString() {
		return "Reserva [reservante=" + reservante + ", pacote=" + pacote + "]";
	}
}