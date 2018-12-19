package com.demo.designpatterns.behavioural.command;

import java.util.Collections;
import java.util.List;

import com.demo.designpatterns.behavioural.command.BankAccountCommand.Action;

/**
 * Demonstrates Command Design Pattern.
 * @author hareev
 *
 */
public class CommandPatternDemo {
	public static void main(String[] args) {
		BankAccount ba = new BankAccount();
		System.out.println(ba);
		List<BankAccountCommand> commands = List.of(new BankAccountCommand(ba, Action.DEPOSIT, 1000),new BankAccountCommand(ba, Action.DEPOSIT, 1000),
				new BankAccountCommand(ba, Action.WITHDRAW, 1000),new BankAccountCommand(ba, Action.DEPOSIT, 1000));
		for(Command c: commands) {
			c.call();
		}
		List<BankAccountCommand> revCommands = List.of(new BankAccountCommand(ba, Action.DEPOSIT, 1000),new BankAccountCommand(ba, Action.WITHDRAW, 1000),
				new BankAccountCommand(ba, Action.DEPOSIT, 1000),new BankAccountCommand(ba, Action.DEPOSIT, 1000));
				
		for(Command c:revCommands) {
			c.undo();
		}
		System.out.println(ba);
	}

}

class BankAccount{
	
	private int balance;
	private int overdraftLimt = -500;
	
	public void deposit(int amount) {
		balance+=amount;
		System.out.println("Deposited amount: "+amount+". The balance is now: "+balance);
	}
	
	public boolean withdraw(int amount) {
		if(balance-amount>=overdraftLimt) {
			balance-=amount;
			System.out.println("Withdrawn amount: "+amount+". The balance is now: "+balance);
			return true;
		}else {
			System.out.println("No sufficient balance");
			return false;
		}
	}

	@Override
	public String toString() {
		return "BankAccount [balance=" + balance +"]";
	}
}

interface Command{
	void call();
	void undo();
}

class BankAccountCommand implements Command{
	
	private BankAccount bankAccount;
	private boolean succeeded;
	
	public enum Action{
		WITHDRAW,DEPOSIT;
	}
	private Action action;
	private int amount;
	
	public BankAccountCommand(BankAccount bankAccount, Action action, int amount) {
		super();
		this.bankAccount = bankAccount;
		this.action = action;
		this.amount = amount;
	}

	@Override
	public void call() {
		// TODO Auto-generated method stub
		switch (action) {
		case WITHDRAW:
			succeeded=bankAccount.withdraw(amount);
			break;
		case DEPOSIT:
			succeeded=true;
			bankAccount.deposit(amount);
			break;
		default:
			break;
		}
	}

	@Override
	public void undo() {
		if(!succeeded) return;
		// TODO Auto-generated method stub
		switch (action) {
		case WITHDRAW:
			bankAccount.deposit(amount);
			break;
		case DEPOSIT:
			bankAccount.withdraw(amount);
			break;
		default:
			break;
		}
	}
	
}
