package com.personal.solution.lottery.model.data;

import java.time.LocalDate;
import java.util.List;
/**
 * @author Airy Fabian Rosales.
 * @date September - 2019
 * */
public class Raffle {

	private String number;
	private LocalDate date;
	private List<RaffleNumber> raffleNumber;

	/**
	 * @param number
	 * @param date
	 * @param raffleNumber
	 */
	public Raffle(String number, LocalDate date, List<RaffleNumber> raffleNumber) {
		super();
		this.number = number;
		this.date = date;
		this.raffleNumber = raffleNumber;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public List<RaffleNumber> getRaffleNumber() {
		return raffleNumber;
	}

	public void setRaffleNumber(List<RaffleNumber> raffleNumber) {
		this.raffleNumber = raffleNumber;
	}

	@Override
	public String toString() {
		return "Raffle [number=" + number + ", date=" + date + ", raffleNumber=" + raffleNumber + "]";
	}

}