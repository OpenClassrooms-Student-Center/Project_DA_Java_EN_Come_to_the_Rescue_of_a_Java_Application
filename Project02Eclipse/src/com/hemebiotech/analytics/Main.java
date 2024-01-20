package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;
import java.util.HashMap;
import java.util.List;


public class Main {

	public static void main(String [] args)  {
		try {
			ISymptomReader reader = new ReadSymptomDataFromFile();//creacion de una instancia de nombre reader 
			List <String>symptoms = reader.getSymptoms("/Users/mauriciolopez/Documents/Formation_Dev_salesforce/projets/p4 biomedics/lopez_mauricio_d_java/Project02Eclipse/symptoms.txt");

			SymptomCounter sCounter = new SymptomCounter();
			Map<String, Integer> stockSymptoms = sCounter.countSymptoms(symptoms);//Array qui stock the rsult of counSymptms

			ISymptomWriter writer = new WriteSymptomDataToFile();
			writer.writeSymptoms (stockSymptoms,"resultsSypmtoms.txt");
		} catch (Exception e) { 
			System.err.println("Error : " + e.getMessage());
		}
	}
}
