package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date agora = new Date();

		System.out.print("Numero quarto: ");
		int num = sc.nextInt();
		System.out.print("Entrada(CheckIn)(dd/mm/yyy): ");
		Date dataIn = sdf.parse(sc.next());
		System.out.print("Saída(CheckOut)(dd/mm/yyy): ");
		Date dataOut = sdf.parse(sc.next());

		if (dataIn.before(agora)) {
			System.out.println("Erro !! A data de checkIn de ver atual ou futura");
		} else if (!dataOut.after(dataIn)) {

			System.out.println("Error ao reservar. Data de CheckOut deve ser depois da data de CheckIn");

		} else {
			Reserva reserv = new Reserva(num, dataIn, dataOut);
			System.out.println("Reserva: " + reserv);

			System.out.println();
			System.out.println("Entre as datas para atualizar a reserva: ");

			System.out.print("Entrada(CheckIn)(dd/mm/yyy): ");
			dataIn = sdf.parse(sc.next());
			System.out.print("Saída(CheckOut)(dd/mm/yyy): ");
			dataOut = sdf.parse(sc.next());

			String error = reserv.atualizaDatas(dataIn, dataOut);
			if (error != null) {
				System.out.println("Erro na reserva !!: " + error);
			} else {

				System.out.println("Reserva: " + reserv);
			}
		}

		sc.close();

	}

}
