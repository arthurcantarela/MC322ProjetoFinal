package model;

import java.time.LocalDate;

public interface IPacoteViagem {
	public IDestino getDestino();

	public IUsuario getUsuario();

	public double getPreco();

	public void setPreco(double preco);

	public boolean isDisponivel();

	public LocalDate getDataInicio();

	public LocalDate getDataFim();

	public void setDestino(Destino destino);

	public void setUsuario(Usuario usuario);

	public void setDataInicio(LocalDate dataInicio);

	public void setDataFim(LocalDate dataFim);
}