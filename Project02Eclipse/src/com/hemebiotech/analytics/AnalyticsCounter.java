package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedHashMap;
import java.util.Map;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int dilatedCount = 0;

	// private static Logger logger = LogManager.getLogger(AnalyticsCounter.class);

	public static void main(String args[]) throws Exception {

		try (BufferedReader reader = new BufferedReader(new FileReader(
				"/Users/jon/dev/openclassrooms/java-project/Thermidor-Jonathan-debug-Java/Project02Eclipse/symptoms.txt"))) {
			String line = reader.readLine();

			while (line != null) {
				System.out.println("Symptom from file: " + line);
				if (line.equals("headache")) {
					headacheCount++;
					System.out.println("number of headaches: " + headacheCount);
				} else if (line.equals("rash")) {
					rashCount++;
					System.out.println("number of rash: " + rashCount);

				} else if (line.contains("dilated")) {
					dilatedCount++;
					System.out.println("number of dilated pupils: " + dilatedCount);
				}

				line = reader.readLine();
			}
		} catch (Exception e) {
			// logger.error("Impossible de lire le fichier.");
		}

		Map<String, Integer> symptoms = new LinkedHashMap<String, Integer>();
		symptoms.put("headache", headacheCount);
		symptoms.put("rash", rashCount);
		symptoms.put("dilated", dilatedCount);
		WriteSymptomDataToFile writer = new WriteSymptomDataToFile("result.out");
		writer.writeSymptoms(symptoms);
		// FileWriter writer = new FileWriter ("result.out");
		// writer.write("headache: " + headacheCount + "\n");
		// writer.write("rash: " + rashCount + "\n");
		// writer.write("dilated pupils: " + dilatedCount + "\n");
		// writer.close();
	}
}
