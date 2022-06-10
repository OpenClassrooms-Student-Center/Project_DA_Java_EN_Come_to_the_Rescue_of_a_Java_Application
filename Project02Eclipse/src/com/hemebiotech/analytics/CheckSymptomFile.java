package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.net.URL;

public class CheckSymptomFile {

    public String getFilePathFromClassPath(String fileName) throws FileNotFoundException {
        URL resource = this.getClass().getResource(fileName);
        if (resource != null)
            return resource.getPath();
        throw new FileNotFoundException("File " + fileName + " not found");
    }
}
