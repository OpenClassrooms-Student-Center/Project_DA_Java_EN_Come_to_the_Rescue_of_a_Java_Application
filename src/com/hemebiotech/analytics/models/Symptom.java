package com.hemebiotech.analytics.models;

/**
 * Represents one symptom with its name
 */
public class Symptom {

    private String name;

    public Symptom (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
