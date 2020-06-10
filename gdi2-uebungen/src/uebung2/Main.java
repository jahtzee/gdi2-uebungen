package uebung2;

import java.io.FileNotFoundException;
//import java.io.IOException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Quiz z = new Quiz("P:\\Programme\\git\\gdi2-uebungen\\gdi2-uebungen\\src\\uebung2\\questions.csv", 4);
		z.start();
		z.results();
	}
	
}
