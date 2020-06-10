package uebung2;

public class Question {
	static int lastId = 1;
	
	private String question;
	private String[] answers;
	private int correctAnswerNr;
	private int playerAnswerNr;
	private int id;
	
	public Question(String question, String[] answers, int correctAnswerNr) {
		this.question = question;
		this.answers = answers;
		this.correctAnswerNr = correctAnswerNr;
		this.id = lastId;
		lastId++;
	}
	
	public Question(String line) {
		String[] data = line.split(";");
		this.question = data[0];
		this.answers = new String[] {data[1], data[2], data[3], data[4]};
		this.correctAnswerNr = Integer.parseInt(data[5]);
		this.id = lastId;
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
