package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter implements IAnalyticsCounter {

	private List<String> listOfSymptoms;

	public AnalyticsCounter(List<String> listOfSymptoms) {
		this.listOfSymptoms = listOfSymptoms;
	}

	@Override
	public Map<String, Integer> AnalyticsCount() {
		Map<String, Integer> dictionaryOfSymptoms = new TreeMap<String, Integer>();

		for (int i = 0; i < listOfSymptoms.size(); i++) {
			String dictionnaryKey = listOfSymptoms.get(i);
			if (dictionaryOfSymptoms.containsKey(dictionnaryKey)) {
				dictionaryOfSymptoms.put(dictionnaryKey, dictionaryOfSymptoms.get(dictionnaryKey) + 1);
			} else {
				dictionaryOfSymptoms.put(dictionnaryKey, 1);
			}
		}

		return dictionaryOfSymptoms;

	}
}
