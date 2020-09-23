package com.hemebiotech.analytics;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

	/***
 	* AnalyticsCounter hub all the method calls and the writer.
	 * Calls the reader and the TreeMap of ReadSymptomDataFromFile
 	* Write the result in a new file
 	*/
public class AnalyticsCounter {

	/**
	 *
	 * @throws IOException if no file is present for the reader
	 */

	public AnalyticsCounter() throws IOException {
	}

	public AnalyticsCounter (String args[]) throws Exception {

		//Calling the reader and TreeMap
		ReadSymptomDataFromFile read = new ReadSymptomDataFromFile("symptoms.txt");
		TreeMap<String, Integer> frequency = read.countSymptoms();


		//Creating a BufferedWriter to write into the ouput file
		BufferedWriter writer = new BufferedWriter(new FileWriter("result.out"));

		//Writing the sorted lines into the ouput file
		for (Map.Entry<String, Integer> lines  : frequency.entrySet() )
		{
			writer.write(String.valueOf(lines));
			writer.newLine();

		}
		//Closing the writer
		writer.close();
	}


		}





