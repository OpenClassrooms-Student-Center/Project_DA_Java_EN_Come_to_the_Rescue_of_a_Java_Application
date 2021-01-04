package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AnalyticsCounter {
	private static int headacheCount = 0;	// initialize to 0
	private static int rashCount = 0;		// initialize to 0
	private static int pupilCount = 0;		// initialize to 0

	public static void main(String[] args)  {
		// first get input
		try {
			BufferedReader reader = new BufferedReader (new FileReader("Project02Eclipse/symptoms.txt"));
			String line = reader.readLine();

			while (line != null) {
				System.out.println("symptom from file: " + line);
				if (line.equals("headache")) {
					headacheCount++;
					System.out.println("number of headaches: " + headacheCount);
				}
				else if (line.equals("rash")) {
					rashCount++;
				}
				else if (line.contains("pupils")) {
					pupilCount++;
				}

				line = reader.readLine();	// get another symptom
			}
			reader.close();
		}
		catch (IOException e) {
			System.out.println("The specified file cannot be read. Please verify its existence and its location.");
		}

		// next generate output
		try {
			FileWriter writer = new FileWriter ("result.out");
			writer.write("headache: " + headacheCount + "\n");
			writer.write("rash: " + rashCount + "\n");
			writer.write("dilated pupils: " + pupilCount + "\n");
			writer.close();
		}
		catch (IOException e) {
			System.out.println("Impossible to create the file result.out or to write inside.");
		}
	}
}
