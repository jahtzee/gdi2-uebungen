package uebung4;

public class Main {

	public static void main(String[] args) {
		
		Groceries g1 = new Groceries(1.99f, "Chocolate bar");
		Groceries g2 = new Groceries(19.99f, "Riesling Trocken");
		
		Book b1 = new Book(399.99f, "Expedition by Wayne Barlowe");
		Book b2 = new Book(19.99f, "Twilight of the Idols by Friedrich Nietzsche");
		
		ShoppingCart<Book> books = new ShoppingCart<Book>();
		ShoppingCart<Groceries> groceries = new ShoppingCart<Groceries>();
		
		books.buy(b1);
		books.buy(b2);
		groceries.buy(g1);
		groceries.buy(g2);
		
		books.printReceipt();
		groceries.printReceipt();

	}

}
