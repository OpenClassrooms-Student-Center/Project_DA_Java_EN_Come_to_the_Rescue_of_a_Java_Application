package com.hemebiotech.analytics.exceptions;

public class EmptyFileException extends Exception{

    public EmptyFileException(String msg){
        super("file empty");
    }

}
