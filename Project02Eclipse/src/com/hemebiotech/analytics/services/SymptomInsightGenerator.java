package com.hemebiotech.analytics.services;

import java.util.Map;
import java.util.stream.Collectors;

import com.hemebiotech.analytics.interfaces.ISymptominsightGenerator;



public class SymptomInsightGenerator implements ISymptominsightGenerator{

  public String InsightGenerator (Map<String, Integer> symptoms) {
	  if(symptoms == null) {
		  return "Aucun symptome a analyser.";
	  }
		  String top3 = symptoms.entrySet().stream()
		            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
		            .limit(3)
		            .map( e -> e.getKey() + " (" + e.getValue() + ")")
		            .collect(Collectors.joining(", "));
	  
  
	return "top3 symptome a analyser : " + top3; 
}
}
  

  
