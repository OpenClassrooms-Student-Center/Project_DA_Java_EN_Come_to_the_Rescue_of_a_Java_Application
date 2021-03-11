package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Symptoms {


	/**
	 * Do the process to read a file, count symptoms,
	 * cast, list in alphabetic order and write in file "result.out".
	 * @param symptomsFile
	 * The path of the input file, needed to read symptoms.
	 * @throws IOException
	 */
	public void SymptomDoProcess(String symptomsFile) throws IOException {
		List<String> symptomList = ReadSymptoms(symptomsFile);
		Map<String, Integer> symptomCount = CountSymptoms(symptomList);
		symptomList = CastSymptoms(symptomCount);
		symptomList = SymptomInOrder(symptomList);
		WriteSymptom(symptomList);
	}

	/**
	 * Read the symptoms from a file.
	 * @param symptomsFile
	 * The path of the input file, needed to read symptoms.
	 * @return
	 * List of symptoms
	 * @throws IOException
	 */
	public List<String> ReadSymptoms(String symptomsFile) throws IOException {
		ISymptomReader reader = new ReadSymptomDataFromFile(symptomsFile);
		List<String> symptomList = reader.GetSymptoms();
		return symptomList;
	}

	/**
	 * Count the List of symptoms.
	 * @param symptomList
	 * List of symptoms.
	 * @return
	 * Map of symptoms counted.
	 */
	public Map<String, Integer> CountSymptoms(List<String> symptomList){
		CountFreq counter = new CountFreq();
		Map<String, Integer> symptomCount = counter.CountFrequency(symptomList);
		return symptomCount;
	}

	/**
	 * Cast a Map to a List, needed to classify in order alphabetic in the next step.
	 * @param symptomCount
	 * Map of symptoms counted.
	 * @return
	 * List of symptoms counted.
	 */
	public List<String> CastSymptoms(Map<String, Integer> symptomCount){
		Caster changeToList = new CastAction();
		List<String> symptomList = changeToList.CastToList(symptomCount);
		return symptomList;
	}

	/**
	 * Classify the List in order alphabetic.
	 * @param symptomList
	 * List of symptoms counted.
	 * @return
	 * List of symptoms counted and in order alphabetic.
	 */
	public List<String> SymptomInOrder(List<String> symptomList){
		ChangeOrder OrderAlphabetic = new ChangeOrder();
		symptomList = OrderAlphabetic.InAlphabeticalOrder(symptomList);
		return symptomList;
	}

	/**
	 * Write the List in a file "result.out".
	 * @param symptomList
	 * List of symptoms and in order alphabetic.
	 * @throws IOException
	 */
	public void WriteSymptom(List<String> symptomList) throws IOException{
		ResultWriter writer = new Write();
		writer.WriteInFile(symptomList);
	}	
}

