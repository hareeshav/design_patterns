package com.demo.designpatterns.structural.proxy;

/**
 * Demonstrates Proxy Design Pattern.
 * 
 * @author hareev
 *
 */
public class ProxyPatternDemo {
	
	public static void main(String[] args) {
		Car car = new Car(new Driver(12));
		car.drive();
		System.out.println();
		
		Car car1 = new CarProxy(new Driver(12));
		car1.drive();
	}

}

interface Drivable{
	void drive();
}

class Driver{
	
	public int age;
	public Driver(int age) {
		super();
		this.age = age;
	}
	
}

class Car implements Drivable{

	protected Driver driver;
	public Car(Driver driver) {
		super();
		this.driver = driver;
	}

	@Override
	public void drive() {
		// TODO Auto-generated method stub
		System.out.println("Driving Car..");
	}
}

class CarProxy extends Car{

	public CarProxy(Driver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void drive() {
		// TODO Auto-generated method stub
		if(driver.age>=18)
			super.drive();
		else
			System.out.println("No License");
	}
	
}