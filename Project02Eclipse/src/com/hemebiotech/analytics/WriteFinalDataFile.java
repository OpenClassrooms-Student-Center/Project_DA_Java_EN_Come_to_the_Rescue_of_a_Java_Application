package com.hemebiotech.analytics;

import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * @since 16/02/2022
 * @author  DOLLOU Y.
 * this class allows you to write the results.out File 
 * 
 */

public class WriteFinalDataFile implements IWriteFinalDataFile {

	private String filepath;

	public WriteFinalDataFile(String filepath) {

		this.filepath = filepath;
	}
@Override
/**
 * @param map
 * @throws exception
 */
	public void writeData(Map<String, Integer> map) throws IOException {

		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filepath));

		try {

			for (Map.Entry<String, Integer> entry : map.entrySet()) {

				bufferedWriter.write(entry.getKey() + " : " + entry.getValue());
				bufferedWriter.newLine();

			}

		} catch (IOException e) {

			e.printStackTrace();
		} finally {

			bufferedWriter.close();
		}

	}

	
	}


