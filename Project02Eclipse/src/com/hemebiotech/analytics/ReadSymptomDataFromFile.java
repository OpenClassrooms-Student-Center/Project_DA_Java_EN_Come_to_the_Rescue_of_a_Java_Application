package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.File;
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

	private File file;
	private List<String> list = new ArrayList<>();
	private Scanner read = new Scanner(System.in);
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	
	public ReadSymptomDataFromFile (){
		getFile();
	}
	/**
	 * Function permitting to get the symptoms from the file,
	 * put them in an ArrayList in an alphabetical order and return it. 
	 */
	@Override
	public List<String> GetSymptoms(){
		if (file != null) {
			try {
				FileReader filereader = new FileReader(file);
				BufferedReader reader = new BufferedReader (filereader);
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
		read.close();
		
		return this.list;
	}
	
	public void getFile() {
		boolean exists=false;
		file = new File(getFilePath());
		exists=file.exists();
		while(exists != true) {
			System.out.println("Attention!! File not found!");
			file = new File(getFilePath());
			exists=file.exists();
		}
	}
	
	public String getFilePath() {
		System.out.println("Please enter the full path to the file :");
		return read.nextLine();
		
	}
}

