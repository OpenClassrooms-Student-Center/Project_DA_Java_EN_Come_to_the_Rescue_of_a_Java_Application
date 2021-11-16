package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Analyse {
	/**
	 * champ private n'est visible que depuis sa propre classe. Elle n'est visible
	 * nulle part ailleurs et en particulier pas dans les sous-classes.
	 */
	private ISymptomReader iSymptomReader;
	private ISymptomCounter countAndOrderSymptoms;
	private ISymptomWriter iSymptomWriter;

	/**
	 * 
	 * this. indique l'instance courante de l'objet de la classe. En utilisant this,
	 * vous pouvez faire référence aux membres d'une classe tels que les
	 * constructeurs, les variables et les méthodes
	 * 
	 */
	public Analyse(ISymptomReader iSymptomReaderFromMain, ISymptomCounter countAndOrderSymptomsFromMain,
			ISymptomWriter iSymptomWriterFromMain) {
		this.iSymptomReader = iSymptomReaderFromMain;
		this.countAndOrderSymptoms = countAndOrderSymptomsFromMain;
		this.iSymptomWriter = iSymptomWriterFromMain;
	}

	public List<String> getSymptom() {
		return this.iSymptomReader.getSymptoms();
	}

	public Map<String, Integer> symtomsCounter(List<String> symptomList) {
		return this.countAndOrderSymptoms.processData(symptomList);
	}

	public void writeDataSymptoms(Map<String, Integer> symptomsMap) {
		this.iSymptomWriter.writeSymptoms(symptomsMap);
	}
}