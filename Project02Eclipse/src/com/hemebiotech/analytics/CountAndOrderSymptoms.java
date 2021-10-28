package com.hemebiotech.analytics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CountAndOrderSymptoms implements ISymptomCounter {

	
	public Map<String, Integer> processData(List<String> listNotCounted) 
	{
		List<String> lines = null;
		try {
			lines = Files.readAllLines(Paths.get("Project02Eclipse/symptoms.txt"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		TreeMap<String, Integer> compteurs = new TreeMap<>();
		for(String line : lines) {
		 
			if ( compteurs.containsKey(line) ) { 
				// si la ligne contient déjà la ligne, on incrémente le compteur qui est associé
		                compteurs.put(line, compteurs.get(line)+1);
		        }
		        else {
			       // sinon on ajoute l'association en initialisant le compteur à 1
			       compteurs.put(line, 1);
			       
			       StringBuffer sb = new StringBuffer();
			       sb.append( line ) ;
			       for(String line1 : lines) {
			    	    System.out.println(line1);
			    	}

			       
			       System.out.print(compteurs);
			       
			       
			      
		        }
		 
		}
       
		// une méthode qui permet de récupérer chaque symptom avec son nombre d'occurence
		
		return null;
	}

}