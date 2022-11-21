package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSymptoms {

	List<Symptom> listSymptoms;

	public ListSymptoms() {
		this.listSymptoms = new ArrayList<Symptom>();
	}

	public Symptom searchInStringList(String symptomWording) {

		for (Symptom s : this.listSymptoms) {
			if (symptomWording.equals(s.wording)) {
				return s;
			}
		}
		return null;
	}
	
	public void addNewSymptom(Symptom symptomToAdd) {
		this.listSymptoms.add(symptomToAdd);		
	}

	public void IncreaseNumberOfSymptom(Symptom symptom) {

		for (Symptom s : this.listSymptoms) {
			if (symptom.wording.equals(s.wording)) {
				s.occurences++;
				break;
			}
		}		
	}

	public void sort() {
		Collections.sort(this.listSymptoms);	
	}

}
