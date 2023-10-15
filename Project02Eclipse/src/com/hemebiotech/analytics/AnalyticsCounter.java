package com.hemebiotech;

//package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int dialatedPupilsCount = 0;

	public static void main(String args[]) throws Exception {

		BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));
		String line = reader.readLine();

		int symptomsCount = 0;
		while (line != null) {

			symptomsCount++;
			System.out.println("symptom from file: " + line + "\n");
			
			if (line.equals("headache")) {
				headacheCount++;

			} else if (line.equals("rash")) {
				rashCount++;

			} else if (line.contains("dialated pupils")) {
				dialatedPupilsCount++;

			}

			line = reader.readLine(); // get another symptom
		}

		System.out.println("number of headaches: " + headacheCount + "\n");
		System.out.println("number of rash: " + rashCount + "\n");
		System.out.println("number of dialated pupils: " + dialatedPupilsCount + "\n");
		System.out.println("Number of symptoms in the file: " + symptomsCount + "\n");

		// next generate output
		FileWriter writer = new FileWriter("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + dialatedPupilsCount + "\n");
		writer.close();
	}
}
