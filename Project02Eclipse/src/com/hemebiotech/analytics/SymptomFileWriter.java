package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class SymptomFileWriter implements ISymptomWriter {

	public static String DEFAULT_FILENAME_OUT = "result.out";
	
	private String filepath;
	
	public SymptomFileWriter( String filepath ) {
		this.filepath = filepath;
	}
	
	@Override
	public void export(HashMap<String, Integer> symptoms) {
		
		// TODO Auto-generated method stub
		
		try {
		
			FileWriter writer = new FileWriter (this.filepath);
			
			Iterator<Entry<String, Integer>> iterator =   symptoms.entrySet().iterator();
			
			while( iterator.hasNext() ){
				Entry<String, Integer> entry = iterator.next();
				writer.write( entry.getKey() + ": " + entry.getValue().toString() );
			}
			
			writer.close();
		
		}catch( IOException e ) {
			e.printStackTrace();
		}
		
	}

	
	
}
