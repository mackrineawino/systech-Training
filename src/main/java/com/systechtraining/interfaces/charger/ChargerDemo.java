package com.systechtraining.interfaces.charger;

public class ChargerDemo {
    public static void main(String[] args) {
        ThreePinPlug mc = new MobileCharger();
        ThreePinPlug lc = new LaptopCharger();
        MobileCharger m = new MobileCharger();

        mc.plugIn();
        mc.plugOut();
        m.printInfo();

        lc.plugIn();
        lc.plugOut();
    }
}
