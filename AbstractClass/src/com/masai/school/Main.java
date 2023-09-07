package com.masai.school;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
	
	Animal[] animals = new  Animal[3];
	
	animals[0] = new Dog();
	animals[1] = new Cat();
	animals[2] = new Tiger();
	
	for(Animal a : animals) {
		if(a instanceof Dog) {
			System.out.println("Dog");
			a.makeNoise();
			a.eat();
			a.walk();
		}else if(a instanceof Cat) {
			System.out.println("Cat");
			a.makeNoise();
			a.eat();
			a.walk();
		}else {
			System.out.println("Tiger");
			a.makeNoise();
			a.eat();
			a.walk();
		}
		
	}

	}

}
