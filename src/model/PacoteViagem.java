package model;

import exceptions.ReservaIndisponivelException;

public class PacoteViagem implements IPacoteViagem {
    private Destino destino;
    private double preco;
    private boolean disponivel;

    public PacoteViagem(Destino destino, double preco, boolean disponivel) {
        this.destino = destino;
        this.preco = preco;
        this.disponivel = disponivel;
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

    // Implementação do método isDisponivel
    @Override
    public boolean isDisponivel() {
        return disponivel;
    }

    // Implementação do método reservar
    @Override
    public void reservar() throws ReservaIndisponivelException {
        if (!disponivel) {
            throw new ReservaIndisponivelException("Pacote de viagem não está disponível para reserva.");
        }
        // Aqui você pode adicionar lógica adicional para o processo de reserva.
        // Por exemplo, atualizar o estado de disponibilidade do pacote.
        disponivel = false;
    }

    // Método toString para facilitar a visualização das informações do pacote
    @Override
    public String toString() {
        return "PacoteViagem{" +
                "destino=" + destino +
                ", preco=" + preco +
                ", disponivel=" + disponivel +
                '}';
    }
}
