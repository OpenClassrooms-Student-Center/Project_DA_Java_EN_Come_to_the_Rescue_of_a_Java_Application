package com.hemebiotech.analytics;

import java.util.TreeMap;

public interface ISymptomWriter {

	void export( TreeMap<String, Integer> symptoms );
	
}