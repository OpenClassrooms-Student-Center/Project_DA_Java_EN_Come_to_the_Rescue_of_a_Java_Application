package com.hemebiotech.analytics;

import java.util.List;

public class AnalyticsCounter {

	public static void main(String args[]) throws Exception {
		
		ReadSymptomDataFromFile readerOk = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		List<String> listFromFile = readerOk.getSymptoms();
		
		CountAndOrderSymptoms counter = new CountAndOrderSymptoms();
		counter.processData(listFromFile);
		
	}



	
}


