package services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.SortedMap;

import obj.ListSymptoms;

public interface ISymptomWriter {

	// Version intermédiaire
//	void writeSymptoms(ListSymptoms list) throws IOException, FileNotFoundException;

	// Version modifiée
	void writeSymptoms(SortedMap<String, Integer> listOfSymptoms) throws IOException, FileNotFoundException;
}
