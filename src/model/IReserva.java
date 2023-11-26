package model;

public interface IReserva {
	public IUsuario getReservante();

	public IPacoteViagem getPacote();

	public void setReservante(IUsuario reservante);

	public void setPacote(IPacoteViagem pacote);
}
