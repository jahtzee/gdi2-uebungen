package uebung5;

import java.util.HashMap;
import java.util.Scanner;

public class Test2 {
	
	public static void main(String[] args) {
        Book dummies = new Book(22.50, "Nudeln kochen für Dummies", "123-4");
        Book reisefuehrer = new Book(99.50,"Abenteuerurlaub für junge Familien: Mit dem Jeep durch Afghanistan", "555-6" );
        Book kochBook = new Book(44.44,"Zauberhafte Gerichte aus der Spülmaschine", "986-6");
        Book bierbauch2019 = new Book(66.77, "Bierbauch in 20 Tagen", "745-1");
        Book sonnenstudio = new Book(9.95,"Sonnenstudioführer 2019", "541-9");
        Book java = new Book(454.33, "Programmieren - Eine Leidenschaft", "658-2");
        
        Book[] allTitles = new Book[] {dummies, reisefuehrer, kochBook, bierbauch2019, sonnenstudio, java};
        HashMap<String, Book> myBooks = new HashMap<String, Book>();
        for (Book element : allTitles) {
        	myBooks.put(element.getIsbn(), element);
        }
        
   	 	Scanner sc = new Scanner(System.in);
   	 	System.out.println("Bitte ISBN-Nummer eingeben: ");
        String isbn = sc.nextLine();
        System.out.println("--------------------------------");
        Book book = myBooks.get(isbn);
        if (book != null) {
        	System.out.println(book.getTitle() + " | ISBN: " + book.getIsbn() + " | " + book.getPrice());
        } else {
        	System.out.println("Buch nicht gefunden.");
        }
        sc.close();
        

	}

}
