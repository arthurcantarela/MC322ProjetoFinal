package model;

public interface IPacoteViagem {
	public Destino getDestino();

	public double getPreco();

	public void setPreco(double preco);

	public boolean isDisponivel();
}