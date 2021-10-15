package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public interface ISymptomCounter {

	Map<String, Integer> getSymptomsOccurence(List<String> list_symptoms);

}
