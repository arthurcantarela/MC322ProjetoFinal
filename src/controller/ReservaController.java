package controller;

import model.Reserva;
import java.util.ArrayList;
import java.util.List;

public class ReservaController {
	private static List<Reserva> reservas = new ArrayList<>();

	public static List<Reserva> getReservas() {
		return reservas;
	}

	public static void setReservas(List<Reserva> reservas) {
		ReservaController.reservas = reservas;
	};
    
	public static void printReservas() {
		System.out.println("Reservas realizadas:");
		for(Reserva reserva : reservas) {
			System.out.println(reserva.toString());
		}
	}
}
