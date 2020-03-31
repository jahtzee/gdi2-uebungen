package uebung2;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		Questionnaire q = new Questionnaire(2, "P:\\Programme\\git\\gdi2-uebungen\\gdi2-uebungen\\src\\uebung2\\questions.csv");
		q.recordQuestions();
		try {
			q.saveQuestionnaire();
		} catch (IOException e) {
			System.err.println("This shouldn't have happened.");
			e.printStackTrace();
		}
	}
	
}
