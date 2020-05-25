package uebung8;

public class BankKunde implements Runnable {
	private String name;
	private Konto k;
	private int bargeld = 0;

	BankKunde(String name, Konto k) {
		this.setName(name);
		this.k = k;
	}
	
	public int getBargeld() {
		return this.bargeld;
	}

	@Override
	public void run() {
		//synchronized (k) {
			if (k.getKontostand() >= 10)
				this.bargeld += k.abbuchen(10);
		//}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
