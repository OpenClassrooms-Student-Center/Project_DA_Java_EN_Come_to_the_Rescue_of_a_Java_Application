package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {

	public static void main(String args[]) throws Exception {
		BufferedReader reader = new BufferedReader (new FileReader("Project02Eclipse/symptoms.txt"));
		String line = reader.readLine();

		int i = 0;
		int headAcheCount = 0;
		int rashCount = 0;
		int dialatedPupilsCount = 0;

		while (line != null) {
			i++;	
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headAcheCount++;
				System.out.println("number of headaches: " + headAcheCount);
			}
			else if (line.equals("rash")) {
				rashCount++;
			}
			else if (line.contains("dialated pupils")) {
				dialatedPupilsCount++;
			}
			line = reader.readLine();
		}


		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headAcheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + dialatedPupilsCount + "\n");
		writer.close();
	}
}
