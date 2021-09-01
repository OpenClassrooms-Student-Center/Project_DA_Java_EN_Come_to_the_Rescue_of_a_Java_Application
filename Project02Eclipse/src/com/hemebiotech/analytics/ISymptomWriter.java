package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.HashMap;

public interface ISymptomWriter {

	void writeSymptom(HashMap<String, Integer> symptoms_map) throws IOException;

}
