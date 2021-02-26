package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlphabeticalOrder {

	public List<String> AlphabeticalOrder(List<String> symptomList) {
		
		List<String> inOrderResult = new ArrayList<String>(); 
		Collections.sort(symptomList);

	    for (int i = 0; i < symptomList.size(); i++) {
	    	inOrderResult.add(symptomList.get(i));
	    }
	    return inOrderResult;
	}
}

