package com.demo.design.pattern.creational.abstractfactory;

/**
 * Demonstrates Abstract Factory Design Pattern.
 * 
 * @author hareev
 *
 */
public class AbstractFactoryPatternDemo {
	public static void main(String[] args) {
		Computer pc = ComputerFactory.getComputer(new LaptopFactory());
		System.out.println(pc);
	}
}
//We need to create abstract factory interface or abstract class.
interface ComputerAbstractFactory{
	public Computer createComputer();
}

class LaptopFactory implements ComputerAbstractFactory{

	@Override
	public Computer createComputer() {
		// TODO Auto-generated method stub
		return new Laptop();
	}
	
}

class ServerFactory implements ComputerAbstractFactory{

	@Override
	public Computer createComputer() {
		// TODO Auto-generated method stub
		return new Server();
	}
	
}

class ComputerFactory{
	public static Computer getComputer(ComputerAbstractFactory factory) {
		return factory.createComputer();
	}
}


abstract class Computer{
	public abstract String getRAM();
	public abstract String getMonitor();
	public abstract String getHDD();
	@Override
	public String toString() {
		return "Computer [getRAM()=" + getRAM() + ", getMonitor()=" + getMonitor() + ", getHDD()=" + getHDD() + "]";
	}
}
class Server extends Computer{
	private String RAM;
	private String HDD;
	private String monitor;
	
	@Override
	public String getRAM() {
		// TODO Auto-generated method stub
		return this.RAM;
	}

	@Override
	public String getMonitor() {
		// TODO Auto-generated method stub
		return this.monitor;
	}

	@Override
	public String getHDD() {
		// TODO Auto-generated method stub
		return this.HDD;
	}
	
}
class Laptop extends Computer{
	private String RAM;
	private String HDD;
	private String monitor;
	@Override
	public String getRAM() {
		// TODO Auto-generated method stub
		return this.RAM;
	}

	@Override
	public String getMonitor() {
		// TODO Auto-generated method stub
		return this.monitor;
	}

	@Override
	public String getHDD() {
		// TODO Auto-generated method stub
		return this.HDD;
	}
	
}
