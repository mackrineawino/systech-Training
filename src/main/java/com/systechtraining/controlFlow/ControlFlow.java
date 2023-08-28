package com.systechtraining.controlFlow;
import java.util.logging.Logger;

public class ControlFlow {
    private static final Logger LOGGER = Logger.getLogger(ControlFlow.class.getName());

    public void ifelseStatement() {
        int maths = 39;
        char grade;

        if (maths >= 70) {
            grade = 'A';
        } else if (maths >= 60) {
            grade = 'B';
            
        } else if (maths >= 50){
            grade = 'C';

        } else if (maths >= 40){
            grade = 'D';
        }else{
            grade = 'E';
        }

        LOGGER.info("Student grade: " + grade); // + grade
    }
    public void switchStatement(){
        String day = "THURSDAY";
        switch(day){
            case "MONDAY":
                LOGGER.info("Monday is a working day");
                break;
            case "TUESDAY":
                LOGGER.info("Tuesday is a working day");
                break;
            case "WEDNESDAY":
                LOGGER.info("Wednesday is a working day");
                break;
            case "THURSDAY":
                LOGGER.info("Thursday is a working day");
                break;
            case "FRIDAY":
                LOGGER.info("Friday is a working day");
                break;
            case "SATURDAY":
            case "SUNDAY":
                LOGGER.info("Party Day");
                break;          
            default:
                LOGGER.info("Please specify a valid day of the week");

        }



    }
    public static void main(String[] args) {
        ControlFlow app = new ControlFlow();
        app.ifelseStatement();
        app.switchStatement();

    }
}

