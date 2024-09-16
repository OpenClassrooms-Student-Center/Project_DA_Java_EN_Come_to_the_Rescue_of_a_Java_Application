package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class WriteSymptomDataToFile implements ISymptomWriter {

	@Override
	public void writeSymptoms(Map<String, Integer> symptoms)  {
		
		FileWriter filesympt = null;
		BufferedWriter buffsympt =null;

		try {
			filesympt = new FileWriter ("results.out", false);
			buffsympt = new BufferedWriter (filesympt);
			for (Entry<String, Integer> results : symptoms.entrySet()) {

				String key = results.getKey();
				Integer value = results.getValue();
				String line = key +" :"+value +"\n";
				buffsympt.write(line);
			}

		}catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if (buffsympt != null) {
				try {
					buffsympt.close();
				}catch (IOException e) {
					e.printStackTrace();
				}
				try {
					filesympt.close();
				}catch (IOException e) {
					e.printStackTrace();
				}
			}
		}	
	}	
}