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

		System.out.print("Numero quarto: ");
		int num = sc.nextInt();
		System.out.print("Entrada(CheckIn)(dd/mm/yyy): ");
		Date dataIn = sdf.parse(sc.next());
		System.out.print("Saída(CheckOut)(dd/mm/yyy): ");
		Date dataOut = sdf.parse(sc.next());

		if (!dataOut.after(dataIn)) {
			System.out.println("Error ao reservar. Data de CheckOut deve ser depois da data de CheckIn");

		} else {
			Reserva reserv = new Reserva(null, dataIn, dataOut);
			System.out.println("Reserva: " + reserv);
			
			System.out.println();
			System.out.println("Entre as datas para atualizar a reserva: ");
			
			System.out.print("Entrada(CheckIn)(dd/mm/yyy): ");
			dataIn = sdf.parse(sc.next());
			System.out.print("Saída(CheckOut)(dd/mm/yyy): ");
			dataOut = sdf.parse(sc.next());
			 Date agora = new Date();
			 
			 
			if(dataIn.before(agora) || dataOut.before(agora)) {
				System.out.println("Erro nas reservas. As datas de reserva devem ser futuras.");
			}
			else if(!dataOut.after(agora)) {
				System.out.println("Erro nas reservas. A data de checkOut deve ser após a data de check-in.");
								
			}else {
			reserv.atualizaDatas(dataIn, dataOut);
			System.out.println("Reserva: " + reserv);
			}
		}

		sc.close();

	}

}
