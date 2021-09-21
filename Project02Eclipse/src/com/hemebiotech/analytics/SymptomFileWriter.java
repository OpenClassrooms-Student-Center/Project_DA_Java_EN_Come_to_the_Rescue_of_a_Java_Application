package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;

/**
 * SymptomFileWriter is used to write the data stored in a SymptomList object to a text file.
 * The output file will contain an alphabetically organised list of symptoms with the number of cases reported.
 *
 * @version 21/9/2021
 */

public class SymptomFileWriter {
	
	/**
	* Constructor for SymptomFileWriter class.
	*/
	
	public SymptomFileWriter() {
	}
	
	/**
	* Output the contents of a supplied SymptomList file to a file with the provided name.
	* <p>
	* Will create a new file automatically if it does not currently exist, or overwrite if file is already present.
	* Output file contain an alphabetically organised list of symptoms with the number of cases reported.
	* 
	* @param outputFilename the name of the file to be written to
	* @param symptomList the collection of Symptoms to be output
	* @return <code>true</code> when file has been created <code>false</code>if file could not be created
	*/
	
	public boolean writeSymptomsToFile(String outputFilename, SymptomList symptomList) {
		
		try {
			//Create a FileWriter for the provided filename
			FileWriter writer = new FileWriter (outputFilename);
			
			//Attempt to sort the SymptomList alphabetically
			if(!symptomList.sortSymptoms()) {
				//If the provided SymptomList does not contain any Symptoms, close writer and return false
				writer.close();
				return false;
			}
			
			//Get the ArrayList of Symptoms from the SymptomList
			//Iterate through and write each Symptom and number of occurrences to the file
			for (int i = 0; i < symptomList.getSymptoms().size(); i++) {
				writer.write(symptomList.getSymptoms().get(i).getName() + " = " + symptomList.getSymptoms().get(i).getCases() + "\n");
			}
			
			//Close writer once finished
			writer.close();

		}
		catch (IOException e) {
			//Catch any IO errors that may occur
			System.err.println("IO Error: " + e);
			return false;
		}
		
		
		return true;		
	}

}
