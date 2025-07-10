package com.hemebiotech.analytics;

import java.io.IOException;


public class Main {

	public static void main(String[] args) throws IOException {
		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
		ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
		AnalyticsCounter analysis = new AnalyticsCounter(reader, writer);

		// analysis.getSymptoms();
		// analysis.countSymptoms(analysis.getSymptoms());
		// analysis.sortSymptoms(analysis.countSymptoms(analysis.getSymptoms()));
		 writer.writeSymptoms(analysis.sortSymptoms(analysis.countSymptoms(analysis.getSymptoms())));
	}
}
