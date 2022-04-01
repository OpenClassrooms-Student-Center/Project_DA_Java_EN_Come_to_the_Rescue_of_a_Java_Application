package com.hemebiotech.analytics;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Application {
 
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		String filepath;
		List<String> symptoms= new ArrayList<>();
		System.out.println("Please enter the file path of the text file :  ");
		filepath = read.nextLine();
		read.close();
		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile(filepath,symptoms);
		readSymptomDataFromFile.GetSymptoms();
		
		
		
		
		

	}

}
