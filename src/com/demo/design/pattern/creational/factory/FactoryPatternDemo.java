package com.demo.design.pattern.creational.factory;
/**
 * Demonstrates Factory Design Pattern.
 * 
 * @author hareev
 *
 */
public class FactoryPatternDemo {

	public static void main(String[] args) {
		Computer computer = ComputerFactory.getComputer(1);
		System.out.println(computer);
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
class ComputerFactory{
	public static Computer getComputer(int type) {
		Computer computer = null;
		switch (type) {
		case 1:
			computer = new Laptop();
			break;

		default:
			computer = new Laptop();
			break;
		}
		
		return computer;
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
