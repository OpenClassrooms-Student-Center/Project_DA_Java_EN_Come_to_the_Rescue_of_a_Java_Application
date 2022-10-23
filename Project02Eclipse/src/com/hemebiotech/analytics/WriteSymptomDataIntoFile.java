package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * Create a new file and write in
 *
 */

public class WriteSymptomDataIntoFile implements IWriteSymptom{

	@Override
	public void writeSymptom(Map<String, Long> mapSymptoms, String nomFichier) {
		// TODO Auto-generated method stub
		FileWriter newSymptomFile;
		try {
			// Create a new file
			newSymptomFile = new FileWriter(nomFichier, false);
			// Insert each symptom per line with its key + value
			for(Entry<String, Long> symptom : mapSymptoms.entrySet()) {
				newSymptomFile.write(symptom.getKey() + " : " + symptom.getValue() + "\n");
			}
			newSymptomFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
