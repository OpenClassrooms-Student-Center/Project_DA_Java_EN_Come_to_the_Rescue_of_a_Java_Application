package obj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSymptoms {

	private List<Symptom> listSymptoms;

	public ListSymptoms() {
		this.listSymptoms = new ArrayList<Symptom>();
	}

	/**
	 * @return the listSymptoms
	 */
	public List<Symptom> getListSymptoms() {
		return listSymptoms;
	}

	public Symptom searchInStringList(String symptomWording) {

		for (Symptom s : this.listSymptoms) {
			if (symptomWording.equals(s.getWording())) {
				return s;
			}
		}
		return null;
	}
	
	public void addNewSymptom(Symptom symptomToAdd) {
		this.listSymptoms.add(symptomToAdd);		
	}

	public void increaseNumberOfSymptom(Symptom symptom) {

		for (Symptom s : this.listSymptoms) {
			if (symptom.getWording().equals(s.getWording())) {
				s.setOccurences(s.getOccurences() + 1);;
				break;
			}
		}		
	}

	public void sort() {
		Collections.sort(this.listSymptoms);	
	}

}
