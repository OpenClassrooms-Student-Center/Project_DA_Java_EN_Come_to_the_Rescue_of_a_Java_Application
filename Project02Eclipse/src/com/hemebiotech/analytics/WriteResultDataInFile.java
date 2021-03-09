package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Simple brute force implementation
 *
 */
public class WriteResultDataInFile implements IResultWriter {

	private List<String> listOfResults;
	private String filepath;

	/**
	 * 
	 * @param filepath      a full or partial path to file containing list of
	 *                      results
	 * 
	 * @param listOfResults to write into Result.out file, one per line
	 *
	 */
	public WriteResultDataInFile(String filepath, List<String> listOfResults) {

		this.listOfResults = listOfResults;
		this.filepath = filepath;
	}

	@Override
	public void SetResults() {

		if (filepath != null) {
			try {
				FileWriter writer = new FileWriter(filepath);
				int index = 0;
				while (listOfResults.get(index) != null) {
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
