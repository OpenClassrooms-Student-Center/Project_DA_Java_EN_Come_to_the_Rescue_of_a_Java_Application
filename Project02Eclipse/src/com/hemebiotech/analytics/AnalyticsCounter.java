package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;


public class AnalyticsCounter {
	public static int headCount = 0;	// initialize to 0
	private static int rashCount = 0;		// initialize to 0
	private static int pupilCount = 0;		// initialize to 0
	
	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();
		
		
		
		int headCount = 0;	// counts headaches
		
		while (line != null) {
			
			System.out.println("symptom from file: " + line);
			
			 
			
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headache: " + headCount);
				
			}
			
			else if (line.equals("rash")) {
				rashCount++;
				System.out.println("number of rashs: "  + rashCount);
			}
			else if (line.equals("dialated pupils")) {
				pupilCount++;
				System.out.println("number of dialated pupils: "  + pupilCount);
			}
			 
			line = reader.readLine();// get another symptom
			 
			
		}
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		
		writer.write("dialated pupils: " + pupilCount + "\n");		
		writer.write("headache: " + headCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.close();
		reader.close();
	}
}