package impl;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.SortedMap;

import services.ISymptomWriter;

public class WriteSymptomsInFile implements ISymptomWriter {
	
	private String filePathOut;

	public WriteSymptomsInFile(String filePath) {
		this.filePathOut = filePath;
	}

	@Override
	public void writeSymptoms(SortedMap<String, Integer> listSymptomsAndOccurrence) throws IOException, FileNotFoundException {

		FileWriter fwriter = new FileWriter(this.filePathOut);
		BufferedWriter bwriter = new BufferedWriter(fwriter);
		
		for (String s : listSymptomsAndOccurrence.keySet()) {
			
			String line = s + " : " + listSymptomsAndOccurrence.get(s);

			bwriter.write(line);
			bwriter.newLine();
		}
		
		bwriter.flush();
		fwriter.close();
		bwriter.close();		

	}
	
}
