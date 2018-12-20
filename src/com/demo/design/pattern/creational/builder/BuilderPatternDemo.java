package com.demo.design.pattern.creational.builder;
/**
 * Demonstrates Builder Design Pattern.
 * 
 * @author hareev
 *
 */
public class BuilderPatternDemo {
	
	public static void main(String[] args) {
		Computer computer = new Computer.ComputerBuilder("hdd", "monitor", "ram").setBluetoothEnabled(true).build();
		System.out.println(computer.isGraphicsCardEnabled());
	}

}

class Computer{
	//Required Parameters.
	private String HDD;
	private String monitor;
	private String RAM;
	
	//Optional Parameters.
	private boolean isGraphicsCardEnabled;
	private boolean isBluetoothEnabled;
	//generate private constructors.
	private Computer(ComputerBuilder builder) {
		super();
		this.HDD = builder.HDD;
		this.monitor = builder.monitor;
		this.RAM = builder.RAM;
		this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
		this.isBluetoothEnabled = builder.isBluetoothEnabled;
	}
	//generated all getters, no setters.
	public String getHDD() {
		return HDD;
	}
	public String getMonitor() {
		return monitor;
	}
	public String getRAM() {
		return RAM;
	}
	public boolean isGraphicsCardEnabled() {
		return isGraphicsCardEnabled;
	}
	public boolean isBluetoothEnabled() {
		return isBluetoothEnabled;
	}
	
	//The builder class.
	public static class ComputerBuilder{
		//Required Parameters.
		private String HDD;
		private String monitor;
		private String RAM;
		
		//Optional Parameters.
		private boolean isGraphicsCardEnabled;
		private boolean isBluetoothEnabled;
		public ComputerBuilder(String hDD, String monitor, String rAM) {
			super();
			this.HDD = hDD;
			this.monitor = monitor;
			this.RAM = rAM;
		}
		
		public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
			this.isBluetoothEnabled = isBluetoothEnabled;
			return this;
		}
		public ComputerBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
			this.isGraphicsCardEnabled = isGraphicsCardEnabled;
			return this;
		}
		
		public Computer build() {
			return new Computer(this);
		}
		
	}
}
