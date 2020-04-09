package uebung3;

public class Komponente {
	private Knoten[] knoten;
	private int anz_knoten = 0;
	private Kante[] kanten;
	private int anz_kanten = 0;

	public Komponente(int n, int m, Knoten k) {
		this.knoten = new Knoten[n];
		this.kanten = new Kante[m];
		this.knoten[anz_knoten] = k;
		anz_knoten++;
	}

	@Override
	public String toString() {
		String ausgabe = "Knoten: ";
		for (int i = 0; i < this.anz_knoten; i++)
			ausgabe += knoten[i] + ", ";
		ausgabe += "\nKanten: ";
		for (int i = 0; i < this.anz_kanten; i++)
			ausgabe += kanten[i] + ", ";

		return ausgabe;
	}

	public boolean enthaeltKnoten(Knoten k) {
		for (Knoten aktuellerKnoten : this.knoten) {
			if (k.getName() == aktuellerKnoten.getName()) {
				return true;
			}
		}
		return false;
	}

	public void verschmelzeMit(Komponente ko, Kante ka) {
		for (Knoten neuerKnoten : ko.knoten) {
			this.knoten[anz_knoten++] = neuerKnoten;
		}
		for (Kante neueKante : ko.kanten) {
			this.kanten[anz_kanten++] = neueKante;
		}
		this.kanten[anz_kanten++] = ka;
	}
}