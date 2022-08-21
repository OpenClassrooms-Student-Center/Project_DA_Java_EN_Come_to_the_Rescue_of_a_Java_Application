package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class AnalyticsCounter {
	
	public static void main(String[] args) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader(new FileReader("/Users/fredbuono/Documents/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/symptoms.txt"));
		String line = reader.readLine();
		List<String> symptoms = new ArrayList<>();


		// read all symptoms and create list
		while (line != null) {
			symptoms.add(line);
			line = reader.readLine();
		}
		Map<String, Long> symptomsCount = symptoms.stream()
				.collect(Collectors.groupingByConcurrent(s -> s, Collectors.counting()))
				// sort by symptoms alphabetic
				.entrySet().stream()
				.sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(oldValue, newValue) -> oldValue, LinkedHashMap::new));

		// create output file
		FileWriter writer = new FileWriter("result.out");

		// write symptom and count
		symptomsCount.forEach((s, aLong) -> {
			try {
				writer.write(s + ": " + aLong + "\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

		writer.close();
	}
}
