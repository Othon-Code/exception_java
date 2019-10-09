package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Programa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date agora = new Date();
		try {
			System.out.print("Numero quarto: ");
			int num = sc.nextInt();
			System.out.print("Entrada(CheckIn)(dd/mm/yyy): ");
			Date dataIn = sdf.parse(sc.next());
			System.out.print("Saída(CheckOut)(dd/mm/yyy): ");
			Date dataOut = sdf.parse(sc.next());

			Reserva reserv = new Reserva(num, dataIn, dataOut);
			System.out.println("Reserva: " + reserv);

			System.out.println();
			System.out.println("Entre as datas para atualizar a reserva: ");

			System.out.print("Entrada(CheckIn)(dd/mm/yyy): ");
			dataIn = sdf.parse(sc.next());
			System.out.print("Saída(CheckOut)(dd/mm/yyy): ");
			dataOut = sdf.parse(sc.next());

			reserv.atualizaDatas(dataIn, dataOut);
			System.out.println("Reserva: " + reserv);
		} catch (ParseException e) {
			System.out.println("Formato de data inválido!! ");
		} catch (IllegalArgumentException e) {
			System.out.println("Erro na reserva " + e.getMessage());
		}
		sc.close();

	}

}
