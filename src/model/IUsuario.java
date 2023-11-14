package model;

import exceptions.ReservaIndisponivelException;

public interface IUsuario {
    String getNome();

    String getEmail();

    void fazerReserva(PacoteViagem pacote) throws ReservaIndisponivelException;
}