package uebung12;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalcController {

	private CalcExpression expression;
	private int resultValue;
	Button[] numberButtons;
	Button[] operatorButtons;

	@FXML
	private Label expressionLabel;

	@FXML
	private Button oneBtn;

	@FXML
	private Button twoBtn;

	@FXML
	private Button threeBtn;

	@FXML
	private Button fourBtn;

	@FXML
	private Button fiveBtn;

	@FXML
	private Button sixBtn;

	@FXML
	private Button sevenBtn;

	@FXML
	private Button eightBtn;

	@FXML
	private Button nineBtn;

	@FXML
	private Button zeroBtn;

	@FXML
	private Button plusBtn;

	@FXML
	private Button minusBtn;

	@FXML
	private Button multBtn;

	@FXML
	private Button divBtn;

	@FXML
	private Button evalBtn;

	@FXML
	private Button cBtn;

	public void initialize() {
		// Instantiate a new expression object
		expression = new CalcExpression();

		// Clear the expressionLabel
		expressionLabel.setText("");

		// For convenience
		numberButtons = new Button[] { oneBtn, twoBtn, threeBtn, fourBtn, fiveBtn, sixBtn, sevenBtn, eightBtn, nineBtn,
				zeroBtn };
		operatorButtons = new Button[] { plusBtn, minusBtn, multBtn, divBtn };

		// Disable the operator buttons. They must not be enabled while there is no
		// first operator yet
		disableOperatorButtons();

		// Disable the eval button. It must not be enabled while there is no valid
		// expression yet
		evalBtn.setDisable(true);

		// Enable number buttons, if disabled
		if (oneBtn.isDisabled())
			enableNumberButtons();
	}

	// Event Listener on evalBtn
	@FXML
	void evaluateExpression(ActionEvent event) {
		// Set operand2 equal to the number buffer contents and clear the buffer
		expression.setOperand2();
		resultValue = expression.evaluate();
		refreshExpressionLabel();
	}

	// Event Listener on the number Buttons
	@FXML
	void newNumberEntered(ActionEvent event) {
		String number = ((Button) event.getSource()).getText();
		expression.addToNumberBuffer(number);
		refreshExpressionLabel();
		if (plusBtn.isDisabled() && !expression.isOperand1Set())
			enableOperatorButtons();
		if (expression.isOperand1Set() && !expression.isNumberBufferEmpty())
			evalBtn.setDisable(false);
	}

	// Event Listener on the operator Buttons
	@FXML
	void newOperatorEntered(ActionEvent event) {
		disableOperatorButtons();
		String operator = ((Button) event.getSource()).getText().toLowerCase();
		expression.setOperator(operator);
		// Set operand1 equal to the number buffer contents and clear the buffer
		expression.setOperand1();
		refreshExpressionLabel();
	}

	// Refresh the displayed expression in the expressionLabel
	private void refreshExpressionLabel() {
		if (!expression.isOperand1Set()) {
			expressionLabel.setText("" + expression.getNumberBufferString());
		} else if (!expression.isOperand2Set()) {
			expressionLabel.setText(
					expression.getOperand1() + expression.getOperatorSymbol() + expression.getNumberBufferString());
		} else {
			expressionLabel.setText(expression.getOperand1() + expression.getOperatorSymbol() + expression.getOperand2()
					+ "=" + resultValue);
			disableAllButtons();
		}
	}

	private void enableOperatorButtons() {
		for (Button b : operatorButtons) {
			b.setDisable(false);
		}
	}

	private void disableOperatorButtons() {
		for (Button b : operatorButtons) {
			b.setDisable(true);
		}
	}

	private void disableNumberButtons() {
		for (Button b : numberButtons) {
			b.setDisable(true);
		}
	}

	private void enableNumberButtons() {
		for (Button b : numberButtons) {
			b.setDisable(false);
		}
	}

	private void disableAllButtons() {
		disableOperatorButtons();
		disableNumberButtons();
		evalBtn.setDisable(true);
	}
}
