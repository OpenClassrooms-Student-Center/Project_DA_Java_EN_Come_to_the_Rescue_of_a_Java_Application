package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * to be filled later structure of javadoc
 * 
 * 
 */
public class AnalyticsCounter {
	/**
	 * to be filled later structure of javadoc produce what we want
	 * 
	 * @args blabla
	 */
	private static int headacheCount = 0; // to record the number of headache
	private static int rashCount = 0; // to record the number of rash
	private static int pupilCount = 0; // to record the number of pupil

	public static void main(String args[]) throws Exception {
		/**
		 * to be filled later structure of javadoc 
		 * produce what we want
		 * main steps: 1) read file (result: list of String) ; 2) 
		 * 
		 * @args blabla
		 */

		BufferedReader reader = new BufferedReader(new FileReader("Project02Eclipse/symptoms.txt"));
		String line = reader.readLine(); // first read line

		int i = 0; // counter for the lines of the file
		while (line != null) {
			i++;
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headacheCount++;
				System.out.println("number of headaches: " + headacheCount);
			} else if (line.equals("rash")) {
				rashCount++;
			} else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine(); // get another symptom
		}

		// generate output
		FileWriter writer = new FileWriter("Project02Eclipse/result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}
