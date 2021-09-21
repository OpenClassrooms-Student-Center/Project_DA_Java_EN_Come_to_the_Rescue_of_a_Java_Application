package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * SymptomFileReader is used to read a text file containing a list of symptoms
 * and generate a SymptomList object containing a collection of Symptom objects
 * to collect the data found in the file.
 *
 * @version 21/9/2021
 */

public class SymptomFileReader {
	
	/**
	* Constructor for SymptomFileReader class.
	*/
	public SymptomFileReader() {
	}
	
	/**
	* Read a list of symptoms from a text file and create a SymptomList object from this data
	* 
	* 
	* @param filename the name of the file to be read
	* @return SymptomList object containing Symptom objects based on the supplied file
	*/
	public SymptomList readSymptomsFromFile(String filename) {
		
		SymptomList symptomList = new SymptomList();
		
		
		try {
			//Create a BufferedReader for the input filename
			BufferedReader reader = new BufferedReader (new FileReader(filename));
			String line = reader.readLine();
			
			//Iterate through each line of the file
			//Add each line as a new Symptom
			//SymptomList object will automatically create Symptom objects or increase counts as appropriate
			while (line != null) {	
				symptomList.addSymptom(line);
				line = reader.readLine();	
			}	
			//Close BufferedReader once finished
			reader.close();
			}
		catch (FileNotFoundException e) {
			//Catch cases where symptoms file is not in the expected location
			System.err.println("File not found: symptoms.txt");
		}
		catch (IOException e) {
			//Catch any other IO errors
			System.err.println("IO Error: " + e);
		}
		
		return symptomList;
	}

}
