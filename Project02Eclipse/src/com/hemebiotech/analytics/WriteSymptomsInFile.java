package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class WriteSymptomsInFile implements ISymptomWriter {
	

	@Override
	public void symptomsWriter(Map<String, Integer> symptoms, List<String> listeSymptoms)  {
		// TODO Auto-generated method stub
		FileWriter writer;
		try {
			writer = new FileWriter ("result.out");
	
		for (String symptom : listeSymptoms) {
			writer.write(symptom + "  " + symptoms.get(symptom) + "\r\n");
			
		}
		writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

}
