package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomsFromFile implements ISymptomReader {

	
	
	@Override
	public List<String> GetSymptoms() {
		
		ArrayList<String> namesOfSymptoms = new ArrayList<>();
		
		try {
				BufferedReader reader = new BufferedReader (new FileReader("Project02Eclipse\\symptoms.txt"));
				String line = reader.readLine();
				
				
				while (line != null) {
					namesOfSymptoms.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		
		return namesOfSymptoms;
	}

}
