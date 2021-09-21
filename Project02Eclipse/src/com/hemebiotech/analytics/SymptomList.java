package com.hemebiotech.analytics;

import java.util.ArrayList;

/**
 * SymptomList contains Symptom objects and allows operations to be performed on them. 
 * <p>
 * The current version allows new Symptoms to be added, occurrences to be increased, and the collection to be sorted.
 *
 * @version 21/9/2021
 */

public class SymptomList {
	
	private ArrayList<Symptom> symptoms;
	
	/**
	* Constructor for SymptomList class.
	* Creates a new Symptoms ArrayList to hold collection
	*/
	public SymptomList() {
		symptoms = new ArrayList<Symptom>();
	}
	
	/**
	* Add a Symptom to the collection.
	* 
	* @param symptom the Symptom object to be added to the collection
	* @return <code>true</code> if a new symptom is added, <false> if an existing symptom increased occurrences
	*/
	public boolean addSymptom(Symptom symptom) {
		// If the collection has no Symptoms yet, we can immediately add this new one
		if (symptoms.isEmpty()) {
			symptoms.add(symptom);
			return true;
		}
		// If the collection is not empty, try to add a count to an existing symptom
		if (!addExisting(symptom)) {
			// If that attempt returns false the symptom is new, add it to the collection
			symptoms.add(symptom);
			return true;
		}
		return false;
	}
	/**
	* Add a Symptom to the collection.
	* Additional method to allow symptoms to be added via name rather than object reference if required.
	* 
	* @param symptom the name of the symptom to be added to the collection
	* @return <code>true</code> if a new symptom is added, <false> if an existing symptom increased occurrences
	*/
	public boolean addSymptom(String symptom) {
		// If the collection has no Symptoms yet, we can immediately add this new one
		if (symptoms.isEmpty()) {
			symptoms.add(new Symptom(symptom));
			return true;
		}
		// If the collection is not empty, try to add a count to an existing symptom
		if (!addExisting(symptom)) {
			// If that attempt returns false the symptom is new, add it to the collection
			symptoms.add(new Symptom(symptom));
			return true;
		}
		return false;
	}
	
	// Internal method to add a count to an existing Symptom within the collection
	// @param symptom the Symptom object to be added to the collection
	// @return true if we are able to find this symptom in the collection and increase the count
	//         false if we are not able to locate, and the symptom will need to be added
	private boolean addExisting(Symptom symptom) {
		// Iterate through collection to locate matching Symptom object
		for (int i = 0; i < symptoms.size(); i++) {
			// If we locate a matching Symptom, add an occurrence and return true
			if (symptoms.get(i).getName().equals(symptom.getName())) {
				symptoms.get(i).addCase();
				return true;
			}
		}
		// If we did not locate a matching Symptom, return false
		return false;
	}
	// Internal method to add a count to an existing Symptom within the collection
	// @param symptom the name of a symptom to be added to the collection
	// @return true if we are able to find this symptom in the collection and increase the count
	//         false if we are not able to locate, and the symptom will need to be added
	private boolean addExisting(String symptom) {
		// Iterate through collection to locate matching Symptom object
		for (int i = 0; i < symptoms.size(); i++) {
			// If we locate a matching Symptom, add an occurrence and return true
			if (symptoms.get(i).getName().equals(symptom)) {
				symptoms.get(i).addCase();
				return true;
			}
		}
		// If we did not locate a matching Symptom, return false
		return false;
	}
	
	/**
	* Sort the Symptom objects currently in the collection alphabetically.
	* Symptom objects are sorted by their name variable.
	* 
	* @return <code>true</code> when the collection has been sorted, <false> if the collection is empty
	*/
	public boolean sortSymptoms() {
		if (symptoms.isEmpty()) {
			return false;
		}
		else {
			symptoms.sort(new SymptomNameSorter());
			return true;
		}
	}
	
	/**
	* Getter method for the Symptoms collection.
	* 
	* @return the ArrayList object containing the collection of Symptom objects
	*/
	public ArrayList<Symptom> getSymptoms() {
		// For future versions it may be preferable to return a clone of the ArrayList to prevent changes to be made from outside the class
		return symptoms;
	}

}
