package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class CountSymptom {

	public static void main(String[] args) throws IOException {
		// Read the file with the util class & return List of String
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
		ArrayList<String> result = reader.GetSymptoms();

		//Count the symptoms and put them in a Map : values:symptoms/keys:number of appearance
		Map<String, Integer> ListOccurences = CountSymptom.countSymptoms(result);

		//Write the sorted symptoms in the output file
		WriteSymptomDataToFile writer = new WriteSymptomDataToFile("result.out", ListOccurences);
		writer.writeSymptoms();
		

	}




	public static Map<String, Integer> countSymptoms(List<String> result) throws IOException {
		  
		 
		
		//Cette table de hashage contiendra les occurences des symptoms
		Map<String, Integer> ListOccurences = new HashMap<String, Integer>();
	  
	  
	    
		//On itère sur le tableau des symptoms.
		for (int i = 0, c = result.size(); i< c; i++) {
	        //On récupère le symptom
			String symptom = result.get(i);
				//On regarde si le symptom est déjà présent dans la table d'occurence.
				if (ListOccurences.containsKey(symptom)) {
					//Le symptom est présent dans la table d'occurence, on incrémente l'occurence de 1.
					ListOccurences.put(symptom, ListOccurences.get(symptom) + 1);
				} else {
					//Le symptom n'est pas présent dans la table d'occurence, on insère la note dans la table et on met l'occurence à 1.   
					ListOccurences.put(symptom, 1);
				}
	    
	    
		} 
	 
				//On affiche le résultat, c'est à dire les occurences des symptoms.

	      		ListOccurences.entrySet().stream() 
	      		.sorted(Map.Entry.<String, Integer>comparingByKey() ) 
	      		.forEach(System.out::println);
		      
	      
	      
	      		return ListOccurences;
	  
		  
	    }
	  

}
