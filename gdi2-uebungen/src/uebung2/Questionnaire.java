package uebung2;

import java.io.*;
import java.util.Scanner;

public class Questionnaire {

	private Question[] questions;
	private int amount;
	private String path;

	public Questionnaire(int amount, String path) {
		this.amount = amount;
		this.path = path;
		this.questions = new Question[this.amount];
	}

	public void recordQuestions() {
		for (int i = 0; i < this.amount; i++) {
			this.recordQuestion();
		}
	}

	public void recordQuestion() {

		Scanner sc = new Scanner(System.in);
		String[] answers = new String[3];
		String question = "";
		int answer = 0;

		System.out.println("Fragenkatalog Generator :\r\n" + "---------------------------------------\r\n"
				+ "1. Frage - Bitte Fragetext eingeben :\r\n" + "---------------------------------------\r\n");
		
		//DEBUG
		if (!sc.hasNextLine()){
			System.err.println("There is no next line!");
		}
		//DEBUG
		
		question = sc.nextLine();
		System.out.println("1. Antwortmoeglichkeit eingeben :");
		answers[0] = sc.nextLine();
		System.out.println("2. Antwortmoeglichkeit eingeben :");
		answers[1] = sc.nextLine();
		System.out.println("3. Antwortmoeglichkeit eingeben :");
		answers[2] = sc.nextLine();
		System.out.println("Welche der Antworten ist korrekt (1, 2, 3)?");
		answer = sc.nextInt();

		Question q = new Question(question, answers, answer);

		for (int i = 0; i < questions.length; i++) {
			if (questions[i] == null) {
				questions[i] = q;
				break;
			}
		}

		sc.close();
	}

	public void saveQuestionnaire() throws IOException {
		File f = new File(path);
		PrintWriter pWriter = new PrintWriter(f);
		for (Question question : this.questions) {
			pWriter.print(question + "\n\r");
		}
		pWriter.flush();
		pWriter.close();
	}
}
