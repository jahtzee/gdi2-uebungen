package uebung2;

import java.io.*;
import java.util.Scanner;

public class Quiz {
	Question[] questions;
	String[] givenAnswers;
	int questionAmount;
	Scanner sc;
	
	public Quiz(String path, int questionAmount) throws FileNotFoundException {
		this.questionAmount = questionAmount;
		this.questions = new Question[this.questionAmount];
		this.givenAnswers = new String[this.questionAmount];
		sc = new Scanner(new File (path));
		
		for (int i = 0; i < this.questionAmount; i++) {
			questions[i] = new Question(sc.nextLine());
		}
		sc.close();
	}
	
	public void printQuestions() {
		for (Question q : questions) {
			System.out.println(q);
		}
	}
	
	public void printAnswers() {
		for (String a : givenAnswers) {
			System.out.println(a);
		}
	}
	
	public void start() {
		int count = 0;
		sc = new Scanner(System.in);
		System.out.print("Willkommen beim GDI II Quiz\r\n"
				+ "-------------------------------------");
		for (Question q : questions) {
			System.out.print("\r\n\r\n" + ++count + ". Frage:\r\n"
					+ "--------------------------------\r\n"
					+ q.getQuestion()+"\r\n"
					+ "--------------------------------\r\n"
					+ "1.  " + (q.getAnswers()[0]) + "\r\n"
					+ "2.  " + (q.getAnswers()[1]) + "\r\n"
					+ "3.  " + (q.getAnswers()[2]) + "\r\n"
					+ "--------------------------------\r\n");
			System.out.print("Meine Antwort: ");
			givenAnswers[count-1] = sc.nextLine();
			if (givenAnswers[count-1] != null) {
				while (!(givenAnswers[count-1].equals("1")) && !(givenAnswers[count-1].equals("2")) && !(givenAnswers[count-1].equals("3"))) {
					System.out.print("Meine Antwort: ");
					givenAnswers[count - 1] = sc.nextLine();
				} 
			}
		}
	}
	
	public void results() {
		int count = 0;
		int points = 0;
		System.out.print("-------------------------------------\r\n" + 
				"GDI II Quiz - Auswertung\r\n" + 
				"-------------------------------------");
		for (Question q : questions) {
			System.out.print("\r\nFrage " + ++count + " : " + q.getQuestion() + "\r\n"
					+ "Korrekte Antwort: " + q.getAnswers()[q.getCorrectAnswerNr()-1] + "\r\n"
					+ "Gegebene Antwort: " + q.getAnswers()[Integer.parseInt(this.givenAnswers[count-1])-1] + "\r\n"
					+ "-------------------------------------");
			if (q.getCorrectAnswerNr() == Integer.parseInt(this.givenAnswers[count-1])) {
				points++;
			}
		}
		System.out.println("\r\nRichtige Antworten : " + points + "\r\n"
				+ "Falsche Antworten : " + (this.questionAmount-points));
	}
}
