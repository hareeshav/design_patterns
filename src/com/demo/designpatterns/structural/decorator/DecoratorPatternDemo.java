package com.demo.designpatterns.structural.decorator;

/**
 * Demonstrates Decorator Design Pattern.
 * 
 * @author hareev
 *
 */
public class DecoratorPatternDemo {

	public static void main(String[] args) {
		Car sportsCar = new SportsCar(new BasicCar());
		sportsCar.assemble();
		System.out.println();
		
		Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
		sportsLuxuryCar.assemble();
	}
}

//Component Interface.
interface Car{
	public void assemble();
}

//Component Implementation.
class BasicCar implements Car{

	@Override
	public void assemble() {
		// TODO Auto-generated method stub
		System.out.println("Basic Car");
		
	}
}

//Decorator class
class CarDecorator implements Car{
	protected Car car;
	
	public CarDecorator(Car car) {
		super();
		this.car = car;
	}

	@Override
	public void assemble() {
		// TODO Auto-generated method stub
		this.car.assemble();
	}
}

//Concrete Decorator: Sports Car. 

class SportsCar extends CarDecorator{

	public SportsCar(Car car) {
		super(car);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void assemble() {
		// TODO Auto-generated method stub
		super.assemble();
		System.out.println("Adding features of SportsCar");
	}
}

//Concrete Decorator: Luxury Car. 
class LuxuryCar extends CarDecorator{

	public LuxuryCar(Car car) {
		super(car);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void assemble() {
		// TODO Auto-generated method stub
		super.assemble();
		System.out.println("Adding features of LuxuryCar");
	}
}