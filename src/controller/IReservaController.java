package controller;

import java.util.List;

import exceptions.ReservaIndisponivelException;
import model.*;

public interface IReservaController {
	public void reservarPacote(IUsuario reservante, IPacoteViagem pacote) throws ReservaIndisponivelException ;
	public List<IReserva> listarReservasUsuario(IUsuario usuario);
	
}
