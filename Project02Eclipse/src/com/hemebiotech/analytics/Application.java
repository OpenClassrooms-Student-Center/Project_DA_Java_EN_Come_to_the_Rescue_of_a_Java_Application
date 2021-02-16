package com.hemebiotech.analytics;

public class Application {
	public static void main(String args[]) throws Exception {
		AnalyticsCounter counter = new AnalyticsCounter("symptoms.txt", "result.out");
		counter.readSymptoms();
		counter.saveSymptoms();
	}

}
