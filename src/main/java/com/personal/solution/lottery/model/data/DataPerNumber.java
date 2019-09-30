package com.personal.solution.lottery.model.data;

import java.time.Month;

/**
 * @author Airy Fabian Rosales.
 * @date September - 2019
 * */
public class DataPerNumber {

	private Integer number;
	private Double repeated;
	private Double percentage;
	private Month months;
	private int year;

	/**
	 * 
	 */
	public DataPerNumber() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param number
	 * @param repeated
	 * @param percentage
	 * @param months
	 */
	public DataPerNumber(Integer number, Double repeated, Double percentage, Month months) {
		super();
		this.number = number;
		this.repeated = repeated;
		this.percentage = percentage;
		this.months = months;
	}

	/**
	 * @param number
	 * @param repeated
	 * @param percentage
	 * @param year
	 */
	public DataPerNumber(Integer number, Double repeated, Double percentage, int year) {
		super();
		this.number = number;
		this.repeated = repeated;
		this.percentage = percentage;
		this.setYear(year);
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Double getRepeated() {
		return repeated;
	}

	public void setRepeated(Double repeated) {
		this.repeated = repeated;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	public Month getMonths() {
		return months;
	}

	public void setMonths(Month months) {
		this.months = months;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}