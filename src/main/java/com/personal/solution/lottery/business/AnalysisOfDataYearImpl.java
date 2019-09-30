package com.personal.solution.lottery.business;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.personal.solution.lottery.model.data.DataPerNumber;
import com.personal.solution.lottery.model.data.Raffle;
/**
 * @author Airy Fabian Rosales.
 * @date September - 2019
 * */
public class AnalysisOfDataYearImpl implements AnalysisOfDataInterface {

	@Override
	public List<DataPerNumber> checkAllNumberPer(List<Raffle> raffles) {
		List<DataPerNumber> datasPerNumbers = new ArrayList<DataPerNumber>();

		Double total = (double) (raffles.size() * 6);

		raffles.forEach(raffle -> {

			int year = raffle.getDate().getYear();
			Month month = raffle.getDate().getMonth();

			raffle.getRaffleNumber().forEach(raffleNumber -> {

				List<DataPerNumber> dataPerNumber = datasPerNumbers.stream().filter(data -> data.getYear() == year
						&& data.getNumber() == raffleNumber.getNumber() && data.getMonths() == month)
						.collect(Collectors.toList());

				if (dataPerNumber == null || dataPerNumber.size() <= 0) {
					DataPerNumber dataPerNumberAux = new DataPerNumber();
					dataPerNumberAux.setYear(year);
					dataPerNumberAux.setMonths(month);
					dataPerNumberAux.setNumber(raffleNumber.getNumber());
					dataPerNumberAux.setPercentage(1 / total);
					dataPerNumberAux.setRepeated(new Double("1"));
					datasPerNumbers.add(dataPerNumberAux);
				} else {
					dataPerNumber.get(0).setRepeated(dataPerNumber.get(0).getRepeated() + 1);
					dataPerNumber.get(0).setPercentage(dataPerNumber.get(0).getRepeated() / total);
				}
			});
		});

		datasPerNumbers.sort((dpn1, dpn2) -> dpn1.getNumber().compareTo(dpn2.getNumber()));

		return datasPerNumbers;
	}

	@Override
	public void showAllNumberPer(List<DataPerNumber> datasPerNumbers) {
		System.out.println("Number,Year,Months,Percentage,Repeated");
		datasPerNumbers.forEach(dataPerNumber -> {
			System.out
					.println(dataPerNumber.getNumber() + "," + dataPerNumber.getYear() + "," + dataPerNumber.getMonths()
							+ "," + dataPerNumber.getPercentage() + "," + dataPerNumber.getRepeated());
		});
	}

	@Override
	public List<DataPerNumber> filterNumberPerYoursClass(List<Raffle> raffles, int year) {
		List<Raffle> rafflesThisYear = raffles.stream().filter(data -> data.getDate().getYear() == year)
				.collect(Collectors.toList());
		return this.checkAllNumberPer(rafflesThisYear);
	}

	@Override
	public List<String> createListString(List<DataPerNumber> datasPerNumbers) {
		List<String> response = new ArrayList<String>();
		response.add("Number,Year,Percentage,Repeated");
		datasPerNumbers.forEach(dataPerNumber -> {
			response.add(dataPerNumber.getNumber() + "," + dataPerNumber.getYear() + "," + dataPerNumber.getMonths()
					+ "," + dataPerNumber.getPercentage() + "," + dataPerNumber.getRepeated());
		});
		return response;
	}

}