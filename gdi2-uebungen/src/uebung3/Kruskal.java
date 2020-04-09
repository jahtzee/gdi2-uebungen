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
		kanten[0] = new Kante(knoten[1], knoten[2], 1);
		kanten[1] = new Kante(knoten[0], knoten[3], 40);
		kanten[2] = new Kante(knoten[0], knoten[1], 50);
		kanten[3] = new Kante(knoten[4], knoten[2], 55);
		kanten[4] = new Kante(knoten[3], knoten[1], 70);
		kanten[5] = new Kante(knoten[1], knoten[4], 75);


		// Komponenten anlegen - zu Beginn eine je Knoten
		for (int i = 0; i < 5; i++) {
			komponenten[i] = new Komponente(MAX_KNOTEN, MAX_KANTEN, knoten[i]);
		}

		// Algorithmus ausfuehren
		int knr = 0;
		while (kanten[knr] != null) {
			for (Komponente startKomponente : komponenten) {
				if (startKomponente != null && startKomponente.enthaeltKnoten(kanten[knr].getStart())) {
					if (!(startKomponente.enthaeltKnoten(kanten[knr].getZiel()))) {
						for (Komponente zielKomponente : komponenten) {
							if (zielKomponente != null && zielKomponente.enthaeltKnoten(kanten[knr].getZiel())) {
								startKomponente.verschmelzeMit(zielKomponente, kanten[knr]);
							}
						}
					}
				}
			}
			knr++;
		}
		
		for (Komponente komponente : komponenten) {
			System.out.println("================");
			System.out.println(komponente);
		}
		
		int indexKorrekt = 0;
		int index = 0;
		for (Komponente komponente : komponenten) {
			if (komponente != null) {
				boolean alleKnotenVorhanden = true;
				for (Knoten aktuellerKnoten : knoten) {
					if (aktuellerKnoten != null && !(komponente.enthaeltKnoten(aktuellerKnoten))) {
						alleKnotenVorhanden = false;
					}
				}
				if (alleKnotenVorhanden == true && komponente.getKostenSumme() < komponenten[indexKorrekt].getKostenSumme()) {
					indexKorrekt = index;
				}
			}
			index++;
		}
		System.out.println("Ergebnis:   " + komponenten[indexKorrekt]);
	}

}
