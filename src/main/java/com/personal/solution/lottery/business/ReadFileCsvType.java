package com.personal.solution.lottery.business;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Airy Fabian Rosales
 * @date Septiembre/2019
 * @description with this class, I can read and create file
 * */
public class ReadFileCsvType {

	/**
	 * @description with this method, I will read a file and return one list of String.
	 * */
	public List<String> readFile(String path) throws Exception {
		List<String> rows = new ArrayList<String>();
		Stream<String> lines = null;
		try {
			lines = Files.lines(Paths.get(path));
			lines.forEach(rowFile -> {
				rowFile = rowFile.replace(" ", "");
				if (rowFile != null && rowFile.trim().length() > 2) {
					rows.add(rowFile);
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception("We have a problem when we was reading the file");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("We have a problem unkown");
		} finally {
			if (lines != null) {
				lines.close();
			}
		}
		return rows;
	}

	/**
	 * @description with this method, I will create a file, you must sent the name of file and one list of String with content that you can charge. 
	 * */
	public void createFileCSV(String fileName, List<String> objectInString) {
		Charset utf8 = StandardCharsets.UTF_8;
		try {
			Files.write(Paths.get(fileName+".csv"), objectInString, utf8);
		} catch (IOException e) {
			System.out.println("When we were creating the file, we had an error.");
			e.printStackTrace();
		}
	}
}
