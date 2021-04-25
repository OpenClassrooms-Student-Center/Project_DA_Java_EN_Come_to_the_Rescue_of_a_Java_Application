package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter{
	private static int headacheCount = 0;	
	private static int rashCount = 0;		
	private static int pupilCount = 0;

		
	public static void getThatLine(String lineGet, int count){
		if (lineGet.equals("headache")) {
			System.out.println("Réussite");
			count++;
		} else {
			System.out.println("échec");
		}
		
	}
	
	public static void main(String args[]) throws Exception {
		// first get input
				BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
				String line = reader.readLine();
				
		while (line != null) {
			if (line.equals("headache")) {
				headacheCount++;
				System.out.println("number of headaches: " + headacheCount);
			}
			else if (line.equals("rash")) {
				rashCount++;
				System.out.println("number of rashes: " + rashCount);
			}
			else if (line.equals("dialated pupils")) {
				pupilCount++;
				System.out.println("number of pupil counts: " + pupilCount);
			}

			line = reader.readLine();	// get another symptom
		}
		getThatLine("headache", headacheCount);
		
		
		reader.close();		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
			writer.close();
	}
}
