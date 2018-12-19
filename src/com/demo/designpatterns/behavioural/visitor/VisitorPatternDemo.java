package com.demo.designpatterns.behavioural.visitor;
/**
 * Demonstrates Visitor Design Pattern.
 * 
 * @author hareev
 *
 */
public class VisitorPatternDemo {
	
	public static void main(String[] args) {
		//to define 1+(2+3)
		AdditionExpression e = new AdditionExpression(new DoubleExpression(1), new AdditionExpression
				(new DoubleExpression(2), new DoubleExpression(3)));
		StringBuilder sb = new StringBuilder();
		//e.print(sb);
		//System.out.println(sb.toString());*/
		//Uncomment the below code for reflective visitor approach.
		//ExpressionPrinter.print(e, sb);
		//System.out.println(sb);
		//Uncomment the below code for classic visitor approach.
		ExpressionPrinter ep = new ExpressionPrinter();
		ep.visit(e);
		System.out.println(ep);
		
		ExpressionCalculator ec = new ExpressionCalculator();
		ec.visit(e);
		System.out.println(ec);
	}
}

//Introduced for reflective visitor approach.
/*class ExpressionPrinter{
	public static void print(Expression e, StringBuilder sb) {
		if(e.getClass() == DoubleExpression.class) {
			sb.append(((DoubleExpression)e).value);
		}else if(e.getClass() == AdditionExpression.class) {
			AdditionExpression ae = (AdditionExpression)e;
			sb.append("(");
			print(ae.left, sb);
			sb.append("+");
			print(ae.right, sb);
			sb.append(")");
		}
	}
}*/

//Introduced for Classic Visitor approach.
class ExpressionCalculator implements ExpressionVisitor{

	@Override
	public String toString() {
		return "ExpressionCalculator [result=" + result + "]";
	}

	public double result;
	@Override
	public void visit(DoubleExpression e) {
		// TODO Auto-generated method stub
		result = e.value;
	}

	@Override
	public void visit(AdditionExpression e) {
		// TODO Auto-generated method stub
		e.left.accept(this);
		double a = result;
		e.right.accept(this);
		double b = result;
		result = a+b;
	}
	
}

//Introduced for Classic Visitor approach.
class ExpressionPrinter implements ExpressionVisitor{
	
	@Override
	public String toString() {
		return sb.toString();
	}

	private StringBuilder sb = new StringBuilder();
	@Override
	public void visit(DoubleExpression e) {
		// TODO Auto-generated method stub
		sb.append(e.value);
		
	}

	@Override
	public void visit(AdditionExpression e) {
		// TODO Auto-generated method stub
		sb.append("(");
		e.left.accept(this);
		sb.append("+");
		e.right.accept(this);
		sb.append(")");
		
	}
}

//Introduced for Classic Visitor approach.
interface ExpressionVisitor{
	void visit(DoubleExpression e);
	void visit(AdditionExpression e);
}

abstract class Expression{
	//Introduced for intrusive approach.
	//public abstract void print(StringBuilder sb);
	//Introduced for classic visitor approach.
	public abstract void accept(ExpressionVisitor visitor);
	
}

class DoubleExpression extends Expression{
	public double value;

	public DoubleExpression(double value) {
		super();
		this.value = value;
	}

	/*@Override
	public void print(StringBuilder sb) {
		// TODO Auto-generated method stub
		sb.append(value);
		
	}*/

	@Override
	public void accept(ExpressionVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
		
	}
}

class AdditionExpression extends Expression{
	public Expression left, right;

	public AdditionExpression(Expression left, Expression right) {
		super();
		this.left = left;
		this.right = right;
	}

	@Override
	public void accept(ExpressionVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
		
	}

	/*@Override
	public void print(StringBuilder sb) {
		// TODO Auto-generated method stub
		sb.append("(");
		left.print(sb);
		sb.append("+");
		right.print(sb);
		sb.append(")");
		
	}*/
	
}
