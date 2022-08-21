package com.hemebiotech.analytics.writer;

import java.util.Map;

public interface ISymptomsCountWriter {

     void writeSymptoms(Map<String,Long> symptomsAndCount);

}
