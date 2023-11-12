package model;

import exceptions.ReservaIndisponivelException;

public interface IUsuario {
    String getNome();

    String getEmail();

    void fazerReserva(IPacoteViagem pacote) throws ReservaIndisponivelException;
}