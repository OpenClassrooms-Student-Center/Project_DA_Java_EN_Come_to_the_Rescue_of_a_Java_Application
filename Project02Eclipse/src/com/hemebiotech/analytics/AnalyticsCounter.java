package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AnalyticsCounter {
	private static int headacheCount = 0;	
	private static int rashCount = 0;		
	private static int dilatedPupilCount = 0;		
	
	public static void main(String args[]) throws Exception {
		
		try (// import list of symptoms from a file
		BufferedReader reader = new BufferedReader (new FileReader(".\\Project02Eclipse\\symptoms.txt"))) {
			String line = reader.readLine();

			while (line != null) {
				System.out.println("symptom from file: " + line); //print each symptom read from file to console
				
				if (line.equals("headache")) { //searches for the "headache" symptom and increments the headacheCount variable by 1 
					headacheCount++;
					System.out.println("Number of headaches: " + headacheCount);
				}
				else if (line.equals("rash")) { //searches for the "rash" symptom and increments the rashCount variable by 1
					rashCount++;
					System.out.println("Number of rashes: " + rashCount);
					
				}
				else if (line.equals("dilated pupils")) { //searches for the "dilated pupil" symptom and increments the dilatedPupilCount variable by 1
					dilatedPupilCount++;
					System.out.println("Number of dilated pupils: " + dilatedPupilCount);
				}

				line = reader.readLine();	// move onto the next line from the imported file
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		// generates an output file that will display count totals for each of the three symptoms found in the above WHILE loop code
		FileWriter writer = null; //creates an object of type FileWriter to be used in the creation of a file
		try {
		writer = new FileWriter (".\\Project02Eclipse\\result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dilated pupils: " + dilatedPupilCount + "\n");
		
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			writer.close();
		}
	}
	
}