package com.systechtraining.interfaces.shapes;

public class Rectangle implements Area, Perimeter{
    @Override
    public double calculateArea(double x, double y) {
        System.out.println(MY_NAME);
        return x*y;
    }

    @Override
    public double calculatePerimeter(double x, double y) {
        System.out.println(MY_NAME_Full);
        return 2*(x+y);
    }
}
