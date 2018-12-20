package com.demo.design.pattern.creational.singleton;

/**
 * Demonstrates Singleton Design Pattern.
 * 
 * @author hareev
 *
 */
public class SingletonPatternDemo {
	
	public static void main(String[] args) {
		//cannot be done.
		//BasicSingleton singleton = new BasicSingleton();
		BasicSingleton singleton = BasicSingleton.getBasicSingleton();
	}

}

class BasicSingleton{

	private static final BasicSingleton INSTANCE = new BasicSingleton();
	
	private BasicSingleton() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static BasicSingleton getBasicSingleton() {
		return INSTANCE;
	}
	
}
