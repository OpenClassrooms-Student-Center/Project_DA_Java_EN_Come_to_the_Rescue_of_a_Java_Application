package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * Will write the results of TreeMap to the "results.out" file
 * 
 * @author didier
 *
 */

public class FileWriterData {

	public void writeSymptomsData() throws IOException {
		try {

			FileWriter mywriter = new FileWriter("results.out");

			ExtracSymptomData consoleOutput = new ExtracSymptomData();
			TreeMap<String, Integer> symptoms = consoleOutput.extracSymptomsData();
			for (Map.Entry<String, Integer> entry : symptoms.entrySet())
				mywriter.write("- " + entry.getKey() + ": " + entry.getValue() + "\n");
			mywriter.close();
			/**
			 * @throws IOException
			 */
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

}
