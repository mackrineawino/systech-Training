package com.systechtraining.exception_handling;

public class StudentDetailsMissingException extends Exception{
    public StudentDetailsMissingException(String message){
        super(message);
    }
}
