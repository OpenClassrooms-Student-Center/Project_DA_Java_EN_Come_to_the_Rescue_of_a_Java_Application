package com.hemebiotech.interfaces;

import java.util.List;
import java.util.TreeMap;

/**
 * 
 * Comptage et triage des symptômes
 *
 */
public interface ICounter {
	
	/**
	 * 
	 * @param liste des symptômes dans une List<String>
	 * @return Un tableau classé par ordre croissant, associant le nom des symptômes et le nombre de personne qui l'ont eu
	 */
	public TreeMap<String, Integer> SearchSymptomsAndCount(List<String> list);
		

}
