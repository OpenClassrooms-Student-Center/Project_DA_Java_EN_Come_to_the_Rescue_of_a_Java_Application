package obj;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.SortedMap;

import services.ISymptomReader;
import services.ISymptomWriter;
import services.ISymptomsAnalyser;

public class AnalyticsCounter {
	
	private ISymptomReader symptomReader;
	private List<String> listFromFile;	
	private ISymptomsAnalyser analyser;
	private SortedMap<String, Integer> listOfSymptoms;
	private ISymptomWriter symptomWriter; 
	
	/**
	 * 
	 * @param symptomReader
	 * @param analyser
	 * @param symptomWriter
	 */
	public AnalyticsCounter(ISymptomReader symptomReader, ISymptomsAnalyser analyser, ISymptomWriter symptomWriter) {
		this.symptomReader = symptomReader;
		this.analyser = analyser;
		this.symptomWriter = symptomWriter;
	}
	
	/**
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void readFile() throws FileNotFoundException, IOException {
		this.listFromFile = symptomReader.getSymptoms();
	}

	/**
	 * 
	 */
	public void analyseData() {		
		this.listOfSymptoms = analyser.analyseSymptoms(this.listFromFile);
	}

	/**
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void writeFile() throws FileNotFoundException, IOException {
		this.symptomWriter.writeSymptoms(listOfSymptoms);
	}
}
