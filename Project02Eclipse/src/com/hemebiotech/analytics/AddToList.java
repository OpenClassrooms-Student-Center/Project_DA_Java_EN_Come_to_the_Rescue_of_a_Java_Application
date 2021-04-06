package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddToList {
	
	public List<String> addInList (Map<String, Integer> symptomCount) {
		List<String> symptomList = new ArrayList<String>();

		for (Map.Entry<String, Integer> value : symptomCount.entrySet()) { 
			symptomList.add(value.getKey() + " x " +  value.getValue() + "\n");
		}
		return symptomList;
	}
}
