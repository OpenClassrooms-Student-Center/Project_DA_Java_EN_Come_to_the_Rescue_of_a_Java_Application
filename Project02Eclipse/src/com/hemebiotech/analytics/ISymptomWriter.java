package com.hemebiotech.analytics;
import java.util.Map;


// The line `public interface ISymptomWriter {` is declaring an interface named `ISymptomWriter`. An
// interface in Java is a collection of abstract methods that can be implemented by classes. In this
// case, the `ISymptomWriter` interface defines a single method called `writeSymptoms`. Classes that
// implement this interface will need to provide an implementation for this method.
public interface ISymptomWriter {

// The `writeSymptoms` method is a method signature defined in the `ISymptomWriter` interface. It takes
// two parameters: `symptomCount`, which is a `Map` object that maps symptom names to their
// corresponding counts, and `outputFilePath`, which is a `String` representing the file path where the
// symptoms will be written.
	void writeSymptoms (Map<String,Integer>symptomCount,String outputFilePath);
}
