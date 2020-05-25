package uebung8;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Konto gemeinschaftsKonto = new Konto(10000);
		BankKunde andre = new BankKunde(" Andre ", gemeinschaftsKonto);
		BankKunde mathias = new BankKunde(" Mathias ", gemeinschaftsKonto);
		
		while (gemeinschaftsKonto.getKontostand() > 9) {
			Thread t1 = new Thread(andre);
			Thread t2 = new Thread(mathias);
			t1.start();
			t2.start();
			t1.join();
			t2.join();
		}

		System.out.println("Summe beider Kontostände: "+andre.getBargeld()+" + "+mathias.getBargeld()+" = "+(mathias.getBargeld()+andre.getBargeld()));
	}

}
