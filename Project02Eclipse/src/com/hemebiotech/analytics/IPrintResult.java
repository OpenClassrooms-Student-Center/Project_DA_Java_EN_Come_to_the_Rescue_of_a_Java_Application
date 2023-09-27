package com.hemebiotech.analytics;


import java.io.File;

import java.io.IOException;

import java.util.Map;

public interface IPrintResult {
	

	/*
	 * Creation of the createFile method, to get a new file with symptoms list and their occurrences
	 * and print the results in.
	 * 
	 * @param fileOut to create a new file
	 * @return a Map of symptoms list and their occurrences.
	 * @throws IOException if the file is not created correctly
	 */
	public void createFile(Map<String, Integer> symptoms, File fileOut) throws IOException;
	
}
