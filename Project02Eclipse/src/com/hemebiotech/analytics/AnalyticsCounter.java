package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class AnalyticsCounter {
	static final String inPutFile = "Project02Eclipse\\symptoms.txt";
	static final String outPutFile = "result.out";

	public static void main(String args[]) throws Exception {

		Analyse analyse = new Analyse(new ReadSymptomDataFromFile(inPutFile), new SymptomsDataProcessing(),
				new WriteSymptomsInFile(outPutFile));
		// read from symptoms.txt
		List<String> result = analyse.getSymptom();

		// count the number of occurrences
		Map<String, Integer> mapSymptomsCount = analyse.symtomsCounter(result);

		// sort symptoms alphabetically
		Map<String, Integer> mapSymptomsOrdered = analyse.sortedSymptoms(mapSymptomsCount, null);

		// write in result.out
		analyse.writeDataSymptoms(mapSymptomsOrdered);

	}
}
