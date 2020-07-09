package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class AnalyticsCounter {

	private static HashMap<String, Integer> elementCountMap;
	
	public static void main(String[] args) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		ArrayList<String> listOfLines = new ArrayList<>();

		String line = reader.readLine();
		while (line != null)
		{
			listOfLines.add(line);
			line = reader.readLine();
		}
		reader.close();

		ArrayElementCount arrayElementCount = new ArrayElementCount();
		elementCountMap = arrayElementCount.arrayElementCount(listOfLines);

		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write(String.valueOf(elementCountMap));
		writer.close();
	}
}
