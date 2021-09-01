package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;

public interface ISymptomCounter {

	HashMap<String, Integer> GetSymptomsOccurence (List<String> list_symptoms);
	
}
