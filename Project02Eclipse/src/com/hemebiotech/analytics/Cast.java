package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Cast implements ICaster{
	
	@Override
	public List<String> CastToList(Map<String, Integer> symptomCount) {
		List<String> symptomList = new ArrayList<String>();

		for (Map.Entry<String, Integer> value : symptomCount.entrySet()) { 
			symptomList.add(value.getKey() + " x " +  value.getValue() + "\n");
		}
		return symptomList;
	}
}
