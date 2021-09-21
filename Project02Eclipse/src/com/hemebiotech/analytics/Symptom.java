package com.hemebiotech.analytics;

/**
 * Symptom objects contain details of a specific symptom and the number of cases reported. 
 *
 * @version 21/9/2021
 */

public class Symptom {
	
	private String name;
	private int cases;
	
	/**
	* Constructor for Symptom class.
	* Creates a new Symptom and sets reported cases to 1
	* 
	* @param symptom the name of the symptom
	*/
	public Symptom (String symptom) {
		name = symptom;
		cases = 1;
	}
	
	/**
	* Add a new case of this symptom
	* 
	* @return <code>true</code> when a new case is successfully added 
	*/
	public boolean addCase() {
		cases++;
		return true;
	}
	
	/**
	* Getter method for the symptom name
	* 
	* @return the name stored for this Symptom object 
	*/
	public String getName() {
		return name;
	}
	
	/**
	* Getter method for the number of reported cases
	* 
	* @return the number of cases currently stored 
	*/
	public int getCases() {
		return cases;
	}

}
