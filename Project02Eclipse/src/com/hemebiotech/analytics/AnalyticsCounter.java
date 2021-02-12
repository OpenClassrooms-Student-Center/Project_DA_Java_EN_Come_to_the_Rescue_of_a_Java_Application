package com.hemebiotech.analytics;

import java.io.IOException;

/** @
 *
 * @author E.Jurquet
 * 
 * Main Class of the Program AnalyticsCounter. as well as a TreeMap method.
 * @version 1.1
 *
 */
public class AnalyticsCounter  {
	/**
	Instantiate methods from other classes.
	 */
	public void analyseTheData ()  {

		SymptomsCount symptomscount2 = new SymptomsCount();
		symptomscount2.listAndCountSymptoms();
	}

	/**
	 * Program Start
	 * @param args
	 * @throws IOException
	 *
	 *  This is the main start of the program.
	 *  Instantiate the Analytics class and use the analysis method.
	 */
	public static void main  ( String[] args )throws IOException {

		AnalyticsCounter analytics = new AnalyticsCounter () ;


		analytics.analyseTheData();
	}
}

/**
 * private static int headacheCount = 0;	// initialize to 0
	private static int rashCount = 0;		// initialize to 0
	private static int pupilCount = 0;		// initialize to 0

	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		int i = 0;	// set i to 0
		int headCount = 0;	// counts headaches
		while (line != null) {
			i++;	// increment i
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rush")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}

		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}*/
