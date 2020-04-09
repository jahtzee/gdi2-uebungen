package uebung3;

public class Kruskal {

	public static final int MAX_KNOTEN = 20;
	public static final int MAX_KANTEN = 50;

	public static void main(String[] args) {
		Knoten[] knoten = new Knoten[MAX_KNOTEN];
		Kante[] kanten = new Kante[MAX_KANTEN];

		Komponente[] komponenten = new Komponente[MAX_KNOTEN];

		// TODO : Lies Knoten von Datei ein - maximal: MAX_KNOTEN
		knoten[0] = new Knoten("ZW");
		knoten[1] = new Knoten("KL");
		knoten[2] = new Knoten("HD");
		knoten[3] = new Knoten("SB");
		knoten[4] = new Knoten("KA");

		// TODO : Lies Kanten von Datei ein - maximal MAX_KANTEN
		kanten[0] = new Kante(knoten[0], knoten[3], 40);
		kanten[1] = new Kante(knoten[0], knoten[1], 50);
		kanten[2] = new Kante(knoten[4], knoten[2], 55);
		kanten[3] = new Kante(knoten[3], knoten[1], 70);

		// Komponenten anlegen - zu Beginn eine je Knoten
		for (int i = 0; i < 5; i++) {
			komponenten[i] = new Komponente(MAX_KNOTEN, MAX_KANTEN, knoten[0]);
		}

		// TODO: Algorithmus ausfuehren
		// Für jede Kante: In welcher Komponente befinden sich die Knoten? Über Komponenten drüberlaufen und für start und ende jeweils testen, ob sie in der komponente vorkommen.
		// Falls für beide ein true zurückkommt, ist nichts zu tun. falls einer von beiden true liefert, ist die komponente zu finden, in der der andere knoten vorkommt und dann die verschmelze methode aufrufen.
		int knr = 0;
		while (kanten[knr] != null) {
			// TODO
		}
	}

}
