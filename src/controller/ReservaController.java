package controller;

import model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import exceptions.ReservaIndisponivelException;

public class ReservaController implements IReservaController{

	private static List<IReserva> reservas = new ArrayList<>();
	private static IPacoteController pacoteController = new PacoteController();
	private static IDestinoController destinoController = new DestinoController();
	private static IUsuarioController usuarioController = new UsuarioController();	

	public ReservaController() {
		IPacoteController pacoteController = new PacoteController();
		List<IPacoteViagem> listPacotes = pacoteController.listarPacotes();
		for(IPacoteViagem pacote:listPacotes) {
			if(pacote.getUsuario()!=null) {
				reservas.add(new Reserva(pacote.getUsuario(), pacote));
			}
		}
	}
	
	public static List<IReserva> getReservas() {
		return reservas;
	}
	 // Implementação do método reservar
    public void reservarPacote(IUsuario reservante, IPacoteViagem pacote) throws ReservaIndisponivelException {
    	try {
	        if (!pacote.isDisponivel()) {
	            throw new ReservaIndisponivelException("Pacote de viagem não está disponível para reserva.");
	        }else{
	        	Reserva reserva = new Reserva(reservante, pacote);	
	        	ReservaController.getReservas().add(reserva);
	        	
	        	pacote.setUsuario(reservante);
	        	pacoteController.removerPacote(pacote);
	        	pacoteController.adicionarPacote(pacote);
	        	
	        	System.out.println("Reserva de "+ pacote.toString()+ "para "+reservante.toString()+" realizada com sucesso!");
	        }
    	}
    	catch(ReservaIndisponivelException e){
    		System.err.println(e);
    	}
    }
	public static void setReservas(List<IReserva> reservas) {
		ReservaController.reservas = reservas;
	};
	
	@Override
	public List<IReserva> listarReservasUsuario(IUsuario usuario) {
		List<IReserva> reservasDoUsuario = new ArrayList<IReserva>();
		for(IReserva reserva : reservas) {
			if(reserva.getReservante().getEmail() == usuario.getEmail()) {
				reservasDoUsuario.add(reserva);
			}
		} 
		return reservasDoUsuario;
	}
}