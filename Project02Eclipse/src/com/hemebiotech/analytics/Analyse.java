package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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

	public List<String> getSymptoms() {
		return this.symptomReader.getSymptoms();
	}

	public Map<String, Integer> getMapSymptomes() {
		return this.symptomCalcul.getMapSymptomes();
	}

	public Map<String, Integer> order() {
		return this.orderSymptomes.order();
	}

	public void write() {
		this.symptomWriter.write();
	}

}
