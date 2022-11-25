package services;

import java.io.FileNotFoundException;
import java.io.IOException;

import obj.ListSymptoms;

public interface ISymptomWriter {

	void writeSymptoms(ListSymptoms list) throws IOException, FileNotFoundException;
}
