package com.hemebiotech.analytics;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {
	
	//Decorador que indica que se sobrescribe un método 
	@Override
	public void writeSymptoms(Map<String,Integer>symptomCount,String outputFilePath) {
        
        try (FileWriter writer=new FileWriter(outputFilePath)){
            for (Map.Entry<String,Integer> entry: symptomCount.entrySet()){
                writer.write(entry.getKey()+':'+entry.getValue()+'\n');

            }
        }catch(IOException e){
            System.err.println("error"+e.getMessage());
        }
	}

}
