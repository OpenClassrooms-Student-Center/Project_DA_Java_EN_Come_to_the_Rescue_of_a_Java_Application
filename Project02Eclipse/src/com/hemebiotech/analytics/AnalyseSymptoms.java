
package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;



/**
 * La classe AnalyseSymptoms permet de récupérer une ArrayList et de l'intégrer dans une
 * TreeMap, afin de recenser les occurrences par ordre alphabétique.
 * @author fouziahajji
 */
public class AnalyseSymptoms implements ISymptomCounter{
	
	//variable d'instance
	private ISymptomReader symptomReader;
	private ISymptomWriter symptomWriter;
	private ISymptomCounter symptomCounter;
	
	
	//Constructeur de l'objet AnalyseSymptoms (analyticCounter)
	public AnalyseSymptoms(ISymptomReader iSymptomReader, ISymptomWriter iSymptomWriter, ISymptomCounter iSymptomCounter) {
		this.symptomReader = iSymptomReader;
		this.symptomWriter = iSymptomWriter;
		this.symptomCounter = iSymptomCounter;
		
		
	}

	/** methode qui fait appel à l'instance ISymptomCounter pour compter et trier les symptoms
	 * @param list
	 * @return map de string integer avec les symptomds et leur nombre
	 */
	public Map<String, Integer> countSymptoms(List<String> list)  {
      	return symptomCounter.countSymptoms(list); 
		  
	  }

	/** methode pour récuperer les symptoms
	 * @return listResult
	 * @throws IOException 
	 */
	public List<String> getSymptoms() throws IOException {
		return symptomReader.getSymptoms();
	}
	
	
	/** methode pour ecrire les symptoms
	 * @param mapResult    
	 * @throws IOException 
	 */
	public void writeSymptoms(Map<String,Integer> mapResult) throws IOException {
			symptomWriter.writeSymptoms(mapResult);

	}


	
}









	


