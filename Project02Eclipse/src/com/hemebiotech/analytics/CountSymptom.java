package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * La classe CountSymptom permet de récupérer une ArrayList et de l'intégrer dans une
 * HashMap, afin de recenser les occurences par ordre alphabétique.
 * @author fouziahajji
 */
public class CountSymptom {
	/** 
	 * Main class pour commencer le programme
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// Lis le fichier avec la class BufferedReader et return une ArrayList de String
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
		ArrayList<String> result = reader.GetSymptoms();

		//Compte les symptoms et les met dans une Map : valeur:symptoms/cle:nombre d'occurences
		Map<String, Integer> ListOccurences = CountSymptom.countSymptoms(result);

		//Ecrit la liste des symptomes triées sur un fichier
		WriteSymptomDataToFile writer = new WriteSymptomDataToFile("result.out", ListOccurences);
		writer.writeSymptoms();
		

	}




	/**
	 * @param result
	 * @return ListOccurences
	 * @throws IOException
	 */
	public static Map<String, Integer> countSymptoms(List<String> result) throws IOException {
		  
		 
		
		//Cette table de hashage contiendra les occurences des symptoms
		HashMap<String, Integer> ListOccurences = new HashMap<String, Integer>();
	  
	  
	    
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
	 
				//On affiche le résultat, c'est à dire les occurences des symptoms classés par ordre alphabétique.

	      		ListOccurences.entrySet().stream() 
	      		.sorted(Map.Entry.<String, Integer>comparingByKey() ) 
	      		.forEach(System.out::println);
		      
	      
	      
	      		return ListOccurences;
	  
		  
	    }
	  

}
