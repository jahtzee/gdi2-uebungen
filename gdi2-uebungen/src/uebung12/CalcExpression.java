package uebung12;

import java.util.InputMismatchException;

public class CalcExpression {
	private Integer operand1;
	private Integer operand2;
	private String operator;
	private String numberBuffer = "";
	
	public int evaluate() {
		switch (operator) {
		
		case "add":
			return evaluateAdd();
			
		case "sub":
			return evaluateSub();
			
		case "mul":
			return evaluateMul();
			
		case "div":
			return evaluateDiv();
		
		default:
			//System.err.println("Error: No operator found. Returning 0.");
			//return 0;
			throw new InputMismatchException();
		}
	}
	
	private int evaluateAdd() {
		return operand1+operand2;
	}
	
	private int evaluateSub() {
		return operand1-operand2;
	}
	
	private int evaluateMul() {
		return operand1*operand2;
	}
	
	private int evaluateDiv() {
		if (operand2.equals(0)) {
			System.err.println("Pls don't do that.");
			throw new ArithmeticException();
		}
		return operand1/operand2;
	}
	public boolean isOperand1Set() {
		if (operand1 != null) {
			return true;
		}
		return false;
	}
	public boolean isOperand2Set() {
		if (operand2 != null) {
			return true;
		}
		return false;
	}
	
	//Getters and setters
	public int getOperand1() {
		return operand1;
	}
	public void setOperand1() {
		this.operand1 = getNumberBuffer();
		setNumberBuffer("");
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public void setOperand2() {
		this.operand2 = getNumberBuffer();
		setNumberBuffer("");
	}
	public int getOperand2() {
		return operand2;
	}
	public int getNumberBuffer() {
		return Integer.parseInt(this.numberBuffer);
	}
	public String getNumberBufferString() {
		return numberBuffer;
	}
	public boolean isNumberBufferEmpty() {
		if (numberBuffer.equals("")) {
			return true;
		}
		return false;
	}
	private void setNumberBuffer(String numberBuffer) {
		this.numberBuffer = numberBuffer;
	}
	public void addToNumberBuffer(String number) {
		numberBuffer = this.numberBuffer + number;
	}
	public String getOperatorSymbol() {
		switch (operator) {
		
		case "add":
			return "+";
			
		case "sub":
			return "-";
			
		case "mul":
			return "*";
			
		case "div":
			return "/";
		
		default:
			//System.err.println("Error: No operator found. Returning empty string.");
			//return "";
			throw new InputMismatchException();
		}
	}
	
}
