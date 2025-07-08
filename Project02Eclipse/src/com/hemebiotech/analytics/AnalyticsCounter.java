package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int dilatedCount = 0;

	ISymptomReader reader;
	ISymptomWriter writer;

	// private static Logger logger = LogManager.getLogger(AnalyticsCounter.class);

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}

	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> count = new LinkedHashMap<String, Integer>();
		for (String symptom : symptoms) {
			count.put(symptom, count.getOrDefault(symptom, 0) + 1);
		}
		for (Map.Entry<String, Integer> entry : count.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue() + " times.");
		}
		return count;
	}

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		return symptoms;
	}

	public void writeSymptoms(Map<String, Integer> symptoms) throws IOException {
		writer.writeSymptoms(symptoms);
	}

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
