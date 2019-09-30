package com.personal.solution.lottery.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 * @author Airy Fabian Rosales.
 * @date September - 2019
 * */
public class Utils {

	public static LocalDate ConverStringToLocalDate(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		return LocalDate.parse(date, formatter);
	}
}
