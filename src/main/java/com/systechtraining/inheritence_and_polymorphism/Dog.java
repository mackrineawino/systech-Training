package com.systechtraining.inheritence_and_polymorphism;

public class Dog extends Animal{
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }

	public String printName() {
		return "Dog";
	}
}
