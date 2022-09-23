package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Class permettant d'utiliser les interfaces
 * @author banou
 *
 */
public class Analyse {

	private ISymptomReader symptomReader;
	private ISymptomCalcul symptomCalcul;
	private IOrderSymptom orderSymptomes;
	private ISymptomWriter symptomWriter;

	Analyse(ISymptomReader varSymptomReader, ISymptomCalcul varSymptomCalcul, IOrderSymptom varOrderSymptomes,
			ISymptomWriter varSymptomWriter) {
		this.symptomReader = varSymptomReader;
		this.symptomCalcul = varSymptomCalcul;
		this.orderSymptomes = varOrderSymptomes;
		this.symptomWriter = varSymptomWriter;

	}

	public List<String> getSymptoms(String varFilepath) {
		return this.symptomReader.getSymptoms(varFilepath);
	}

	public Map<String, Integer> getMapSymptomes(List<String> varListeSymptomes) {
		return this.symptomCalcul.getMapSymptomes(varListeSymptomes);
	}

	public Map<String, Integer> order(Map<String, Integer> varMapSymptome) {
		return this.orderSymptomes.order(varMapSymptome);
	}

	public void write(Map<String, Integer> varNewMapSymptome, String varFilePathOut) {
		this.symptomWriter.write(varNewMapSymptome, varFilePathOut);
	}

}
