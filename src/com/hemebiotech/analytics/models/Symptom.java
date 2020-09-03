package com.hemebiotech.analytics.models;

import java.util.Objects;

/**
 * Represents one symptom with its name
 */
public class Symptom implements Comparable<Symptom>{

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Symptom symptom = (Symptom) o;
        return name.equalsIgnoreCase(symptom.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Symptom o) {
        return name.compareTo(o.name);
    }

    @Override
    public String toString(){
        return name;
    }
}
