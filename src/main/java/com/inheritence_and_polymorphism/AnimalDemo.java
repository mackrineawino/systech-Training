package com.inheritence_and_polymorphism;

public class AnimalDemo {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();
        Animal anyAnimal = new Animal();
        dog.makeSound();
        cat.makeSound();
        anyAnimal.makeSound();

        Animal dog2 = new Animal();
        dog2.makeSound();
    } 
}
