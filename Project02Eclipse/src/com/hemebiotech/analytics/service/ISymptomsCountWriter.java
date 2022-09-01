package com.hemebiotech.analytics.service;

import java.util.Map;

public interface ISymptomsCountWriter {

     void writeSymptoms(Map<String,Long> symptomsAndCount);

}
