package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;

	public static void main(String args[]) throws Exception {
		// Read the Symptoms.txt file
		BufferedReader reader = new BufferedReader(new FileReader("Project02Eclipse//symptoms.txt"));
		// Get the first input symptom
		String line = reader.readLine();

		while (line != null) {
			System.out.println("symptom from file: " + line);
			if (line.contains("headache")) {
				headacheCount += 1;
				System.out.println("number of headaches: " + headacheCount);
			} else if (line.contains("rash")) {
				rashCount += 1;
			} else if (line.contains("pupils")) {
				pupilCount += 1;
			}

			line = reader.readLine(); // Get another symptom
		}

		// Close the symptoms.txt file
		reader.close();

		// Write into result.out file
		FileWriter writer = new FileWriter("Project02Eclipse//result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}
