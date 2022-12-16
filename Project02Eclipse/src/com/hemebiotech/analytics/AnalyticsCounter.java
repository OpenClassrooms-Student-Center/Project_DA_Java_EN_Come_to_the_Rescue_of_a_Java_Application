package com.hemebiotech.analytics;

import java.util.*;

public class AnalyticsCounter {



	public List<String> readSymptom(ISymptomReader dataInput) {
		return dataInput.getSymptoms();

	}

	/**
	 *
	 * @param sortAndCount : this mmethod is for sorting and counting
	 * @return : it will return a map of strings counted and sorted.
	 */


	public TreeMap<String, Integer> sortAndCount(ICountAndSort sortAndCount) {

		return sortAndCount.countAndSort();

	}

	/**
	 *
	 * @param R this method return nothing.
	 *        it will, eventhough, write the sortted and counted map result on a file called result.out
	 */


	public void saveResult (ISaveResult R){
		R.saveResult();

	}
}

