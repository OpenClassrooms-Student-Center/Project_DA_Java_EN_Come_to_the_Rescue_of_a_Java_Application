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
	private List<String> listFromDataSource;	
	private ISymptomsAnalyser analyser;
	private SortedMap<String, Integer> listOfSymptoms;
	private ISymptomWriter symptomWriter; 
	
	public AnalyticsCounter(ISymptomReader symptomReader, ISymptomsAnalyser analyser, ISymptomWriter symptomWriter) {
		this.symptomReader = symptomReader;
		this.analyser = analyser;
		this.symptomWriter = symptomWriter;
	}
	
	/**
	 * Method that extracts data from a data source and fill the attribute listFromDataSource of this class.
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void readData() throws FileNotFoundException, IOException {
		this.listFromDataSource = symptomReader.getSymptoms();
	}

	/**
	 * Method that analyze data and fill the attribute listOfSymptoms of this class. 
	 */
	public void analyseData() {		
		this.listOfSymptoms = analyser.analyseSymptoms(this.listFromDataSource);
	}

	/**
	 * Method that write extracted and analyzed data.
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void writeData() throws FileNotFoundException, IOException {
		this.symptomWriter.writeSymptoms(listOfSymptoms);
	}
}
