package com.hemebiotech.analytics;

import java.util.ArrayList;

public interface ISymptomWriter {

	/**
	 * Anything that will read symptom data from a source The important part is, the
	 * return value from the operation, which is a list of strings, that may contain
	 * many duplications
	 * 
	 * The implementation does not need to order the list
	 * 
	 */

	void WriteSymptoms(ArrayList<String> listeSymptomes);

}
