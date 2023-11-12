package controller;

import model.IPacoteViagem;
import model.IUsuario;
import exceptions.ReservaIndisponivelException;

public class ReservaController {

    // Método para realizar uma reserva
    public void realizarReserva(IUsuario usuario, IPacoteViagem pacote) {
        try {
            usuario.fazerReserva(pacote);
            System.out.println("Reserva realizada com sucesso!");
        } catch (ReservaIndisponivelException e) {
            System.out.println("Erro ao realizar reserva: " + e.getMessage());
        }
    }
}
