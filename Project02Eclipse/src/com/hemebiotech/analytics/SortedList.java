package com.hemebiotech.analytics;

public class SortedList {
	private final String mySymptoms;
	private int countSymptoms;
	
	public sortedList(String symptoms, int countSymptoms) {
		this.mySymptoms=symptoms;
		this.countSymptoms=countSymptoms;
	}
	public String getAllSymptoms() {
		return mySymptoms;
	}
	public int getCountSymptoms() {
		return countSymptoms;
	}
	
}
