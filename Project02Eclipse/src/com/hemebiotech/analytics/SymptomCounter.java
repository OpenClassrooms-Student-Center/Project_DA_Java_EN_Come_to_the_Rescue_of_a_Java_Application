package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;

import com.hemebiotech.interfaces.ICounter;

/**
 *
 * Cette classe sert à compter le nombre de personnes qui ont eu le même symptôme 
 */
public class SymptomCounter implements ICounter{

	/**
	 * 
	 * @param listSymptom : la List que ReadSymptomDataFromFile.java retourne
	 * @return Un tableau ordonné, associant le nom des symptômes et le nombre de personne qui l'ont eu
	 */
	public TreeMap<String, Integer> SearchSymptomsAndCount(List<String> listSymptom) {
		
		TreeMap<String, Integer> SymptomCount = new TreeMap<String, Integer>();
		
		// Boucle améliorée pour traiter les lignes de la List ( fournie en paramètre ) une à une.
			for(String nameSymptom : listSymptom) {
				
				// On stock dans i le nombre de personnes ayant déjà eu le symptôme.
				Integer i = SymptomCount.get(nameSymptom);
				// Si la clé n'a pas encore de valeur, on l'initialise à 1
				if ( i == null) {
					SymptomCount.put(nameSymptom, 1);
				// Sinon, on ajoute 1 au nombre de personne ayant déjà eu le symptôme
				} else {
					SymptomCount.put(nameSymptom, i + 1);
				}
			
			}
		
		return SymptomCount;
		
	}

}
	
		
	
	
	
