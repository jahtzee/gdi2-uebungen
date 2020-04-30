package uebung5;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
        Book dummies = new Book(22.50, "Nudeln kochen für Dummies", "123-4");
        Book reisefuehrer = new Book(99.50,"Abenteuerurlaub für junge Familien: Mit dem Jeep durch Afghanistan", "555-6" );
        Book kochBook = new Book(44.44,"Zauberhafte Gerichte aus der Spülmaschine", "986-6");
        Book bierbauch2019 = new Book(66.77, "Bierbauch in 20 Tagen", "745-1");
        Book sonnenstudio = new Book(9.95,"Sonnenstudioführer 2019", "541-9");
        Book java = new Book(454.33, "Programmieren - Eine Leidenschaft", "658-2");
        
        Book[] allTitles = new Book[] {dummies, reisefuehrer, kochBook, bierbauch2019, sonnenstudio, java};
        ArrayList<Book> myBooks = new ArrayList<Book>();
        for (Book element : allTitles)
        	myBooks.add(element);
        
        myBooks.sort(new BookTitleComparator());
        System.out.println(myBooks);
        
        myBooks.sort(new BookPriceComparator());
        System.out.println(myBooks);
	}

}
