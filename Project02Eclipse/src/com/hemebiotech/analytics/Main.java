package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String args[]) throws Exception {
		
		AnalyticsCounter counter = new AnalyticsCounter(); 

		List<String> symptoms = counter.read("symptoms.txt");
		Map<String, Integer> sorted = counter.sortAndCount(symptoms);
		counter.write(sorted, "output.txt");
	}
}
