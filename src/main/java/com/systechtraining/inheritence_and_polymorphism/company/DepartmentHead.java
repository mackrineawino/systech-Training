package com.systechtraining.inheritence_and_polymorphism.company;

public class DepartmentHead extends Employee{
    private String title;

    public DepartmentHead(String employeeNo, String employeeName, String employeeAddress, String title) {
        super(employeeNo, employeeName, employeeAddress);
        this.title = title;
    }

    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    
}
