package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/*
 * IPrintResult interface implementation 
 */
public class PrintResult implements IPrintResult{

	/*
	 * Creation of the CreateFile method, to get a new file and print the results in.
	 * @throws IOException if the file is not created correctly
	 */
	public void createFile(Map<String, Integer> symptoms, File fileOut) throws IOException {
		

		/*
		 * Get a list of symptoms and occurrences , and connected the key and value together with entrySet
		 */
		for (Map.Entry<String, Integer> mapentry : symptoms.entrySet()) 
		{
			System.out.println("le symptome est : "+mapentry.getKey()
					+ " au total de : " + mapentry.getValue());	
		}

		/*
		 * Create a new file to send the results of symptoms occurrences in.
		 */
		try {
		BufferedWriter results = new BufferedWriter(new FileWriter(fileOut)); 
		
				for (Map.Entry<String, Integer> mapentry : symptoms.entrySet() ) {
					results.write(mapentry.getKey() + " : " + mapentry.getValue() + System.getProperty("line.separator"));		
					
				}
				results.close();
	
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Cause : " + e.getCause());
			System.out.println("Message : " + e.getMessage());
			
		}
	/* 
	 * print a sentence to informe the developer about the creation of the file when he launch the program
	 * Give the filepath to the developer
	 */
		
		System.out.println("The file " + fileOut + " has been created");
		System.out.println("filepath: " + fileOut.getAbsolutePath());
		
		}	
			
}

		


	
	
	

