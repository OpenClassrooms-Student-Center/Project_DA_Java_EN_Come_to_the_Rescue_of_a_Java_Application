package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteInFile implements WriteResult{
	
	FileWriter myWriter = new FileWriter("result.out");
	
	public WriteInFile(List<String> result) throws IOException {
			
		for (int i = 0; i < result.size(); i++) {
			String symptomLine = result.get(i);
			myWriter.write("Symptom = " + symptomLine);
		}
		myWriter.close();
	}
}
