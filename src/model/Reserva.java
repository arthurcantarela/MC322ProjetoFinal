package model;

public class Reserva implements IReserva {
	private Usuario reservante;
	private PacoteViagem pacote;
	
	public Reserva  (Usuario usuario, PacoteViagem pacote){
		this.pacote = pacote;
		this.reservante = usuario;
	}
	
	// geters ans seters
	public Usuario getReservante() {
		return reservante;
	}

	public PacoteViagem getPacote() {
		return pacote;
	}

	public void setReservante(Usuario reservante) {
		this.reservante = reservante;
	}

	public void setPacote(PacoteViagem pacote) {
		this.pacote = pacote;
	}

	@Override
	public String toString() {
		return "Reserva [reservante=" + reservante + ", pacote=" + pacote + "]";
	}
}