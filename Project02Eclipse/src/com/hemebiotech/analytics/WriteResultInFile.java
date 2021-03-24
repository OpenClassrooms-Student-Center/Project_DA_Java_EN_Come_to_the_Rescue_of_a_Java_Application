package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteResultInFile implements ResultWriter{

	@Override
	public void WriteResult(List<String> result) throws IOException {
		FileWriter myWriter = new FileWriter("result.out");
		
		for (int i = 0; i < result.size(); i++) {
			String symptomLine = result.get(i);
			myWriter.write("Symptom -> " + symptomLine);
		}
		myWriter.close();
	}

}
