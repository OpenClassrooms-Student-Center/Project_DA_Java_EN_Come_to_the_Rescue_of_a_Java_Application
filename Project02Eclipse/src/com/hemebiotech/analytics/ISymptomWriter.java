package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomWriter {
	/**
	 * Interface qui permet d'écrire une liste de symptomes qui sera passée en paramètres
	 *
	 * @param symptoms attend une map de symptomes qui sera écrite.
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) ;

}
