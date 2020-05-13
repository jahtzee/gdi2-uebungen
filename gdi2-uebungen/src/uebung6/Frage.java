package uebung6;

import java.util.LinkedList;

public class Frage {

    private String frageText; // Der Text der Frage
    private LinkedList<String> antworten; // Die Antwortmöglichkeiten
    private int korrekteAntwort; // Die Nr der korrekten Antwort
    private int gegebeneAntwort; // Die Nr der vom Nutzer gegebenen Antwort
    private int id;

    private static int counter = 1;

    Frage(String frageText, LinkedList<String> antworten, int korrekteAntwort){
        this.frageText = frageText;
        this.antworten = antworten;
        this.korrekteAntwort = korrekteAntwort;
        this.gegebeneAntwort = 99;
        this.id = counter++;
    }

    // Konstruktor der anhand einer eingelesen Zeile aus der .csv-Datei
    // eine Frage erstellt.
    public Frage(String zeile){
        // auftrennen des Strings am Trennzeichen ;
        try {
			String[] parts = zeile.split(";");

			// die drei Antworten
			LinkedList<String> antworten = new LinkedList<String>();
			antworten.add(parts[1]);
			antworten.add(parts[2]);
			antworten.add(parts[3]);

			this.frageText = parts[0];
			this.antworten = antworten;
			this.korrekteAntwort = Integer.parseInt(parts[4]);
			this.id = counter++;
		} catch (Exception e) {
			System.out.println("Zeile fehlerhaft!");
			return;
		}
    }

    public String getFrageText() {
        return frageText;
    }

    public LinkedList<String> getAntworten() {
        return antworten;
    }

    public void setGegebeneAntwort(int gegebeneAntwort) {
        this.gegebeneAntwort = gegebeneAntwort;
    }

    public int getKorrekteAntwort() {
        return korrekteAntwort;
    }

    public int getGegebeneAntwort() {
        return gegebeneAntwort;
    }

    @Override
    public String toString() {
        return "Frage{" +
                "frageText='" + frageText + '\'' +
                ", antworten=" + antworten +
                ", korrekteAntwort=" + korrekteAntwort +
                ", gegebeneAntwort=" + gegebeneAntwort +
                ", id=" + id +
                '}';
    }
}