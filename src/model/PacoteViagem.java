package model;

import java.time.LocalDate;

public class PacoteViagem implements IPacoteViagem {
    private IDestino destino;
    private double preco;
    private IUsuario usuario;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public PacoteViagem(IDestino destino, double preco,
            LocalDate dataInicio, LocalDate dataFim) {
        this.destino = destino;
        this.preco = preco;
        this.dataFim = dataFim;
        this.dataInicio = dataInicio;
        this.usuario = null;
    }

    public PacoteViagem(IDestino destino, double preco,
            LocalDate dataInicio, LocalDate dataFim, IUsuario usuario) {
        this.destino = destino;
        this.preco = preco;
        this.dataFim = dataFim;
        this.dataInicio = dataInicio;
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "PacoteViagem [destino=" + destino + ", preco=" + preco + ", usuario=" + usuario + ", dataInicio="
                + dataInicio + ", dataFim=" + dataFim + "]";
    }

    // Implementação do método getDestino
    @Override
    public IDestino getDestino() {
        return destino;
    }

    // Implementação do método getPreco
    @Override
    public double getPreco() {
        return preco;
    }

    // Implementação do método setPreco
    @Override
    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public IUsuario getUsuario() {
        return usuario;
    }

    @Override
    public LocalDate getDataInicio() {
        return dataInicio;
    }

    @Override
    public LocalDate getDataFim() {
        return dataFim;
    }

    @Override
    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    @Override
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    @Override
    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    @Override
    public boolean isDisponivel() {
        if (this.usuario != null) {
            return false;
        } else
            return true;
    }
}
