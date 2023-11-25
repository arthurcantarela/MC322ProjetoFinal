package model;

public class Reserva {
	private UsuarioBase reservante;
	private PacoteViagem pacote;
	
	public Reserva (UsuarioBase usuario, PacoteViagem pacote){
		this.pacote = pacote;
		this.reservante = usuario;
	}
	
	// geters ans seters
	public UsuarioBase getReservante() {
		return reservante;
	}

	public PacoteViagem getPacote() {
		return pacote;
	}

	public void setReservante(UsuarioBase reservante) {
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
