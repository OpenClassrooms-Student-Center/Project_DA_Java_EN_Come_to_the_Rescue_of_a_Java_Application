package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



/**
 *  Transformation de la liste des symptomes en List 
 *
 */
public class ReadSymptomDataFromFile{
	
	
	File file = new File ("Project02Eclipse/symptoms.txt");
	
		
	public List<String> GetSymptoms() {
	// Anciennement 
	//  ||
	//  \/
		ArrayList<String> result = new ArrayList<String>();  
		
		if (file != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(file));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
