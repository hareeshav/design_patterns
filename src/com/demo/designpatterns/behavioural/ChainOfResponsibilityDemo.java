package com.demo.designpatterns.behavioural;

/**
 * Demonstrates Chain of Responsibility Design pattern.
 * 
 * @author hareev
 *
 */
public class ChainOfResponsibilityDemo {

	public static void main(String[] args) {
		Creature goblin = new Creature("Goblin", 2, 2);
		System.out.println(goblin);
		CreatureModifier rootModifier = new CreatureModifier(goblin);
		System.out.println("Increasing Attack");
		rootModifier.add(new DoubleAttackModifier(goblin));
		System.out.println("Increasing Defence");
		rootModifier.add(new IncreaseDefenceModifier(goblin));
		rootModifier.handle();
		System.out.println(goblin);
	}
}

