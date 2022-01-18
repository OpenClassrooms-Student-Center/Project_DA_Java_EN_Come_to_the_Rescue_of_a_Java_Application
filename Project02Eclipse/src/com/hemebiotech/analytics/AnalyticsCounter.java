package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class AnalyticsCounter {
	/**
	 * @Function: main
	 * @Description: count the number of symptoms
	 * @param: $1: input symptoms file (format : symptom)
	 *         $2: output result file (format: symptom : number)
	 */
	public static void main(String args[]) throws Exception {

		// validate input parameter
		if (args.length == 2) {
			System.out.println("Info: input symptoms file: " + args[0]);
			System.out.println("Info: output result file: " + args[1]);
		} else {
			System.out.println("Error: Verify the input parameter.");
			System.exit(1);
		}

		// Read File
		List<String> listSymptoms = null;
		try {
			ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile(args[0]);
			listSymptoms = readSymptomDataFromFile.GetSymptoms();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(2);
		}

		// analyze symptoms: count
		Map<String, Integer> countSymptoms = null;
		AnalyzeSymptoms analyzeSymptoms = new AnalyzeSymptoms();
		countSymptoms = analyzeSymptoms.countSymptoms(listSymptoms);

		// generate result
		try {
			WriteSymptomDataToFile writeSymptomDataToFile = new WriteSymptomDataToFile(args[1]);
			writeSymptomDataToFile.WriteCountSymptoms(countSymptoms);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(3);
		}

		// output status
		System.out.println("Info: Job finish");

	}
}