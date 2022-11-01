package com.hemebiotech.analytics;


import java.io.File;

import java.io.IOException;

import java.util.Map;

public interface IPrintResult {
	

	/*
	 * Creation of the CreateFile method, to get a new file and print the results in.
	 */
	public void createFile(Map<String, Integer> symptoms, File fileOut) throws IOException;

	
	
	
	
	
	
	
	

}
