package com.personal.solution.lottery.business;

import java.util.ArrayList;
import java.util.List;

import com.personal.solution.lottery.model.data.Raffle;
import com.personal.solution.lottery.model.data.RaffleNumber;
import com.personal.solution.lottery.utils.Constant;
import com.personal.solution.lottery.utils.Utils;
/**
 * @author Airy Fabian Rosales.
 * @date September - 2019
 * */
public class ReadAndCreateRaffle {

	/**
	 * @description I will create the list of raffles and you must send the rows
	 * */
	public List<Raffle> createListRaffles(List<String> rows) {
		List<Raffle> raffles = new ArrayList<Raffle>();
		rows.forEach(row -> {
			String[] fields = row.split(Constant.SEPARATOR);
			List<RaffleNumber> raffleNumbers = new ArrayList<RaffleNumber>();
			for (Integer i = 2; i <= 8; i++) {
				raffleNumbers.add(new RaffleNumber(Integer.parseInt(fields[i]), i - 1 ));
			}
			raffleNumbers.sort((rn1, rn2) -> rn1.getNumber().compareTo(rn2.getNumber()));
			raffles.add(new Raffle(fields[1], Utils.ConverStringToLocalDate(fields[10]), raffleNumbers));
		});
		return raffles;
	}
}
