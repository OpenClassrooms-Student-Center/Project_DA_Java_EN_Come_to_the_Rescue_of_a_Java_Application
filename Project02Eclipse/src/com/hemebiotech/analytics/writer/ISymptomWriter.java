package com.hemebiotech.analytics.writer;

import java.util.TreeMap;

/**
 * exports symptoms list
 */
public interface ISymptomWriter {

	void export(TreeMap<String, Integer> sortedSymptoms);
}
