package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;

	public static void main(String[] args) throws Exception {
		
		FileReader fileReader = new FileReader("Project02Eclipse/symptoms.txt"); 
		BufferedReader reader = new BufferedReader (fileReader);
		
		String line = reader.readLine();

		int i = 0;
		while (line != null) {
			i++; 
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headacheCount++;
				System.out.println("number of headaches: " + headacheCount);
			} else if (line.equals("rash")) {
				rashCount++;
				System.out.println("number of rash: " + rashCount);
			} else if (line.contains("pupils")) {
				pupilCount++;
				System.out.println("number of symptoms with pupils: " + pupilCount);
			}

			line = reader.readLine(); // get another symptom
		}

		reader.close();
		
		// next generate output
	
			
		FileWriter fileWriter = new FileWriter("Project02Eclipse/result.out.txt", true);
		BufferedWriter writer = new BufferedWriter (fileWriter);		
			
			try {
				
				writer.write("headache: " + headacheCount);
				writer.newLine();
				writer.write("dialated pupils: " + pupilCount);
			}
			
			catch(IOException  e) {
					
				e.printStackTrace();
			}
			
			writer.close();
			
	/** Le bloc au dessus devrait sûrement être une autre méthode */
		
	}
}
