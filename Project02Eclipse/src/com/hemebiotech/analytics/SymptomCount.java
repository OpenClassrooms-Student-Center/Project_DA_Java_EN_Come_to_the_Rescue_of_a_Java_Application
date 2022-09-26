/**
 * 
 */
package com.hemebiotech.analytics;

/**
 * The class SymptomCount encapsulates a Symptom object and the number of
 * occurences of the symptom
 * 
 * @author trimok
 *
 */
public class SymptomCount {
	/**
	 * The Symptom object (encapsulating the name)
	 */
	private Symptom symptom;
	/**
	 * The number of occurrences for the symptom
	 */
	private int count;

	/**
	 * @param symptom : the symptom object
	 * @param count   : the number of occurrences for the symptom
	 */
	public SymptomCount(Symptom symptom, Integer count) {
		this.symptom = symptom;
		this.count = count;
	}

	@Override
	public String toString() {
		return String.format("%-20s : %4d", symptom.toString(), count);
	}
}
