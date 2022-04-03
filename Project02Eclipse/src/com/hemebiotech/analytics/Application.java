package com.hemebiotech.analytics;

import java.util.Scanner;

public class Application {
 
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		String filepath;
		System.out.println("Please enter the file path of the text file :  ");
		filepath = "/Users/quentincaracatzanis/Documents/GitHub/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/symptoms.txt";
		read.close();
		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile(filepath);
		readSymptomDataFromFile.GetSymptoms();
		readSymptomDataFromFile.getSymptomsOccurences();
		readSymptomDataFromFile.printSymptoms();
	}

}
