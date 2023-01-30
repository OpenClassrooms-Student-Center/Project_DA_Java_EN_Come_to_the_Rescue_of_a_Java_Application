/**
 * 
 */
package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import com.hemebiotech.analytics.interfaces.IWriteSymptomToFile;


public class WriteSymptomToFile implements IWriteSymptomToFile {
	/**
	 * Write symptoms in a file
	 * @param Symptoms Map
	 * 
	 * @Return void
	 * @author Laurent
	 * @Version 1.0
	 *
	 */
	private String filepath;
	
	public WriteSymptomToFile(String strFileOut) {
		this.filepath = strFileOut;
	}
	
	@Override
	public void writeSymptom(Map<String, Integer> hashSymptoms) {
	if (filepath != null) {
		FileWriter writer = null;
		try {
			
			// next generate output
			writer = new FileWriter(filepath);
			for(Map.Entry<String, Integer> m : hashSymptoms.entrySet()) { 
				writer.write(m.getKey() + " : " + m.getValue() + "\n");
			}
		} catch (IOException e) {
			System.out.println("Fichier de sortie non valide " + e.getLocalizedMessage());
		} finally
			{
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
