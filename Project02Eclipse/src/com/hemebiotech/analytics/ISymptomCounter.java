package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public interface ISymptomCounter {

	Map<String, Integer> GetSymptomsOccurence(List<String> list_symptoms);

}
