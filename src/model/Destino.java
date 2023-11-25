package model;

import java.util.UUID;

public class Destino implements IDestino {
    private UUID id;
    private String nome;
    private String descricao;
    private CategoriaDestino categoria;

    public Destino(String nome, String descricao, CategoriaDestino categoria) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
    }

    // Implementação do método getId
    @Override
    public UUID getId() {
        return id;
    }

    // Implementação do método getNome
    @Override
    public String getNome() {
        return nome;
    }

    // Implementação do método getDescricao
    @Override
    public String getDescricao() {
        return descricao;
    }

    // Implementação do método setDescricao
    @Override
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Implementação do método getCategoria
    @Override
    public CategoriaDestino getCategoria() {
        return categoria;
    }

    // Método toString para facilitar a visualização das informações do destino
    @Override
    public String toString() {
        return "Destino{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", categoria=" + categoria +
                '}';
    }
}
