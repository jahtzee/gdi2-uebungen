package uebung2;

public class Question {
	static int lastId = 1;
	
	private String question;
	private String[] answers;
	private int correctAnswerNr;
	private int playerAnswerNr;
	private int id;
	
	public Question(String question, String[] answers, int correctAnswerNr) {
		this.setQuestion(question);
		this.setAnswers(answers);
		this.setCorrectAnswerNr(correctAnswerNr);
		this.setId(lastId);
		lastId++;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String[] getAnswers() {
		return answers;
	}

	public void setAnswers(String[] answers) {
		this.answers = answers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCorrectAnswerNr() {
		return correctAnswerNr;
	}

	public void setCorrectAnswerNr(int correctAnswerNr) {
		this.correctAnswerNr = correctAnswerNr;
	}

	public int getPlayerAnswerNr() {
		return playerAnswerNr;
	}

	public void setPlayerAnswerNr(int playerAnswerNr) {
		this.playerAnswerNr = playerAnswerNr;
	}
	
	@Override
	public String toString() {
		String str = this.question + ";";
		for (String answer : this.answers) {
			str += answer+";";
		}
		str += this.correctAnswerNr;
		return str;
	}
}
