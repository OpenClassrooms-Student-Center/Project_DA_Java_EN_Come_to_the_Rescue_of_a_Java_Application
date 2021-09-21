package com.hemebiotech.analytics;

import java.util.Comparator;

/**
 * SymptomNameSorted is an implementation of Comparator to allow us to compare Symptom names.
 * Compares the name variable of two Symptom objects alphabetically 
 *
 * @version 21/9/2021
 */
public class SymptomNameSorter implements Comparator<Symptom> {
	
	/**
	* Compare the name variable of two Symptom objects
	* 
	* @param sym1 the first Symptom object to be compared
	* @param sym2 the second Symptom object to be compared
	* @return a negative integer if sym1 is before sym2 alphabetically, a positive integer if sym1 is after sym2 
	*         will return zero if the Symptom objects have the same name variable
	*/
	public int compare(Symptom sym1, Symptom sym2) {
		// Get the name variables from the objects and compare, ignoring case
		return sym1.getName().compareToIgnoreCase(sym2.getName());
	}

}
