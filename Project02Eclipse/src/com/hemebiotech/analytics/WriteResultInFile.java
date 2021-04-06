package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class WriteResultInFile implements IResultWriter{
	
	private String pathOutput;
	
	public WriteResultInFile (String pathOutput) {
		this.pathOutput = pathOutput;
	}

	@Override
	public void WriteResult(Map<String, Integer> result) throws IOException {
		
		AddToList addToList = new AddToList();
		List<String> castResult = addToList.addInList(result);
		FileWriter myWriter = new FileWriter(pathOutput);
		
		for (int i = 0; i < castResult.size(); i++) {
			String symptomLine = castResult.get(i);
			myWriter.write("Symptom : " + symptomLine);
		}
		myWriter.close();
	}

}
