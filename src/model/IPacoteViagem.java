package model;

import exceptions.ReservaIndisponivelException;

public interface IPacoteViagem {
    IDestino getDestino();

    double getPreco();

    void setPreco(double preco);

    boolean isDisponivel();

    void reservar() throws ReservaIndisponivelException;
}