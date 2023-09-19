package com.systechtraining.interfaces.charger;

public class CookerCharger implements ThreePinPlug{
    @Override
    public boolean plugIn() {
        return false;
    }

    @Override
    public boolean plugOut() {
        return false;
    }
}
