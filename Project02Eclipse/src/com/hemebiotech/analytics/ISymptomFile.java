package com.hemebiotech.analytics;
import java.io.IOException;

/**
 * Interface generating a file output from any source to any source
 */
public interface ISymptomFile {
    
    /**
     * Generates the file from a map
     * @throws IOException
     */
    public void getFileOutput() throws IOException;
}
