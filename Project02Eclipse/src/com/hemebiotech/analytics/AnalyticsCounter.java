package com.hemebiotech.analytics;

/**
 * AnalyticsCounter runs through the process of sorting a list of symptom occurrences. 
 * <p>
 * The current version of this class include inputFilename and outputFilename variables pre-set.
 * This can be adjusted in future versions to take these from the input arguments.
 *
 * @version 21/9/2021
 */
public class AnalyticsCounter {

	
	/**
	 * The main method takes any appropriate arguments (none currently required) and runs through
	 * the process of reading in the input file, processing the data, and writing to the output file
	 */
	public static void main(String args[]) {
		
		SymptomList symptomList;
		String inputFilename = "symptoms.txt";
		String outputFilename = "result.out";

		//Read input from file into SymptomList object by creating and using a SymptomFileReader object
		symptomList = (new SymptomFileReader().readSymptomsFromFile(inputFilename));
			
		
		//Write output to file from SymptomList object by using a SymptomFileWriter object
		SymptomFileWriter fileWriter = new SymptomFileWriter();
		fileWriter.writeSymptomsToFile(outputFilename, symptomList);
				
		
	}
}
