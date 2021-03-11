package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Simple brute force implementation
 *
 */
public class WriteResultDataInFile implements IResultWriter {

	private ArrayList<String> listOfResults;
	private String filepath;

	/**
	 * 
	 * @param filepath      a full or partial path to file containing list of
	 *                      results
	 * 
	 * @param listOfResults to write into Result.out file, one per line
	 *
	 */
	public WriteResultDataInFile(String filepath, ArrayList<String> listOfResults) {

		this.listOfResults = listOfResults;
		this.filepath = filepath;
	}

	@Override
	public void SetResults() {

		if (filepath != null) {
			try {

				Collections.sort(listOfResults);

				FileWriter writer = new FileWriter(filepath);

				int index = 0;
				while (index < listOfResults.size()) {
					writer.write(listOfResults.get(index) + "\n");
					index += 1;
				}
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
