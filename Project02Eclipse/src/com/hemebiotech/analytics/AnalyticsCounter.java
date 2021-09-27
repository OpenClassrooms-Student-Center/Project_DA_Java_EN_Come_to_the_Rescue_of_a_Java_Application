package com.hemebiotech.analytics;

import java.io.IOException;

/**
 * @author didier
 */
public class AnalyticsCounter {

	public static void main(String[] args) throws IOException {

		/**
		 * Call of the FileWriterData class to write to the file: "results.out".
		 */
		FileWriterData finalResult = new FileWriterData();
		finalResult.writeSymptomsData();

	}

}