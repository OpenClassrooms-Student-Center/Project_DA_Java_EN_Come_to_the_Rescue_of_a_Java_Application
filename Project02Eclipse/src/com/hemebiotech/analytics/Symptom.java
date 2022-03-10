package com.hemebiotech.analytics;

/**
 * Class to record symptoms and their number of occurrences
 * attributes: name (Sting), count (int)
 * methods: no method
 *
 */
public class Symptom {
	public int count;
	public String name;

	public Symptom(String name) {
		this.count = 1;
		this.name = name;
	}
}
