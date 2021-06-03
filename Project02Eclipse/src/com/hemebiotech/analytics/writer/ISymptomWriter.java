package com.hemebiotech.analytics.writer;

import java.util.TreeMap;

public interface ISymptomWriter {

	void export( TreeMap<String, Integer> symptoms );
	
}