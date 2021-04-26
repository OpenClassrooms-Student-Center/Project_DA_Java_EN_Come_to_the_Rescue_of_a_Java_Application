package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;

public class SymptomClass {
	public String SymptomName = "";
	public int SymptomCount = 0;
	
	public SymptomClass(String SymptomName, int SymptomCount) {
		this.SymptomName = SymptomName;
		this.SymptomCount = SymptomCount;
		
	}
	
	public static String getSymptoms (SymptomClass sy) {
		String name = 
			"The symptom name is: " +
			sy.SymptomName+"\n"+
			"There is/are actually : " +sy.SymptomCount+
			" symptom(s).\n";
		return name;		
	}
	
	public void setSymptoms (String symptom, int count) {
		symptom = this.SymptomName;
		count = this.SymptomCount;
	}
	
	public void write(SymptomClass symptom) throws IOException{
		FileWriter writer = new FileWriter ("result.out");
		writer.write("number of: " + SymptomName +" "+ SymptomCount + "\n");
		writer.close();
	}
	
}
