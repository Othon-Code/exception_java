package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DomainException;

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
			System.out.print("Sa�da(CheckOut)(dd/mm/yyy): ");
			Date dataOut = sdf.parse(sc.next());

			Reserva reserv = new Reserva(num, dataIn, dataOut);
			System.out.println("Reserva bem conclu�da: " + reserv);

			System.out.println();
			System.out.println("Entre as datas para atualizar a reserva: ");

			System.out.print("Entrada(CheckIn)(dd/mm/yyy): ");
			dataIn = sdf.parse(sc.next());
			System.out.print("Sa�da(CheckOut)(dd/mm/yyy): ");
			dataOut = sdf.parse(sc.next());

			reserv.atualizaDatas(dataIn, dataOut);
			System.out.println("Reserva atualizada com sucesso: " + reserv);
		} catch (ParseException e) {
			System.out.println("Formato de data inv�lido!! ");
		} catch (DomainException e) {
			System.out.println("Erro na reserva. " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Error inesperado !!");
		}
		sc.close();

	}

}
