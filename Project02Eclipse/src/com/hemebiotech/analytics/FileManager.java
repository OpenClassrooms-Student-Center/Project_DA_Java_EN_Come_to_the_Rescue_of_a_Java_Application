package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * This class will instantiate [ISymptomReader]{@link ISymptomReader}, [Analytics]{@links Analytics} and [ISymptomsWriter]{@links ISymptomWriter}
 * to read, analyze and create a new file out of a file containing strings of symptoms.
 * 
 * @author Rayane Berrada
 */
public class FileManager {
	private ISymptomReader symptomsReader;
	private Analytics datasAnalyzer;
	private ISymptomWriter symptomsWriter;
	
	/** readSymptoms is a list containing the symptoms read from a file */
	private List<String> readSymptoms;
	private Map<String, Integer> analyzedSymptoms;
	
	/**
	 * @param readingClass will initialize the variable symptomsReader with an instance of an implementation of {@link ISymptomReader}.
	 * symptomsReader will then be used by FileManager to read the symptoms and store it inside readSymptoms.
	 * 
	 * @param anazlyzingClass will initialize the variable datasAnalyzer with an instance of an implementation of {@link Analytics}.
	 * datasAnalyzer will be used by FileManager to analyze the symptoms and store it inside analyzedSymptoms.
	 * 
	 * @param writingClass will initialize the variable symptomsWriter with an instance of an implementation of {@link ISymptomWriter}.
	 * symptomsWriter will be used by FileManager to write the analyzed data in a file store at the root of the project. 
	 */
	public FileManager(ISymptomReader readingClass,Analytics anazlyzingClass, ISymptomWriter writingClass) {
		this.symptomsReader = readingClass;
		this.datasAnalyzer = anazlyzingClass;
		this.symptomsWriter = writingClass;
	}
	
	/**
	 * This method read the symptoms in a file using symptomsReader and initialize the variable readSymptoms with the List returned 
	 * by symptomsReader
	 * 
	 * @param path is a String of the path to the file we want to extract the symptoms from
	 */
	public void readFile(String path) {
		this.symptomsReader.setFilePath(path);
		this.readSymptoms = this.symptomsReader.getSymptoms();
	}
	
	/**
	 * This method analyze the data using the method analyze defined in datasAnalyzer and initialize the variable analyzedSymptoms
	 * with the values returned by the object datasAnalyzer.
	 */
	public void analyzeDatas() {
		if ( this.readSymptoms != null) {
			this.datasAnalyzer.analyze(this.readSymptoms);
			this.analyzedSymptoms = this.datasAnalyzer.getAnalyzedSymptoms();
		} else {
			System.out.println("readSymptoms list empty. You need to use the readFile method before analyzing datas");
		}
	}
	
	/**
	 * Create a new file at the root of the project containing the informations stored in the variable anazlyzedSymptoms
	 */
	public void writeDatasInFile() {
		if ( this.analyzedSymptoms != null) {
			this.symptomsWriter.createFile(this.analyzedSymptoms);
		} else {
			System.out.println("analyzedSymptoms list empty. You need to use the analyzeDatas method before creating the file");
		}
	}
}
