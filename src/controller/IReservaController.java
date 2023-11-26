package controller;

import exceptions.ReservaIndisponivelException;
import model.*;

public interface IReservaController {
	public void reservarPacote(IUsuario reservante, IPacoteViagem pacote) throws ReservaIndisponivelException ;
}
