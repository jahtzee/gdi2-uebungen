package uebung8;

public class Konto {
	private int kontostand;

	Konto(int kontostand) {
		this.kontostand = kontostand;
	}

	public int getKontostand() {
		return this.kontostand;
	}

	public synchronized int abbuchen(int betrag) {
		//synchronized (this) {
			this.kontostand -= betrag;
			return betrag;
		//}
	}
}
