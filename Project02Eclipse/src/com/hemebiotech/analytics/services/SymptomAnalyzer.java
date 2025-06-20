package com.hemebiotech.analytics.services;

import java.util.List;
import java.util.Map; // pas d'heritage de l'interface 
import java.util.TreeMap;

import com.hemebiotech.analytics.interfaces.ISymptomAnalyzer;

import java.util.HashMap;

/**
 * Implémentation de l'interface.
 * 
 */
public class SymptomAnalyzer implements ISymptomAnalyzer {

  
    @Override 
    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> result = new TreeMap<>();
        if (symptoms != null) 
        
        
            for (String symptom : symptoms) {// dans une boucle for veut dire pour chaque element dans 
            		symptom = symptom.trim().toLowerCase();
            	       
            		result.put(symptom, result.getOrDefault(symptom, 0) + 1); // mise à jour du MAP
            		}
            	        	
        return result;
    }
}
