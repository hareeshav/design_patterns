package com.demo.designpatterns.behavioural;

public class IncreaseDefenceModifier extends CreatureModifier{

	public IncreaseDefenceModifier(Creature creature) {
		super(creature);
	}
	public void handle() {
		System.out.println("Increasing "+ creature.getName()+" defence");
		creature.setDefence(creature.getDefence()+2);
		super.handle();
	}
	
}