package view;

import java.util.List;
import java.util.Scanner;

import controller.*;
import model.*;


public interface IDestinoView {

	public abstract IDestino visualizarDestinosDisponiveis(DestinoController destinoController, PacoteController pacoteController, Scanner scanner);
}
