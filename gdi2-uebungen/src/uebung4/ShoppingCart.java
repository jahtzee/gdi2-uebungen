package uebung4;

import java.util.ArrayList;

public class ShoppingCart<Type extends HasPrice>{
	
	private ArrayList<Type> contents = new ArrayList<Type>();
	
	public void buy(Type article) {
		this.contents.add(article);
	}
	
	public void printReceipt() {
		double sumPrice = 0;
		for (Type article : contents) {
			System.out.println(article);
			sumPrice += article.getPrice();
		}
		sumPrice = Math.round(sumPrice * 100.0)/100.0;
		System.out.println("Total: " + sumPrice);
	}
}
