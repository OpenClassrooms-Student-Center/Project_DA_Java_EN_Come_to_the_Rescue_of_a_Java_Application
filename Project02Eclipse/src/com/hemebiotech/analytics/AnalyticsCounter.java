package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {
	// initializing specific counters for three symptoms to 0
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;

	// read data from file line by line and get analytics
	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();
		while (line != null) {
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) headacheCount++;
			else if (line.equals("rash")) rashCount++;
			else if (line.contains("pupils")) pupilCount++;
			line = reader.readLine();
		}
		reader.close();

		// generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}