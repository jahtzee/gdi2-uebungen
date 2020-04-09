package uebung3;

public class Kante {
	private Knoten start;
	private Knoten ziel;
	private int kosten;

	public Kante(Knoten start, Knoten ziel, int kosten) {
		this.kosten = kosten;
		this.start = start;
		this.ziel = ziel;
	}

	@Override
	public String toString() {
		return "(" + start + "," + ziel + "," + kosten + ")";
	}

	// ========== ab hier nur getter/setter ==========

	public int getKosten() {
		return kosten;
	}

	public Knoten getStart() {
		return start;
	}

	public Knoten getZiel() {
		return ziel;
	}
}