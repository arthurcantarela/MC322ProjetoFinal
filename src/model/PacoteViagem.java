package model;

import java.time.LocalDate;

public class PacoteViagem implements IPacoteViagem {
    private Destino destino;
    private double preco;
    private Usuario usuario;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public PacoteViagem(Destino destino, double preco, boolean disponivel, 
    		LocalDate dataInicio, LocalDate dataFim) {
        this.destino = destino;
        this.preco = preco;
        this.usuario = null;
        this.dataFim = dataFim;
        this.dataInicio = dataInicio;
    }

    @Override
	public String toString() {
		return "PacoteViagem [destino=" + destino + ", preco=" + preco + ", usuario=" + usuario + ", dataInicio="
				+ dataInicio + ", dataFim=" + dataFim + "]";
	}

 // Implementação do método getDestino
    @Override
    public Destino getDestino() {
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

	public Usuario getUsuario() {
		return usuario;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	@Override
	public boolean isDisponivel() {
		if(this.usuario!=null) {
			return false;
		}
		else
			return true;
	}
}
