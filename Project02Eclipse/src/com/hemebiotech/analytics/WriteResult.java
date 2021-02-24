package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteResult {
	
	FileWriter myWriter = new FileWriter("result.out");
	
	public WriteResult(List<String> result) throws IOException {
			
		for (int i = 0; i < result.size(); i++) {
			String symptomLine = result.get(i);
			myWriter.write(symptomLine);
		}
		myWriter.close();
	}
}
