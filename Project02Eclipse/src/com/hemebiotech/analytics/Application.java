package com.hemebiotech.analytics;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Application {
	private Map<String,Integer> uniqueSymptoms = new Map<>();
	private List<String> symptoms = new ArrayList<>();
	
 
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		String filepath;
		System.out.println("Please enter the file path of the text file :  ");
		filepath = "/Users/quentincaracatzanis/Documents/GitHub/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/symptoms.txt";
		read.close();
		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile(filepath);
		symptoms=readSymptomDataFromFile.GetSymptoms(symptoms);
		uniqueSymptoms=readSymptomDataFromFile.getSymptomsOccurences(symptoms);
		readSymptomDataFromFile.printSymptoms(uniqueSymptoms);
		
	}

}
