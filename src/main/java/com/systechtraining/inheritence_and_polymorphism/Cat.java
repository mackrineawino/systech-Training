package com.systechtraining.inheritence_and_polymorphism;

public class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Cat meows");
    }
    public String printName() {
		return "Cat";
	}
}
