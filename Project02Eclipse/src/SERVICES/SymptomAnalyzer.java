package SERVICES;

import java.util.List;
import java.util.Map; // pas d'heritage de l'interface 

import Iclass.ISymptomAnalyzer;

import java.util.HashMap;

/**
 * Implémentation de l'interface.
 * 
 */
public class SymptomAnalyzer implements ISymptomAnalyzer {

  
    @Override 
    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> result = new HashMap<>();

        if (symptoms != null) {
            for (String symptom : symptoms) {// dans une boucle for veut dire pour chaque element dans 
            		symptom = symptom.trim().toLowerCase();
            	       if (!symptom.isEmpty()) { // isEmpty retourne un boolean (vrai ou faux) donc c'est pour ca qu'on le separe de trim qui retourne un string.
            			
            		result.put(symptom, result.getOrDefault(symptom, 0) + 1); // mise à jour du MAP
            		}
            	}
        	}
        return result;
    }
}
