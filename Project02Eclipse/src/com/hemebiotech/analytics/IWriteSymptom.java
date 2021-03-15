package com.hemebiotech.analytics;

/**
 * Anything that will write symptoms file
 * The important part is, we're exporting file named result.out which contains our number of occurrences.
 */
public interface IWriteSymptom {
    /**
     * Export result into a file named result.out
     * return void
     */
    void writeSymptomsInFile ();
}
