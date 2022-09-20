/**
 * 
 */
package com.hemebiotech.analytics;

/**
 * The class Symptom has only one attribute : name
 * 
 * @author trimok
 *
 */
public class Symptom implements Comparable<Symptom> {
	/**
	 * The name of the symptom
	 */
	private String name;

	/**
	 * @param name : the name of the symptom
	 */
	public Symptom(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(Symptom o) {
		return this.name.compareTo(o.getName());
	}

	/**
	 * @return the name of the symptom
	 */
	public String getName() {
		return name;
	}

}
