package model;


import java.util.UUID;

public interface IDestino {
	public UUID getId();

	public String getNome();

	public String getDescricao();

	public void setDescricao(String descricao);

	public CategoriaDestino getCategoria();
	
}