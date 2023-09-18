package com.systechtraining.library;

public class Student {
    private String studentRegNumber;
    
    public Student(){

    }
     public Student(String studentRegNumber){
        this.studentRegNumber = studentRegNumber;  
    }
    public String getStudentRegNumber() {
        return studentRegNumber;
    }
    public void setStudentRegNumber(String studentRegNumber) {
        this.studentRegNumber = studentRegNumber;
    }

    
}
