package com.personal.solution.lottery.business;

import java.util.List;

import com.personal.solution.lottery.model.data.DataPerNumber;
import com.personal.solution.lottery.model.data.Raffle;

public interface AnalysisOfDataInterface {

	/**
	 * @author Airy Fabian Rosales
	 * @Description You can check all number
	 * @return List of obj type DataPerNumber
	 * */
	public List<DataPerNumber> checkAllNumberPer(List<Raffle> raffles);

	/**
	 * @author Airy Fabian Rosales
	 * @Description you can filter by number of month or number of year
	 * @return List of obj type DataPerNumber
	 * */
	public List<DataPerNumber> filterNumberPerYoursClass(List<Raffle> raffles, int value);
	
	/**
	 * @author Airy Fabian Rosales
	 * @Description with method, I will change to parameter object to List of String 
	 * @return 
	 * */
	public List<String> createListString(List<DataPerNumber> datasPerNumbers);

	/**
	 * @author Airy Fabian Rosales
	 * @Description show in screem all the contect of the Object of DataPerNumber 
	 * @return 
	 * */
	public void showAllNumberPer(List<DataPerNumber> datasPerNumbers);

}
