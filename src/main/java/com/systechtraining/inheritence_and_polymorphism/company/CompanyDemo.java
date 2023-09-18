package com.systechtraining.inheritence_and_polymorphism.company;

import java.util.logging.Logger;

public class CompanyDemo {
    private static final Logger LOGGER = Logger.getLogger(CompanyDemo.class.getName());

    public CompanyDemo() {
        super();
    }

    public static void main(String[] args) {
        
        CompanyDemo app = new CompanyDemo();
        /*
         * LOGGER.info("app => " + app.hashCode());
         * LOGGER.info("app => " + app.toString());
         * LOGGER.info("app => " + app.getClass().getPackageName());
         */
        app.companySetup();
        

    }

    public void companySetup() {
    
       
        SoftwareEngineer e1 = new SoftwareEngineer("mackie",
                "001", "juja", "Software Engineer");

        LOGGER.info("SoftwareEngineer => " + e1.toString());

        QualityAssuarance qa = new QualityAssuarance("002", "sedah",
                "webuye", "Software Engineer in Test");

        LOGGER.info("QualityAssurance qa1 => " + qa.toString());

    }
    
    //   public void companySetup() {
    //   SoftwareEngineer e1 = new SoftwareEngineer();
    //   e1.setEmployeeName("Emily");
    //   e1.setEmployeeNo("001");
    //   e1.setEmployeeAddress("Nakawa - Kampala");
    //   e1.setTitle("Software Engineer");
    //   LOGGER.info("SoftwareEngineer => " + e1.toString());
     
    //   QualityAssuarance qa = new QualityAssuarance();
    //  qa.setEmployeeName("Halkano");
    //   qa.setEmployeeNo("002");
    //   qa.setEmployeeAddress("Westlands - Nairobi");
    //   qa.setTitle("Software Engineer in Test");
      
    //   QualityAssuarance qa2 = new QualityAssuarance();
    //   qa2.setEmployeeName("Annliza");
    //   qa2.setEmployeeNo("003");
    // qa2.setEmployeeAddress("Westlands - Nairobi");
    //   qa2.setTitle("Software Engineer in Test");
    //   LOGGER.info("QualityAssurance qa1 => " + qa.toString());
    //   LOGGER.info("QualityAssurance qa2 => " + qa2.toString());
      
    //   }
     
}
