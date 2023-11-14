package model;

public interface IDestino {
	public String getNome();

	public String getDescricao();

	public void setDescricao(String descricao);

	public CategoriaDestino getCategoria();
}