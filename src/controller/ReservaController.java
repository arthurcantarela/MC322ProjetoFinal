package controller;

import model.PacoteViagem;
import model.Reserva;
import model.Usuario;

import java.util.ArrayList;
import java.util.List;

import exceptions.ReservaIndisponivelException;

public class ReservaController {
	private static List<Reserva> reservas = new ArrayList<>();

	public static List<Reserva> getReservas() {
		return reservas;
	}
	 // Implementação do método reservar
    public static void ReservarPacote(Usuario reservante, PacoteViagem pacote) throws ReservaIndisponivelException {
    	try {
	        if (!pacote.isDisponivel()) {
	            throw new ReservaIndisponivelException("Pacote de viagem não está disponível para reserva.");
	        }else{
	        	Reserva reserva = new Reserva(reservante, pacote);	
	        	ReservaController.getReservas().add(reserva);
	        	pacote.setUsuario(reservante);
	        	System.out.println("Reserva de "+ pacote.toString()+ "para "+reservante.toString()+" realizada com sucesso!");
	        }
    	}
    	catch(ReservaIndisponivelException e){
    		System.err.println(e);
    	}
    }
 
	
	public static void setReservas(List<Reserva> reservas) {
		ReservaController.reservas = reservas;
	};

}