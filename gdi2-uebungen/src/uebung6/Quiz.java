package uebung6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Quiz {

    // Speichert alle Quizfragen
    private LinkedList<Frage> quizfragen = new LinkedList<Frage>();

    private Scanner sc = new Scanner(System.in);


    // Konstruktor - ein Quiz erstellen
    public Quiz(String pfad, int anzahlFragen) {

        String[] fragenCSV = new String[anzahlFragen];

        File f = new File(pfad);
		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException e) {
			System.out.println("Die angegebene Datei konnte nicht gefunden werden.");
			sc.close();
		}

        int nr = 0;

        // Alle Fragen zeilenweise aus der Datei lesen
        while (sc.hasNext()) { // solange eine nächste Zeile existiert
            fragenCSV[nr++] = sc.nextLine();
        }

        // Aus den eingelesenen Datei Fragen erstellen
        for(int i = 0; i < anzahlFragen; i++) {

            // Wir übergeben jeweils eine Zeile aus der
            // gelesenen .csv Datei. Die Verarbeitung findet
            // im Konstruktor der Klasse Frage statt.
            Frage fr = new Frage(fragenCSV[i]);

            // Frage zum Array Quizfragen hinzufügen
            quizfragen.add(fr);
        }
        //sc.close();
    }

    // Das Quiz starten
    public void start() throws ImpossibleAnswerException{
    	sc = new Scanner(System.in);
    	
        System.out.println("Willkommen beim GDI II Quiz");
        System.out.println("-------------------------------------");

        int count = 1;

        // Die Fragen aus quizfragen nacheinander stellen
        for(Frage f : quizfragen){
            // Die Frage ausgeben
            System.out.println("Frage " + count++ + " : " + f.getFrageText());
            System.out.println("-------------------------------------");

            // Die Antwortmöglichkeiten ausgeben
            for(int j = 0; j < 3; j++){
                System.out.println((j+1)+". " + f.getAntworten().get(j));
            }

            // Der Nutzer antwortet auf die Frage
            System.out.println("-------------------------------------");
            f.setGegebeneAntwort(sc.nextInt());
			if (f.getGegebeneAntwort() > 3) {
				throw new ImpossibleAnswerException();
			}
        }
    }

    public void auswerten(){

        System.out.println("-------------------------------------");
        System.out.println("GDI II Quiz - Auswertung");
        System.out.println("-------------------------------------");

        int count = 1;
        int richtig = 0;
        int falsch = 0;

        List<String> antworten = new LinkedList<>();
        for(Frage f : quizfragen){

            if(f.getGegebeneAntwort() == f.getKorrekteAntwort()) {
                richtig++;
                antworten = f.getAntworten();
                System.out.println("Frage " + count++ + " :" + f.getFrageText());
                System.out.println("Korrekte Antwort: " + antworten.get(f.getKorrekteAntwort()-1));
                System.out.println("Gegebene Antwort: " + antworten.get(f.getGegebeneAntwort()-1));
                System.out.println("-------------------------------------");
            }
            else{
                falsch++;
                antworten = f.getAntworten();
                System.out.println("Frage " + count++ + " :" + f.getFrageText());
                System.out.println("Korrekte Antwort: " + antworten.get(f.getKorrekteAntwort()-1));
                System.out.println("Gegebene Antwort: " + antworten.get(f.getGegebeneAntwort()-1));
                System.out.println("-------------------------------------");
            }
        }
        System.out.println("Richtige Antworten : " + richtig);
        System.out.println("Falsche Antworten : " + falsch);

    }

    public static void main(String[] args) {
        // Der Pfad muss angepasst werden!
    	try {
			Quiz q = null;
			q = new Quiz("P:\\Programme\\git\\gdi2-uebungen\\gdi2-uebungen\\src\\uebung2\\questions.csv",2);
			q.start();
			q.auswerten();
		} catch (ImpossibleAnswerException e) {
			System.out.println(e.getMessage());
		}
    }

}
