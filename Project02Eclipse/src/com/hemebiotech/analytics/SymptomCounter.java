package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class SymptomCounter {
    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> symptomsCount = new HashMap <>(); //creation new object de type hashmap que va contener las llaves o sintomas y el recuento ex : dolor de cabeza = 3 veces 
        for (String symptom : symptoms){// es la list que recibo en parametros
            symptomsCount.put(symptom, symptomsCount.getOrDefault(symptom,0)+1);//getordefault sumar al valor actual el +1
        }
        return symptomsCount; //el hashmap se llama symptomscount
    }
}

