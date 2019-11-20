package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {
// suppression private qui n'avait pas d'intérêt ici
	
	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();
		reader.close();
		
		// suppression de i qui est inutile
		int headCount = 0;	// counts headaches
		int rashCount = 0; // oubli variable counts rush
		int pupilCount = 0; // oubli variable counts pupils
		
		
		while (line != null) {
			// suppression i++ incrementation non necessaire
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rush")) {
				rashCount ++;
				System.out.println("number of rush" + rashCount); // oubli
			}
			else if (line.contains("pupils")) {
				pupilCount ++;
				System.out.println("number of pupilCount" + pupilCount); // oubli
			}
			
			line = reader.readLine();	// get another symptome
			

		}

		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headCount + "\n"); // erreur headaches au lieu de head
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}
