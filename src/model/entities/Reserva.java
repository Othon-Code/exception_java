package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

	private Integer numQuarto;
	private Date checkIn;
	private Date checkOut;
	

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reserva(Integer numQuarto, Date checkIn, Date checkOut) {
		this.numQuarto = numQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumQuarto() {
		return numQuarto;
	}

	public void setNumQuarto(Integer numQuarto) {
		this.numQuarto = numQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duracao() {
		long dif = checkOut.getTime() - checkIn.getTime(); // obtido a diferença das duas data em milissegundos
		return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
	}

	public String atualizaDatas(Date checkin, Date checkout) {
		Date now = new Date();

		if (checkIn.before(now) || checkOut.before(now)) {
			return "Erro nas reservas. As datas de reserva devem ser futuras.";
		} 
		if (!checkOut.after(checkIn)) {
			return "A data de ChecOut deve ser após a data de checkIn !!";

		}

		this.checkIn = checkin;
		this.checkOut = checkout;
		return null;
	}

	@Override
	public String toString() {

		return "Quarto " + numQuarto + ", ckeck-in: " + sdf.format(checkIn) + ", check-out: " + sdf.format(checkOut)
				+ ", " + duracao() + " noites";

	}

}
