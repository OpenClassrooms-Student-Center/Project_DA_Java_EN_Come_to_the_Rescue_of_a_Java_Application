package util;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import obj.ListSymptoms;

public class WriteSymptomsInFile implements ISymptomWriter {
	
	private ListSymptoms listSymptoms;
	private String filePathOut;
	
	public WriteSymptomsInFile(String filePath, ListSymptoms listSymptoms) {
		this.filePathOut = filePath;
		this.listSymptoms = listSymptoms;
	}
	
	@Override
	public void WriteSymptoms() throws IOException, FileNotFoundException {

		FileWriter fwriter = new FileWriter(this.filePathOut);
		BufferedWriter bwriter = new BufferedWriter(fwriter);

		for (int i = 0; i < this.listSymptoms.getListSymptoms().size(); i++) {

			String line = this.listSymptoms.getListSymptoms().get(i).wording + " : " + this.listSymptoms.getListSymptoms().get(i).occurences;
			bwriter.write(line);
			bwriter.newLine();

		}
		bwriter.flush();
		fwriter.close();
		bwriter.close();
		
	}
	
	

}
