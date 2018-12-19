package com.demo.designpatterns.behavioural.strategy;

import java.util.List;

/**
 * Demonstrates strategy pattern, both dynamic and static strategy.
 * 
 * @author hareev
 *
 */
public class StrategyPatternDemo {
	public static void main(String[] args) {
		//Uncomment the below for static strategy.
		/*TextProcessor<MarkdownListStrategy> tp = new TextProcessor<>(MarkdownListStrategy::new);
		tp.appendList(List.of("liberte", "egalite", "fraternite"));
		System.out.println(tp);

		TextProcessor<HtmlListStrategy> tp2 = new TextProcessor<>(HtmlListStrategy::new);
		tp2.appendList(List.of("inheritance", "encapsulation", "polymorphism"));
		System.out.println(tp2);
		*/
		//Uncomment the below for dynamic strategy.
		TextProcessor tp = new TextProcessor(OutputFormat.HTML);
		tp.appendList(List.of("liberte", "egalite", "fraternite"));
		System.out.println(tp);
		
		tp.clear();
		
		tp = new TextProcessor(OutputFormat.MARKDOWN);
		tp.appendList(List.of("inheritance", "encapsulation", "polymorphism"));
		System.out.println(tp);

	}

}

enum OutputFormat{
	MARKDOWN, HTML;
}
interface ListStrategy {
	default void start(StringBuilder sb) {
	}

	void addListItem(StringBuilder stringBuilder, String item);

	default void end(StringBuilder sb) {
	}
}

class MarkdownListStrategy implements ListStrategy {
	@Override
	public void addListItem(StringBuilder stringBuilder, String item) {
		stringBuilder.append(" * ").append(item).append(System.lineSeparator());
	}
}

class HtmlListStrategy implements ListStrategy {
	@Override
	public void start(StringBuilder sb) {
		sb.append("<ul>").append(System.lineSeparator());
	}

	@Override
	public void addListItem(StringBuilder stringBuilder, String item) {
		stringBuilder.append("  <li>").append(item).append("</li>").append(System.lineSeparator());
	}

	@Override
	public void end(StringBuilder sb) {
		sb.append("</ul>").append(System.lineSeparator());
	}
}

//Uncomment the below for dynamic strategy.

class TextProcessor {
	private StringBuilder sb = new StringBuilder();
	// cannot do this
	// private LS listStrategy = new LS();
	private ListStrategy listStrategy;

	// This defines the static strategy
	public TextProcessor(OutputFormat format) {
		setOutputFormat(format);
	}

	private void setOutputFormat(OutputFormat format) {
		// TODO Auto-generated method stub
		switch (format) {
		case HTML:
			listStrategy = new HtmlListStrategy();
			break;

		case MARKDOWN:
			listStrategy = new MarkdownListStrategy();
			break;
			
		default:
			break;
		}
		
	}

	// the skeleton algorithm is here
	public void appendList(List<String> items) {
		listStrategy.start(sb);
		for (String item : items)
			listStrategy.addListItem(sb, item);
		listStrategy.end(sb);
	}

	public void clear() {
		sb.setLength(0);
	}

	@Override
	public String toString() {
		return sb.toString();
	}
}

//Uncomment the below for static strategy
/*class TextProcessor<LS extends ListStrategy> {
	private StringBuilder sb = new StringBuilder();
	// cannot do this
	// private LS listStrategy = new LS();
	private LS listStrategy;

	// This defines the static strategy
	public TextProcessor(Supplier<? extends LS> ctor) {
		listStrategy = ctor.get();
	}

	// the skeleton algorithm is here
	public void appendList(List<String> items) {
		listStrategy.start(sb);
		for (String item : items)
			listStrategy.addListItem(sb, item);
		listStrategy.end(sb);
	}

	public void clear() {
		sb.setLength(0);
	}

	@Override
	public String toString() {
		return sb.toString();
	}
}
*/