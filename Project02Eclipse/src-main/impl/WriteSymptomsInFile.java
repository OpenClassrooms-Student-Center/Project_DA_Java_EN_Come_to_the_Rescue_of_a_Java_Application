package impl;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.SortedMap;

import obj.ListSymptoms;
import services.ISymptomWriter;

public class WriteSymptomsInFile implements ISymptomWriter {
	
//	private ListSymptoms listSymptoms; a priori plus nécessaire 
	private String filePathOut;
	
	// Version initiale 
//	public WriteSymptomsInFile(String filePath, ListSymptoms listSymptoms) {
//		this.filePathOut = filePath;
//		this.listSymptoms = listSymptoms;
//	}

	// Version modifiée 
	public WriteSymptomsInFile(String filePath) {
		this.filePathOut = filePath;
		//TODO : ok pour le main, mais comment je récupère ma liste à écrire
	}

	// Version initiale 
//	@Override
//	public void writeSymptoms() throws IOException, FileNotFoundException {
//
//		FileWriter fwriter = new FileWriter(this.filePathOut);
//		BufferedWriter bwriter = new BufferedWriter(fwriter);
//
//		for (int i = 0; i < this.listSymptoms.getListSymptoms().size(); i++) {
//
//			String line = this.listSymptoms.getListSymptoms().get(i).getWording() + " : " + this.listSymptoms.getListSymptoms().get(i).getOccurences();
//			bwriter.write(line);
//			bwriter.newLine();
//		}
//		
//		bwriter.flush();
//		fwriter.close();
//		bwriter.close();		
//	}
	
	// Version intermédiaire
//	@Override
//	public void writeSymptoms(ListSymptoms listSymptomes) throws IOException, FileNotFoundException {
//
//		FileWriter fwriter = new FileWriter(this.filePathOut);
//		BufferedWriter bwriter = new BufferedWriter(fwriter);
//
//		for (int i = 0; i < listSymptomes.getListSymptoms().size(); i++) {
//
//			String line = listSymptomes.getListSymptoms().get(i).getWording() + " : " + listSymptomes.getListSymptoms().get(i).getOccurences();
//			bwriter.write(line);
//			bwriter.newLine();
//		}
//		
//		bwriter.flush();
//		fwriter.close();
//		bwriter.close();		
//	}

	// Version modifiée
	@Override
	public void writeSymptoms(SortedMap<String, Integer> listOfSymptoms) throws IOException, FileNotFoundException {

		FileWriter fwriter = new FileWriter(this.filePathOut);
		BufferedWriter bwriter = new BufferedWriter(fwriter);
		
		for (String s : listOfSymptoms.keySet()) {
			
			String line = s + " : " + listOfSymptoms.get(s);

			bwriter.write(line);
			bwriter.newLine();
		}
		
		bwriter.flush();
		fwriter.close();
		bwriter.close();		

	}
	
}
