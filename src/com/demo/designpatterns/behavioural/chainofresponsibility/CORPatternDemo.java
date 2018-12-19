package com.demo.designpatterns.behavioural.chainofresponsibility;

/**
 * Demonstrates Chain Of Responsibility design pattern.
 * 
 * @author hareev
 *
 */
public class CORPatternDemo {
	
	public static void main(String[] args) {
		Creature goblin = new Creature("Goblin", 2, 2);
		System.out.println(goblin);
		CreatureModifier rootModifier = new CreatureModifier(goblin);
		//If this is added nothing else will take place
		//rootModifier.add(new NoBonusesModifier(goblin));
		System.out.println("Increasing Attack");
		rootModifier.add(new DoubleAttackModifier(goblin));
		System.out.println("Increasing Defence");
		rootModifier.add(new IncreaseDefenceModifier(goblin));
		rootModifier.handle();
		System.out.println(goblin);
	}

}

class CreatureModifier {
	
	protected Creature creature;
	protected CreatureModifier next;
	
	public CreatureModifier(Creature creature) {
		super();
		this.creature = creature;
	}
	
	public void add(CreatureModifier cm) {
		if(null == this.next) {
			this.next =cm;
		}else {
			this.next.add(cm);
		}
	}
	
	public void handle() {
		if(null != this.next) {
			this.next.handle();
		}
	}
}

class NoBonusesModifier extends CreatureModifier {

	public NoBonusesModifier(Creature creature) {
		super(creature);
	}

	public void handle() {
		System.out.println("No Bonusesss");
		//super.handle();
	}

}

class DoubleAttackModifier extends CreatureModifier {

	public DoubleAttackModifier(Creature creature) {
		super(creature);
	}

	public void handle() {
		System.out.println("Doubling " + creature.getName() + " attack");
		creature.setAttack(creature.getAttack()*2);
		super.handle();
	}

}

class IncreaseDefenceModifier extends CreatureModifier{

	public IncreaseDefenceModifier(Creature creature) {
		super(creature);
	}
	public void handle() {
		System.out.println("Increasing "+ creature.getName()+" defence");
		creature.setDefence(creature.getDefence()+2);
		super.handle();
	}
	
}

class Creature{
	
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
