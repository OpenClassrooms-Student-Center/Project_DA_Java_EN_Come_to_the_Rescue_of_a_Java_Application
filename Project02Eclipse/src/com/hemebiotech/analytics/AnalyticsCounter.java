package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {
	private static int headacheCount = 0;	
	private static int rashCount = 0;		
	private static int pupilCount = 0;		
	
	public static void main(String args[]) throws Exception {
		// first get input
		try {
			BufferedReader reader = new BufferedReader (new FileReader("Project02Eclipse/src/com/hemebiotech/analytics/symptoms.txt"));
			String line = reader.readLine();

			while (line != null) {
				if (line.equals("headache")) {
					headacheCount++;
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
			// next generate output
			FileWriter writer = new FileWriter ("result.out");
			writer.write("headache: " + headacheCount + "\n");
			writer.write("rash: " + rashCount + "\n");
			writer.write("dialated pupils: " + pupilCount + "\n");
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
