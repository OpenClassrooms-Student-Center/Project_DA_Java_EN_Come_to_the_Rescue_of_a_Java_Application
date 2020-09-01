package com.hemebiotech.analytics.dao.implement;

import com.hemebiotech.analytics.models.Symptom;
import com.hemebiotech.analytics.dao.Dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implements DAO for symptom file datasource
 */
public class SymptomFileDao implements Dao<Symptom> {

    private String filepath;

    /**
     * @param filepath a full or partial path to file with symptom strings in it, one per line
     */
    public SymptomFileDao(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public List<Symptom> getAll() {
        List<Symptom> symptomList = new ArrayList<>();

        if (filepath != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filepath))){
                String line = reader.readLine();
                while (line != null) {
                    symptomList.add(new Symptom(line));
                    line = reader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return symptomList;
    }
}
