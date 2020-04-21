package uebung2;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Eingeben!");
		int i;
		while (sc.hasNextInt()) {
			i = sc.nextInt();
			System.out.println(i);
		}
		System.out.println("Fertig");
		sc.close();

	}

}
