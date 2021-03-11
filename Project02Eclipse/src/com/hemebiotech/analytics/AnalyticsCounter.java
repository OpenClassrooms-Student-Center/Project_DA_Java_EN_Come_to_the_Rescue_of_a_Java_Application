package com.hemebiotech.analytics;

import java.io.File;

public class AnalyticsCounter {

	public static void main(String args[]) throws Exception {
		String symptomsFile = new File("Project02Eclipse/symptoms.txt").getCanonicalPath();
		Symptoms symptoms = new Symptoms();
		symptoms.SymptomDoProcess(symptomsFile);
			
	}
}
