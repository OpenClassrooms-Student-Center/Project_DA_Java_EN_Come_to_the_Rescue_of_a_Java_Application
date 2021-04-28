package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;

public class AnalyticsCounter {
	
//	private static int headacheCount = 0;	// initialize to 0
//	private static int rashCount = 0;		// initialize to 0
//	private static int pupilCount = 0;		// initialize to 0
		
	public static void main(String args[]) throws Exception {
		
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();
		String NewSymptomName = 
				line.trim()
				.substring(0, 1)
				.toUpperCase()+
				line.substring(1);
		System.out.println(NewSymptomName);
		
		
//		LinkedList <String> logSymptomes = new LinkedList<String>();
//		boolean iterator = true;
//				
//		while (iterator) {
//			line = reader.readLine();
//			logSymptomes.add(line);
//			Collections.sort(logSymptomes);
//			System.out.println(logSymptomes);
//			if (line.equals("")) {
//				iterator = false;
//			}
//		}
//		
		
		
		/**while (line != null) {
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headacheCount++;
				System.out.println("number of headaches: " + headacheCount);
			}
			else if (line.equals("rash")) {
				rashCount++;
			}
			else if (line.equals("pupils")) {
				pupilCount++;
			}**/

			
		
//		reader.close();
//		
//		// next generate output
//		FileWriter writer = new FileWriter ("result.out");
//		writer.write("headache: " + headacheCount + "\n");
//		writer.write("rash: " + rashCount + "\n");
//		writer.write("dialated pupils: " + pupilCount + "\n");
//		writer.close();
	}
}
