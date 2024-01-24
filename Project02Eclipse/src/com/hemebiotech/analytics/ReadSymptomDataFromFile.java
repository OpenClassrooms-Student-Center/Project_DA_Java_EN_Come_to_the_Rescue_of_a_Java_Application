package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * The ReadSymptomDataFromFile class implements the ISymptomReader interface
 * to read symptom data from a file.
 *
 * Usage:
 * - Create an instance of ReadSymptomDataFromFile.
 * - Call the getSymptoms method, providing the file path as a parameter.
 * - The method returns a list of symptoms read from the specified file.
 *
 * @author Mauricio Lopez
 * @version 1.0
 * @see ISymptomReader
 */
public class ReadSymptomDataFromFile implements ISymptomReader {
	/**
     * Reads symptoms from a specified file and returns a list of symptoms.
     *
     * @param inputFile The path to the file containing symptom data.
     * @return A list of symptoms read from the file.
     * @see ISymptomReader#getSymptoms(String)
     */
	
	public List<String> getSymptoms(String inputFile) {
		
		List<String> symptoms = new ArrayList<>();
		
		
		try (BufferedReader reader = new BufferedReader (new FileReader(inputFile))){
			String line = reader.readLine();
			
			while (line != null) {
				symptoms.add(line.trim().toLowerCase());
				line=reader.readLine();
			}
		}catch(IOException e){
			// Handle exceptions and print error message
            System.err.println("error"+e.getMessage());
        } 
		
		return symptoms;
	}

}
