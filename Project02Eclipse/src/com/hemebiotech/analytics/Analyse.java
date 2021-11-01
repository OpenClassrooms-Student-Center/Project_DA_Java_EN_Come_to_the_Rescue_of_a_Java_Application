package com.hemebiotech.analytics;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

/***
 * * Analyse
 * <ul>
 * <li>read data from any support</li>
 * <li>count and order the data.</li>
 * <li>write the data in any data support</li>
 * </ul>
 * 
 * @see ISymptomReader
 * @see ISymptomsDataProcessing
 * @see ISymptomWriter
 */
public class Analyse {

	private ISymptomReader reader;
	private ISymptomsDataProcessing process;
	private ISymptomWriter writer;

	/**
	 * Constructs a new, empty Analyse object,
	 * 
	 * @param readerFromMain  reading interface
	 * @param processFromMain processing interface
	 * @param writerFromMain  writing interface
	 */
	public Analyse(ISymptomReader readerFromMain, ISymptomsDataProcessing processFromMain,
			ISymptomWriter writerFromMain) {
		this.reader = readerFromMain;
		this.writer = writerFromMain;
		this.process = processFromMain;
	}

	/**
	 * read the data Symptoms from support.
	 * 
	 * @return list of Symptoms.
	 */
	public List<String> getSymptom() {
		return this.reader.getSymptoms();
	}

	/**
	 * Count the number of occurrences in a list.
	 * 
	 * @param symptomList :list of Symptoms
	 * @return Map with symptom in the key field and its frequency in the value
	 *         field.
	 */
	public Map<String, Integer> symtomsCounter(List<String> symptomList) {
		return this.process.symptomsCounter(symptomList);
	}

	/**
	 * Sort the symptoms
	 * 
	 * @param symptomsMap Map with symptom in the key field and its frequency in the
	 *                    value field.
	 * @param comparator  the comparator used to order the keys in this map, if is
	 *                    null this map uses the alphabetical order.
	 * @return Sorted Map with symptom in the key field and its frequency in the
	 *         value field.
	 */
	public Map<String, Integer> sortedSymptoms(Map<String, Integer> symptomsMap, Comparator<String> comparator) {
		return this.process.sortedSymptoms(symptomsMap, comparator);
	}

	/**
	 * write the contents of the Map in data support
	 * 
	 * @param symptomsMap Map with symptom in the key field and its frequency in the
	 *                    value field.
	 */

	public void writeDataSymptoms(Map<String, Integer> symptomsMap) {
		this.writer.writeSymptomsData(symptomsMap);
	}
}
