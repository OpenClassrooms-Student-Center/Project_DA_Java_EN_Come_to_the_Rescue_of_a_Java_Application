package com.hemebiotech.analytics;
import java.util.Map;
import java.util.List;

/**
 * The Main class serves as the entry point for the symptom data processing application.
 * It reads symptom data from a file, counts the occurrences of each symptom,
 * sorts the symptoms alphabetically, and writes the result to an output file.
 *
 * Usage:
 * - Ensure the file path is provided to the constructor of ReadSymptomDataFromFile.
 * - The processed data is written to an output file named "result.out.txt".
 *
 * @author Mauricio Lopez	
 * @version 1.0
 */
public class Main {

	/**
     * The main method to process symptom data.
     *
     * @param args Command line arguments (not used in this example).
     */

	public static void main(String [] args)  {
		try {
			// Read symptoms from a file
			ISymptomReader reader = new ReadSymptomDataFromFile();
			List <String>symptoms = reader.getSymptoms("/Users/mauriciolopez/Documents/Formation_Dev_salesforce/projets/p4 biomedics/lopez_mauricio_d_java/Project02Eclipse/symptoms.txt");
			
			// Count occurrences of each symptom
			SymptomCounter sCounter = new SymptomCounter();
			Map<String, Integer> stockSymptoms = sCounter.countSymptoms(symptoms);//Array which stck the result of stock symptoms

			// Sort symptoms alphabetically
			SortSymptoms alphaSortSymptoms = new SortSymptoms();
			Map<String, Integer> sortAlphaSymptoms = alphaSortSymptoms.sortSymptoms(stockSymptoms);

			// Write sorted symptoms to an output file
			ISymptomWriter writer = new WriteSymptomDataToFile();
			writer.writeSymptoms (sortAlphaSymptoms,"result.out.txt");
		} catch (Exception e) {
			// Handle exceptions and print error message 
			System.err.println("Error : " + e.getMessage());
		}
	}
} 
