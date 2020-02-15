package com.hemebiotech.analytics;

/**
 * 
 * @author MrgnCpn
 *
 */
public class AnalyticsCounter {
	
	/**
	 * Program who read list of symptoms in file and write then with their count in output file
	 * @param args
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception {
		ReadSymptomsDataFromFile symptomsFileReader = new ReadSymptomsDataFromFile("Project02Eclipse/symptoms.txt");
		WriteSymptomsDataToFile symptomsFileWriter = new WriteSymptomsDataToFile("Project02Eclipse/result.out");
		
		symptomsFileWriter.writeSymptoms(
				symptomsFileReader.sortSymptomsByValue(
						symptomsFileReader.GetSymptoms()
				),
		true, true);
	}
}