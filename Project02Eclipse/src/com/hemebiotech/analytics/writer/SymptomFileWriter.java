package com.hemebiotech.analytics.writer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SymptomFileWriter implements ISymptomWriter {

	public static String DEFAULT_FILENAME_OUT = "result.out";
	
	private String filepath;
	
	
	/**
	 * 
	 * @param filepath a full or partial path to file where results are going to be written
	 */
	public SymptomFileWriter( String filepath ) {
		this.filepath = filepath;
	}
	
	@Override
	public void export(TreeMap<String, Integer> symptoms) {
		
		// TODO Auto-generated method stub
		
		try {
		
			System.out.println("Trying to write symptoms statistics to this file: " + this.filepath);
			FileWriter writer = new FileWriter (this.filepath);
			
			Iterator<Entry<String, Integer>> iterator =   symptoms.entrySet().iterator();
			
			while( iterator.hasNext() ){
				Entry<String, Integer> entry = iterator.next();
				writer.write( entry.getKey() + ": " + entry.getValue().toString() + "\n" );
			}
			
			writer.close();
		
		}catch( IOException e ) {
			System.out.println( "An error occured while trying to write out the results. See below" );
			e.printStackTrace();
		}
		
	}

	
	
}
