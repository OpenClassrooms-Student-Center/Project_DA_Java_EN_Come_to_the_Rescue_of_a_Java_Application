package com.hemebiotech.analytics;

import java.util.List;
import java.io.IOException;
import java.io.*;
import java.util.Scanner;

/**
 * Anything that will read symptom data from a source
 * The important part is, the return value from the operation, which is a list of strings,
 * that may contain many duplications
 * 
 * The implementation does not need to order the list
 * 
 */
public interface ISymptomReader  {

		public static void main(String[] args)
		{
			try
			{
				// Read the input file
				FileInputStream file = new FileInputStream("Project02Eclipse/symptoms.txt");
				Scanner scanner = new Scanner(file);

				// Returns true as long as there are lines to read
				while(scanner.hasNextLine())
				{
					System.out.println("symptom from file: " + scanner.nextLine());
				}
				scanner.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	/**
	 * If no data is available, return an empty List
	 *
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
	 */

	List<String> GetSymptoms ();
}
