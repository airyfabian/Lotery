package com.personal.solution.lottery;

import java.util.List;

import com.personal.solution.lottery.business.AnalysisOfDataInterface;
import com.personal.solution.lottery.business.AnalysisOfDataMesImpl;
import com.personal.solution.lottery.business.AnalysisOfDataYearImpl;
import com.personal.solution.lottery.business.ReadAndCreateRaffle;
import com.personal.solution.lottery.business.ReadFileCsvType;
import com.personal.solution.lottery.model.data.DataPerNumber;
import com.personal.solution.lottery.model.data.Raffle;

/**
 * @author Airy Fabian Rosales
 * @description with this programme you can see how you can used java 8, to read and write in a file.
 * 				Additional, you can see the use of interface and lambda method.  
 * date Septiembre/2019
 */
public class App {

	public static void main(String[] args) {
    	if (args == null || args.length <= 0) {
			System.out.println("Please, To execute this programm you must send two parameter");
			return;
		}
		if (args.length != 1) {
			System.out.println("Sorry, the parameter's number is not correct. Try Again.");
			return;
		}
		try {
			ReadFileCsvType readFileCsvType = new ReadFileCsvType();
			List<String> rows = readFileCsvType.readFile(args[0]);
			List<Raffle> raffles = (new ReadAndCreateRaffle()).createListRaffles(rows);

			AnalysisOfDataInterface analysisOfDataMonth = new AnalysisOfDataMesImpl();
			List<DataPerNumber> datasPerNumbersMonths = analysisOfDataMonth.checkAllNumberPer(raffles);
			readFileCsvType.createFileCSV("SEPTEMBER", analysisOfDataMonth.createListString(analysisOfDataMonth.filterNumberPerYoursClass(raffles, 9)) );
			analysisOfDataMonth.showAllNumberPer(datasPerNumbersMonths);

			AnalysisOfDataInterface analysisOfDataYear = new AnalysisOfDataYearImpl();
			analysisOfDataYear.showAllNumberPer(analysisOfDataYear.checkAllNumberPer(raffles));
			readFileCsvType.createFileCSV("YEAR2019", analysisOfDataYear.createListString(analysisOfDataYear.filterNumberPerYoursClass(raffles, 2019)) );

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
