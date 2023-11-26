package model;

public interface IReserva {
	public Usuario getReservante();

	public PacoteViagem getPacote();

	public void setReservante(Usuario reservante);

	public void setPacote(PacoteViagem pacote);
}
