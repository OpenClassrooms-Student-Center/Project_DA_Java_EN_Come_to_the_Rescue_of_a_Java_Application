package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Collections;
/**
 * Objet définit par son nom et son nombre d'occurences dans une liste
 * 
 */
public class Symptoms {
    String name = "";
    int occurences = 0;

/**
 * Constructeur de la classe Symptoms: Compte le nombre d'occurences du paramètre "name" dans une liste "rawlist"
 * @param name  Entrée de la chaine de caractères String à compter
 * @param rawlist   Entrée de la liste dans laquelle on doit chercher le nombre d'occurences de "name"
 */
   public Symptoms(String name, ArrayList<String> rawlist){
        this.name = name;
        this.occurences = Collections.frequency(rawlist, name);  //Compte les occurences de "name" dans "rawlist"

    }
    /**
     * 
     * @return Nom du symptome
     */
    public String GetName()
    {
        return this.name;
    }

    /**
     * 
     * @return Nombre d'occurences dans la liste
     */
    public int GetOccurences()
    {
        return this.occurences;
    }
}