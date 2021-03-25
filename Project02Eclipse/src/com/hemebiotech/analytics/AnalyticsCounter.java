package com.hemebiotech.analytics;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {
	
	private CountFreq countFreq;
	private Caster caster;
	private ChangeOrder changeOrder;
	private ResultWriter resultWriter;
	
//	- Main: Le déroulé de l'orchestration est bon, mais ce n'est pas 
//	la responsabilité du main ! Le main doit configurer et lancer le processus,
//	mais pas faire lui-même l'orchestration. Regarde du côté des mécanismes 
//	d'injection de dépendances (à la main, pas avec un framework) 
//	pour voir comment "configurer" une classe.
	
	
//	- Modifier la classe AnalyticsCounter pour qu'elle s'occupe de l'orchestration 
//	via une méthode appelée par le main (qui lui s'occupe de la configuration)

	public AnalyticsCounter() {
		this.countFreq = new CountFreq();
		this.caster = new CastAction();
		this.changeOrder = new ChangeOrder();
		this.resultWriter = new WriteResultInFile();
	}
	
	public void doProcess(ISymptomReader reader) throws IOException {
		List<String> symptomsList = reader.GetSymptoms();
		Map<String,Integer> symptomsCount = countFreq.CountFrequency(symptomsList);
		symptomsList = caster.CastToList(symptomsCount);
		symptomsList = changeOrder.InAlphabeticalOrder(symptomsList);
		
		System.out.println(symptomsList);
		
		this.resultWriter.WriteResult(symptomsList);
	}

	public static void main(String args[]) throws Exception {
		
		AnalyticsCounter analyticsCounter = new AnalyticsCounter();
		String filepath = new File("Project02Eclipse/symptoms.txt").getCanonicalPath();
		ISymptomReader reader = new ReadSymptomDataFromFile(filepath);
		analyticsCounter.doProcess(reader);
				
	}

}
