package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;

	public static void main(String[] args) {
		// first get input
		BufferedReader reader = null;
		File file = new File("symptoms.txt");
		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			System.err.printf("The file %s was not found.", file.toString());
			System.exit(-1);
		}

		String line = null;
		try {
			line = reader.readLine();
			while (line != null) {
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
		} catch (IOException e) {
			System.err.printf("The file %s cannot be read.", file.toString());
			System.exit(-1);
		}
		try {
			reader.close();
		} catch (IOException e1) {
			System.err.printf("The file %s cannot be closed.", file.toString());
			System.exit(-1);
		} /*
			 * catch (NullPointerException e) {
			 * System.err.printf("Impossible to open the file %s.", file.toString());
			 * System.exit(-1); }
			 */

		// next generate output
		BufferedWriter writer = null;
		File file2 = new File("result.out");
		try {
			writer = new BufferedWriter(new FileWriter(file2));
			writer.write("headache: " + headacheCount);
			writer.newLine();
			writer.write("rash: " + rashCount);
			writer.newLine();
			writer.write("pupils: " + pupilCount);
		} catch (IOException e) {
			System.err.printf("Impossible to write in the file %s.", file2.toString());
			System.exit(-1);
		}
		try {
			writer.close();
		} catch (IOException e) {
			System.err.printf("The file %s cannot be closed.", file2.toString());
			System.exit(-1);
		}
	}
}
