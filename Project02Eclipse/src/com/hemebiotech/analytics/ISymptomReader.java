package com.hemebiotech.analytics;

import java.util.List;


// The line `public interface ISymptomReader {` is declaring an interface named `ISymptomReader`. An
// interface in Java is a collection of abstract methods that can be implemented by classes. In this
// case, the `ISymptomReader` interface defines a single method `getSymptoms` that takes a `String`
// parameter `inputFile` and returns a list of strings. Classes that implement this interface will need
// to provide an implementation for the `getSymptoms` method.
public interface ISymptomReader {
	

// The `getSymptoms` method is a part of the `ISymptomReader` interface. It takes a `String` parameter
// `inputFile` which represents the path or name of the input file.
	List<String> getSymptoms (String inputFile);
}
