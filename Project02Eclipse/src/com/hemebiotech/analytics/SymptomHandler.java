package com.hemebiotech.analytics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SymptomHandler implements ISymptomHandler{
	
	private List<String> listSymptom;
	private Map<String,Integer> dico;
	private List<String> listKey;
	private File result;

	public SymptomHandler(List<String> ls) {
		listSymptom = ls;
		dico = new HashMap<String,Integer>();
		listKey = new ArrayList<String>();
	}
	
	@Override
	public void countAndSortEachSymptom() {	
		
		String line;
		for(int i = 0 ; i<listSymptom.size() ; i++) {
				line = listSymptom.get(i);
				
			if (dico.containsKey(line)){
				dico.put(line, dico.get(line)+1);					
			}
			else {
				
				listKey.add(line);
				dico.put(line,1);					
				if (listKey.size()== 1){
				}
				else if(listKey.size()==2) {
					if(listKey.get(1).compareTo(listKey.get(0))<0) {
						
						String tmp = listKey.get(0);
						listKey.set(0, listKey.get(1));
						listKey.set(1, tmp);
					}
				}else {	
					
					int indice = listKey.size()-1;
					boolean flag = false;
					while (indice>0 && !flag ) {
						
						if (listKey.get(indice-1).compareTo(listKey.get(indice))>0) {
							
							String tmp = listKey.get(indice-1);
							listKey.set(indice-1, listKey.get(indice));
							listKey.set(indice, tmp);
						}else {
							flag=true;
						}
						indice--;
					}
				}
			}	
		}
	}
	@Override
	public void CreateSortedFile(String path) throws IOException {
		result = new File(path);
		result.createNewFile();
		FileWriter writer = new FileWriter(path);
		for(int i = 0 ; i < listKey.size() ; i++) {		
			writer.write(listKey.get(i)+" : " + dico.get(listKey.get(i)) + "\n");
		}
		writer.close();		
	}

}
