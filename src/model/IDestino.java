package model;

public interface IDestino {
    String getNome();

    String getDescricao();

    void setDescricao(String descricao);

    CategoriaDestino getCategoria();
}