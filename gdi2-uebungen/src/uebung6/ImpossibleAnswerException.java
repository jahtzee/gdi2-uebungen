package uebung6;

public class ImpossibleAnswerException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5959943313384849489L;

	public ImpossibleAnswerException() {
		super("Unmögliche Antwort angegeben!");
	}

}
