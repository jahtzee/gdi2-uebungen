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
		int i = 0;
		while (this.knoten[i] != null && i < this.knoten.length) {
			if (k.getName() == this.knoten[i].getName()) {
				return true;
			}
			i++;
		}
		return false;

	}
	
	public boolean enthaeltKanten(Kante k) {
		int i = 0;
		while (this.kanten[i] != null && i < this.kanten.length) {
			if (this.kanten[i].equals(k)) {
				return true;
			}
			i++;
		}
		return false;

	}

	public void verschmelzeMit(Komponente ko, Kante ka) {
		for (Knoten neuerKnoten : ko.knoten) {
			if (neuerKnoten != null && !(this.enthaeltKnoten(neuerKnoten))) {
				this.knoten[anz_knoten] = neuerKnoten;
				anz_knoten++;
			}
		}
		for (Kante neueKante : ko.kanten) {
			if (neueKante != null && !(this.enthaeltKanten(neueKante))) {
				this.kanten[anz_kanten] = neueKante;
				anz_kanten++;
			}
		}
		if (!(this.enthaeltKanten(ka))) {
			this.kanten[anz_kanten] = ka;
			anz_kanten++;
		}
	}
	
	public Kante[] getKanten() {
		return this.kanten;
	}
	
	public int getKostenSumme() {
		int summe = 0;
		for (Kante kante : this.kanten) {
			if (kante != null) {
				summe += kante.getKosten();
			}
		}
		return summe;
	}
}