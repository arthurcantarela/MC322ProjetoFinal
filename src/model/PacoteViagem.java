package model;

import java.time.LocalDate;

import controller.ReservaController;
import exceptions.ReservaIndisponivelException;

public class PacoteViagem implements IPacoteViagem {
    private Destino destino;
    private double preco;
    private boolean disponivel;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public PacoteViagem(Destino destino, double preco, boolean disponivel, LocalDate dataInicio,
    		LocalDate dataFim) {
        this.destino = destino;
        this.preco = preco;
        this.disponivel = disponivel;
        this.dataFim = dataFim;
        this.dataInicio = dataInicio;   
    }

    // Implementação do método reservar
    @Override
    public void fazerReserva(UsuarioBase reservante) throws ReservaIndisponivelException {
    	try {
	        if (!this.disponivel) {
	            throw new ReservaIndisponivelException("Pacote de viagem não está disponível para reserva.");
	        }else{
	        	Reserva reserva = new Reserva(reservante, this);	
	        	ReservaController.getReservas().add(reserva);
	        	this.disponivel = false;
	        	System.out.println("Reserva de "+ this.toString()+ "para "+reservante.toString()+" realizada com sucesso!");
	        }
    	}
    	catch(ReservaIndisponivelException e){
    		System.err.println(e);
    	}
    }
 
    @Override
	public String toString() {
		return "PacoteViagem [destino=" + destino + ", preco=" + preco + ", disponivel=" + disponivel + ", dataInicio="
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

    // Implementação do método isDisponivel
    @Override
    public boolean isDisponivel() {
        return disponivel;
    }
}
