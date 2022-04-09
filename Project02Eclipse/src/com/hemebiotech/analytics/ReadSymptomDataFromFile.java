package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	private List<String> list = new ArrayList<>();
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public String getFilepath() {
		return filepath;
	}
	public ReadSymptomDataFromFile (){
		Scanner read = new Scanner(System.in);
		System.out.println("Please enter the file name of the text file if in the directory"
				+ " or enter the full path to the file: ");
		this.filepath=read.nextLine();
		read.close();
	}
	/**
	 * Function permitting to get the symptoms from the file,
	 * put them in an ArrayList in an alphabetical order and return it. 
	 */
	@Override
	public List<String> GetSymptoms() {
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					this.list.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Collections.sort(this.list);
		
		return this.list;
	}
}
