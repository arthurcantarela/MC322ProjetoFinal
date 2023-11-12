package controller;

import model.PacoteViagem;
import model.Usuario;
import exceptions.ReservaIndisponivelException;

public class ReservaController {

    // Método para realizar uma reserva
    public void realizarReserva(Usuario usuario, PacoteViagem pacote) {
        try {
            usuario.fazerReserva(pacote);
            System.out.println("Reserva realizada com sucesso!");
            throw new ReservaIndisponivelException("Reserva indisponível");
        } catch (ReservaIndisponivelException e) {
            System.out.println("Erro ao realizar reserva: " + e.getMessage());
        }
    }
}
