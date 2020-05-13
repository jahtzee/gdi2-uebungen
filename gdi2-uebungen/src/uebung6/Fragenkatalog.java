package uebung6;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class Fragenkatalog {

    private LinkedList<Frage> fragen = new LinkedList<Frage>();
    private int anzahl;
    private Scanner sc = new Scanner(System.in);

    public Fragenkatalog(int anzahl, String pfad){
        this.anzahl = anzahl;
    }

    // Erfassung von Fragen ueber die Konsole
    // Es werden zu jeder Frage 3 Antwortmoeglichkeiten gespeichert
    public void erfasseFragen() throws ImpossibleAnswerException{

//            // Die richtige Antwort erfassen
//            System.out.println("Welche der Antworten ist korrekt (1,2,3)?");
//            korrekteAntwort = Integer.parseInt(sc.nextLine());


    	
        String fragetext = "";
        LinkedList<String> antworten = new LinkedList<String>();
        int korrekteAntwort = 0;

        System.out.println("Fragenkatalog Generator:");
        System.out.println("---------------------------------------");

        // Erfassen von anzahl Fragen
        for(int i = 0; i < anzahl; i++){
            System.out.println((i+1)+". Frage - Bitte Fragetext eingeben: ");
            System.out.println("---------------------------------------");
            fragetext = sc.nextLine();

            // Erfassen der Antwortmöglichkeiten
            antworten.clear();
            for(int j = 0; j < 3; j++) {
                System.out.println((j + 1) + ". Antwortmöglichkeit eingeben: ");
                antworten.add(sc.nextLine());
            }

            // Die richtige Antwort erfassen
			System.out.println("Welche der Antworten ist korrekt (1,2,3)?");
			while (true) {
				try {
					korrekteAntwort = Integer.parseInt(sc.nextLine());
					if (korrekteAntwort > 3) {
						throw new ImpossibleAnswerException();
					}
					break;
				} catch (NumberFormatException|ImpossibleAnswerException e) {
					System.out.println(e);
					sc = new Scanner(System.in);
				} 
			}
			// eine Frage erstellen und im Array fragen abspeichern
            Frage f = new Frage(fragetext,antworten,korrekteAntwort);
            fragen.add(f);

            System.out.println("---------------------------------------");
        }
    }

    public void speichereFragenkatalog() {
    	PrintWriter pWriter = null;
    	try {
    		pWriter = new PrintWriter("P:\\Programme\\git\\gdi2-uebungen\\gdi2-uebungen\\src\\uebung2\\questions.csv");
    	} catch (FileNotFoundException e) {
    		System.out.println("Die angegebene Datei konnte nicht gefunden werden.");
    	}

        LinkedList<String> antworten;

        // Die eingegebenen Fragen in die .csv Datei schreiben
        for (Frage f : fragen) {
            antworten = f.getAntworten();
            pWriter.printf(f.getFrageText()+";"+antworten.get(0)+";"+antworten.get(1)+";"+antworten.get(2)+";"+f.getKorrekteAntwort());
            pWriter.println();
        }

        pWriter.flush();
        pWriter.close();
    }

    public static void main(String[] args) {

    	Fragenkatalog f;
		try {
			f = new Fragenkatalog(2, "P:\\Programme\\git\\gdi2-uebungen\\gdi2-uebungen\\src\\uebung2\\questions.csv");
			f.erfasseFragen();
			f.speichereFragenkatalog();
		} catch (ImpossibleAnswerException e) {
			System.out.println(e.getMessage());
		}
    }
}