package com.systechtraining.interfaces.charger;

public class LaptopCharger implements ThreePinPlug {
    @Override
    public boolean plugIn() {
        System.out.println("Laptop charger connected");
        return false;
    }

    @Override
    public boolean plugOut() {
        System.out.println("Laptop charger disconnected");
        return false;
    }
}
