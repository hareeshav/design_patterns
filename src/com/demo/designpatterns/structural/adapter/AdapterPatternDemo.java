package com.demo.designpatterns.structural.adapter;

/**
 * Demonstrates Adapter Design Pattern.
 * 
 * @author hareev
 *
 */
public class AdapterPatternDemo {
	
	public static void main(String[] args) {
		testObjectAdapter();
	}
	
	private static void testObjectAdapter() {
		SocketAdapter sockAdapter = new SocketAdapterImpl();
		System.out.println("v3 volts using Object Adapter="+sockAdapter.get3Volt().getVolts());
		System.out.println("v12 volts using Object Adapter="+sockAdapter.get120Volt().getVolts());
		System.out.println("v120 volts using Object Adapter="+sockAdapter.get240Volt().getVolts());
		
		SocketAdapter sockAdapter1 = new SocketAdapterCompositionImpl();
		System.out.println("v3 volts using Object Adapter="+sockAdapter1.get3Volt().getVolts());
		System.out.println("v12 volts using Object Adapter="+sockAdapter1.get120Volt().getVolts());
		System.out.println("v120 volts using Object Adapter="+sockAdapter1.get240Volt().getVolts());
	}

}
class Socket{
	public Volt getVolt() {
		return new Volt(120);
	}
}

class Volt{
	private int volts;

	public Volt(int volts) {
		super();
		this.volts = volts;
	}

	public int getVolts() {
		return volts;
	}

	public void setVolts(int volts) {
		this.volts = volts;
	}
}

//Build an adapter that can produce 3v,120v or 240v.
//Step1 : Create an adapter interface.
interface SocketAdapter{
	Volt get3Volt();
	Volt get120Volt();
	Volt get240Volt();
	
}

//Using Inheritance for Adapter
class SocketAdapterImpl extends Socket implements SocketAdapter {

	@Override
	public Volt get3Volt() {
		// TODO Auto-generated method stub
		return new Volt(3);
	}

	@Override
	public Volt get120Volt() {
		// TODO Auto-generated method stub
		return getVolt();
	}

	@Override
	public Volt get240Volt() {
		// TODO Auto-generated method stub
		return new Volt(240);
	}
	
}
//Using composition for adapter
class SocketAdapterCompositionImpl implements SocketAdapter {

	private Socket socket = new Socket();
	
	@Override
	public Volt get3Volt() {
		// TODO Auto-generated method stub
		return new Volt(3);
	}

	@Override
	public Volt get120Volt() {
		// TODO Auto-generated method stub
		return socket.getVolt();
	}

	@Override
	public Volt get240Volt() {
		// TODO Auto-generated method stub
		return new Volt(240);
	}
	
}


