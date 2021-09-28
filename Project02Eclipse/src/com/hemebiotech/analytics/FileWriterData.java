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

public class FileWriterData implements IFileWriterData {

	public void writeSymptomsData(TreeMap<String, Integer> symptomsCompte) throws IOException {
		try {

			FileWriter mywriter = new FileWriter("results.out");

			for (Map.Entry<String, Integer> entry : symptomsCompte.entrySet())
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
