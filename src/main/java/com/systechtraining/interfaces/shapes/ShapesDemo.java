package com.systechtraining.interfaces.shapes;

public class ShapesDemo {
    public static void main(String[] args) {
        Square sq = new Square();
        System.out.println(sq.calculateArea(5, 5));
        System.out.println(sq.calculatePerimeter(5, 5));
        // System.out.println(Square.MY_NAME);
        // System.out.println(Square.MY_NAME_Full);
        System.out.println(sq.sum(2,3));
    }
}
