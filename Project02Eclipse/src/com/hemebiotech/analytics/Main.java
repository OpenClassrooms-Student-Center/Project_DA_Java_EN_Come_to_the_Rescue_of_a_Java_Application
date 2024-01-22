package com.hemebiotech.analytics;
import java.util.Map;
import java.util.List;


public class Main {

	public static void main(String [] args)  {
		try {
			ISymptomReader reader = new ReadSymptomDataFromFile();//creating an instance of name reader 
			List <String>symptoms = reader.getSymptoms("/Users/mauriciolopez/Documents/Formation_Dev_salesforce/projets/p4 biomedics/lopez_mauricio_d_java/Project02Eclipse/symptoms.txt");

			SymptomCounter sCounter = new SymptomCounter();
			Map<String, Integer> stockSymptoms = sCounter.countSymptoms(symptoms);//Array which stck the result of stock symptoms

			SortSymptoms alphaSortSymptoms = new SortSymptoms();
			Map<String, Integer> sortAlphaSymptoms = alphaSortSymptoms.sortSymptoms(stockSymptoms);

			ISymptomWriter writer = new WriteSymptomDataToFile();
			writer.writeSymptoms (sortAlphaSymptoms,"result.out.txt");
		} catch (Exception e) { 
			System.err.println("Error : " + e.getMessage());
		}
	}
} 
