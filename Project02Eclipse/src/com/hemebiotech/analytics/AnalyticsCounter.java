package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Starting point of the application
 */
public class AnalyticsCounter {

	private static final String path = "Project02Eclipse/resources";
	private static final String fileName = "symptoms.txt";
	private static final String filePath = path + "/" + fileName;

	/**
	 * Principal method, this method will call the others methods
	 * @param args
	 */
	public static void main(String[] args) {

		//1 - Read the file of symptoms (symptoms.txt)
		IFileManagement fileManagement = new FileManagement(filePath);
		List<String> symptomsList = fileManagement.getSymptoms();

		//2 - Sort the symptoms by number of occurence / then by alphbetic number
		Map<String, Long> occurenceBySymptoms = fileManagement.countAndSortSymptoms(symptomsList);

		//3 - Generate the report with the symptoms and their occurence written
		fileManagement.generateSymptomsReport(occurenceBySymptoms);

	}
}
