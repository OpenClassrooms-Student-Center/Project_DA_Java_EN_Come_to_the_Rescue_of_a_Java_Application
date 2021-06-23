package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NumberOfOccurrences implements IOccurrencesNumber {
	int count;
//	List<String> symptom = new ArrayList<String>();
//	List<String> listOfSymptoms = new ArrayList<String>();

//	public NumberOfOccurrences() {
//		// TODO Auto-generated constructor stub
//	}

	@Override
	public int[] getNumberOccurrences(Set<String> symptoms, List<String> symptomsList) {
		int [] occurrences = new int[symptoms.size()];
		List<String> symptom = new ArrayList<String>(symptoms);
		try {
			for (int i = 0; i < symptoms.size(); i++) {
				count = 0;
				for (int j = 0; j < symptomsList.size(); j++) {
					if (symptomsList.get(j).equals(symptom.get(i))) {
						count++;
					}

				}
				occurrences [i] = count;
				System.out.println(symptom.get(i) +" : " +count);
			}
		} catch (IndexOutOfBoundsException e) {
			System.err.println(e);
		}
		
		
		return occurrences;
	}

}
