package com.hemebiotech.analytics;

import com.hemebiotech.analytics.analyser.ISymptomAnalyser;
import com.hemebiotech.analytics.reader.ISymptomReader;
import com.hemebiotech.analytics.writer.ISymptomWriter;


/**
 * Classe abstraite d'une application d'analyse de symptomes
 * 
 * @author Olivier
 *
 */
public abstract class AbstractSymptomAnalyzerApplication {

	
	
	/**
	 * Le writer a la responsabilité d'ecrire le resultat de l'analyse faite par analyser
	 */
	ISymptomWriter writer;
	
	/**
	 * Le reader a la responsabilité de lire une source de données
	 */
	ISymptomReader reader;
	
	/**
	 * L'analyser a la responsabilité de compter les occurences de chaque symptomes dans les données founies par le reader.
	 */
	ISymptomAnalyser analyser;
	
	/**
	 * Injection par setter d'une instance de ISymptomAnalyser
	 * @param analyser
	 */
	public void setAnalyser(ISymptomAnalyser analyser) {
		this.analyser = analyser;
	}

	
	/**
	 * Injection par setter d'une instance de ISymptomWriter
	 * @param writer
	 */
	public void setWriter(ISymptomWriter writer) {
		this.writer = writer;
	}

	/**
	 * Injection par setter d'une instance de ISymptomReader
	 * @param reader
	 */
	public void setReader(ISymptomReader reader) {
		this.reader = reader;
	}
	
	public abstract void run();
	
}
