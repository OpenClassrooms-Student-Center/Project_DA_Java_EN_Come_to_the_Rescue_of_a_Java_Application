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
	
	/**-------------------------------------------------*
	 * Getter de la classe SymptomClass					*											        *
	 * @param symptom de type SymptomClass				*
	 * @return SymptomName & SymptomCount				*
	 *-------------------------------------------------*/
	
	public static String getSymptoms (SymptomClass symptom) {
		String name = 
			"The symptom name is: " +
			symptom.SymptomName+"\n"+
			"There is/are actually : " +symptom.SymptomCount+
			" symptom(s).\n";
		return name;		
	}
	
	/**-------------------------------------------------*
	 * Setter de la classe SymptomClass					*
	 * @param symptom de type String					*
	 *-------------------------------------------------*/
	
	public void setSymptoms (String symptom) {
		this.SymptomName = symptom;
	}
	
	public void write(SymptomClass symptom) throws IOException{
		FileWriter writer = new FileWriter ("result.out");
		writer.write("number of: " + SymptomName +" "+ SymptomCount + "\n");
		writer.close();
	}
	
}
