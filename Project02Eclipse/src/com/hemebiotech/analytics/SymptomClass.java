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
	
	public String getSymptoms() {
		String name = 
			"The symptom name is: " +
			this.SymptomName+"\n"+
			"There is/are actually : " +this.SymptomCount+
			" symptom(s).\n";
		System.out.println(name);	
		return name;
			
	}
	
	/**-------------------------------------------------*
	 * Setter de la classe SymptomClass					*
	 * @param objet de type SymptomClass				*
	 * @param New SymptomName & New SymptomCount		*
	 *-------------------------------------------------*/
	
	public static void setSymptoms (SymptomClass objet, String symptom, int count) {
		objet.SymptomName = symptom;
		objet.SymptomCount = count;
	}
	
	public void write(SymptomClass symptom) throws IOException{
		FileWriter writer = new FileWriter ("result.out");
		writer.write("number of: " + SymptomName +" "+ SymptomCount + "\n");
		writer.close();
	}
	
}