package com.personal.solution.lottery.model.data;
/**
 * @author Airy Fabian Rosales.
 * @date September - 2019
 * */
public class RaffleNumber {

	private Integer number;
	private Integer position;

	/**
	 * @param number
	 * @param position
	 */
	public RaffleNumber(Integer number, Integer position) {
		super();
		this.number = number;
		this.position = position;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "RaffleNumber [number=" + number + ", position=" + position + "]";
	}

}