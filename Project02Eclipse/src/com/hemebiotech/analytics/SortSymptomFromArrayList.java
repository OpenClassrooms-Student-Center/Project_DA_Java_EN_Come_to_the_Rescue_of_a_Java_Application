package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class SortSymptomFromArrayList 
{

	private ArrayList <String> symptomList = new ArrayList<String>();
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public SortSymptomFromArrayList (ArrayList <String> symptomList) 
	{
		this.symptomList = symptomList;
    }
	
	public TreeMap<String,Integer> sortSymptom()
	{
		TreeMap<String,Integer> symptomAndOccurrencesMap = new TreeMap<String,Integer>();
		
		if (symptomList != null)
		{
			for (String elt : symptomList)
			{
				if (!symptomAndOccurrencesMap.containsKey(elt))
				{
					symptomAndOccurrencesMap.put(elt, Collections.frequency(symptomList, elt));
				}
			}
		}
		return symptomAndOccurrencesMap;
	}
}