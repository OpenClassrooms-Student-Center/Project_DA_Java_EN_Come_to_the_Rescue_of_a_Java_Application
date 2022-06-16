package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hemebiotech.interfaces.ICounter;

/**
 *
 * Cette classe sert à compter le nombre de personnes qui ont eu le même symptôme 
 */
public class SymptomCounter implements ICounter{
	

	public Map<String, Integer> SearchSymptomsAndCount(List<String> listSymptom) {
		
		
		/**
		 * 
		 * @param listSymptom
		 * @param list : l'Objet List contenant les symptômes.
		 * @return Un tableau associant le nom des symptômes et le nombre de personne qui l'ont eu
		 */
		
			Map<String, Integer> SymptomCount = new HashMap<String, Integer>();
			
			// Boucle améliorée pour traiter les lignes de la list ( fournie en paramètre ) une à une.
				for(String nameSymptom : listSymptom) {
					
					// On stock dans i le nombre de personnes ayant dejà eu le symptôme.
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
	
		
	
	
	
