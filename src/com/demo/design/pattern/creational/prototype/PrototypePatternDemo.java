package com.demo.design.pattern.creational.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates Prototype Design Pattern.
 * 
 * @author hareev
 *
 */
public class PrototypePatternDemo {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Employees employees1 = new Employees();
		employees1.loadData();
		
		Employees employees2 = (Employees)employees1.clone();
		System.out.println(employees2.getEmpList().size());
	}

}

class Employees implements Cloneable{
	
	private List<String> empList;
	
	public Employees() {
		super();
		this.empList = new ArrayList<>();
	}

	public Employees(List<String> empList) {
		super();
		this.empList = empList;
	}
	
	public void loadData(){
		//read all employees from database and put into the list
		empList.add("Pankaj");
		empList.add("Raj");
		empList.add("David");
		empList.add("Lisa");
	}

	public List<String> getEmpList() {
		return empList;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
			List<String> temp = new ArrayList<String>();
			for(String s : this.getEmpList()){
				temp.add(s);
			}
			return new Employees(temp);
	}
	
}
