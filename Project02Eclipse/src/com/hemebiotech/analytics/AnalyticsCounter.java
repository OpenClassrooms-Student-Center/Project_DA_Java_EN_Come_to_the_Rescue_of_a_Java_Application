package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;

	public static void main(String args[]) throws Exception {
		// Reading line by line from the file symptoms.txt.
		BufferedReader reader = new BufferedReader(new FileReader("Project02Eclipse/symptoms.txt"));
		String line = reader.readLine();

		// For each line encountered, increment the corresponding symptom by 1.
		while (line != null) {
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headacheCount++;
			} else if (line.equals("rash")) {
				rashCount++;
			} else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine(); // get another symptom
		}
		reader.close(); // close the reader

		// next generate output with the list of symptoms and the number of times they
		// have been encountered.
		FileWriter writer = new FileWriter("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}
