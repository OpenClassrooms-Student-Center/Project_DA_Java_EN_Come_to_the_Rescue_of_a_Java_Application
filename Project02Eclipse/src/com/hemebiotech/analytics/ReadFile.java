package com.hemebiotech.analytics;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile  {
	public  List<String> readFile(String fileName) throws FileNotFoundException {
	 
		//Create file input and Scanner
	File file = new File(fileName);
	
	Scanner in = new Scanner(file);
	List<String> symptomsList = new ArrayList<String>(); 
	// Read through file and find lines
	while(in.hasNextLine()) {
		String line = in.nextLine();
		System.out.println(line);
		symptomsList.add(line);
	}
	    //Close
		in.close();
		return symptomsList;
	}
	
}


