//package com.hemebiotech.analytics;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.FileWriter;
//
//public class AnalyticsCounter {
//	private static int headacheCount = 0;	// initialize to 0
//	private static int rashCount = 0;		// initialize to 0
//	private static int pupilCount = 0;		// initialize to 0
//	
//	public static void main(String args[]) throws Exception {
//		// first get input
//		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
//		String line = reader.readLine();
//
//		int i = 0;	// set i to 0
//		int headCount = 0;	// counts headaches
//		while (line != null) {
//			i++;	// increment i
//			System.out.println("symptom from file: " + line);
//			if (line.equals("headache")) {
//				headCount++;
//				System.out.println("number of headaches: " + headCount);
//			}
//			else if (line.equals("rush")) {
//				rashCount++;
//			}
//			else if (line.contains("pupils")) {
//				pupilCount++;
//			}
//
//			line = reader.readLine();	// get another symptom
//		}
//		
//		// next generate output
//		FileWriter writer = new FileWriter ("result.out");
//		writer.write("headache: " + headacheCount + "\n");
//		writer.write("rash: " + rashCount + "\n");
//		writer.write("dialated pupils: " + pupilCount + "\n");
//		writer.close();
//	}
//}


package com.hemebiotech.analytics;


public class AnalyticsCounter {

	public static String filename = "symptoms.txt";// Déclaration du fichier texte à lire

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception// Une exception est levée grâce à l'instruct "throw"
	{
     SymptomesService symptomesService = new SymptomesService ();
     symptomesService.compterSymptomes(filename);
	}
}