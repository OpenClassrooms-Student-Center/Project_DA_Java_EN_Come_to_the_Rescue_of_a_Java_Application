/**

 * Project Analytics
 * Frequency count of undesirable effects (symptoms) of patients testing drugs of Heme Biotech registered in a text file,
 * where one line represents one occurrence
 * @version: 0.2 2024-01-25
 * @authors: Pablo Miranda, Alex OpenClassRooms, Caroline OpenClassRooms
 */

package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

//TO FIX - Globally change the program structure to make it OOP
public class AnalyticsCounter {
	// TO FIX - All variables to be reorganised in a more scalable solution applying OOP
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;
	
	public static void main(String args[]) throws Exception {
		//TO FIX - First get txt file input, a class needed here
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		//TO FIX - Reader Symptom Class to be developed
		int i = 0;
		int headCount = 0;
		while (line != null) {
			i++;
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount); //TO FIX, no need to console output, only a file is required
			}
			else if (line.equals("rush")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// get another symptom from the text file, a class to do so
		}
		
		// TO FIX - To build an interface for this subroutine (WRITER)
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}
