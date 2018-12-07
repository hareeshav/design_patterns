package com.demo.designpatterns.behavioural;

public class Creature{
	
	private String name;
	private int defence,attack;
	
	public Creature(String name, int defence, int attack) {
		super();
		this.name = name;
		this.defence = defence;
		this.attack = attack;
	}
	@Override
	public String toString() {
		return "creature [name=" + name + ", defence=" + defence + ", attack=" + attack + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDefence() {
		return defence;
	}
	public void setDefence(int defence) {
		this.defence = defence;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	

	

}
	