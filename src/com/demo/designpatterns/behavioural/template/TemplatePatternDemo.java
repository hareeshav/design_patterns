package com.demo.designpatterns.behavioural.template;

/**
 * Demonstrates Template Design Pattern.
 * 
 * @author hareev
 *
 */
public class TemplatePatternDemo {

	public static void main(String[] args) {
		new Chess().run();
	}
}

abstract class Game{
	protected int currentPlayer;
	protected final int noOfPlayers;
	public Game(int noOfPlayers) {
		super();
		this.noOfPlayers = noOfPlayers;
	}
	
	public void run() {
		start();
		while(!haveWinner()) 
			takeTurn();
		System.out.println("Player: "+ getWinningPlayer()+" wins");
	}

	protected abstract void start();

	protected abstract boolean haveWinner() ;

	protected abstract void takeTurn() ;

	protected abstract int getWinningPlayer() ;
	
}

class Chess extends Game{
	
	private int maxTurns = 10;
	private int turn = 1;

	public Chess() {
		super(2);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void start() {
		// TODO Auto-generated method stub
		System.out.println("Game Begins now..");
		
	}

	@Override
	protected boolean haveWinner() {
		// TODO Auto-generated method stub
		return turn == maxTurns;
	}

	@Override
	protected void takeTurn() {
		// TODO Auto-generated method stub
		System.out.println("Turn" +(turn++)+ "taken by"+ currentPlayer);
		currentPlayer = (currentPlayer+1)%noOfPlayers;
		
	}

	@Override
	protected int getWinningPlayer() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
