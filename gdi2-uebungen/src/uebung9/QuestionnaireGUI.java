package uebung9;

import javafx.collections.FXCollections;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class QuestionnaireGUI extends javafx.application.Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		// placeholder labels
		Label labelTop = new Label("Fragen anlegen:");
		TextField textbox = new TextField("Fragetext");
		Label answer1 = new Label("Antwortmöglichkeit 1");
		Label answer2 = new Label("Antwortmöglichkeit 2");
		Label answer3 = new Label("Antwortmöglichkeit 3");
		Label answer4 = new Label("Antwortmöglichkeit 4");
		String[] comboBoxOptions = {"Korrekte Antwort: 1", "Korrekte Antwort: 2", "Korrekte Antwort: 3", "Korrekte Antwort: 4"};
		ComboBox<String> comboBox = new ComboBox<String>(FXCollections.observableArrayList(comboBoxOptions));
		Button button = new Button("Frage speichern");
		
		// styling
		labelTop.getStyleClass().clear();
		labelTop.getStyleClass().add("label-top");
		GridPane.setHalignment(labelTop, HPos.CENTER);
		
		textbox.getStyleClass().clear();
		textbox.getStyleClass().add("textbox");
		GridPane.setHalignment(textbox, HPos.CENTER);
		
		comboBox.getStyleClass().add("combo-box");
		GridPane.setHalignment(comboBox, HPos.CENTER);
		
		GridPane.setHalignment(button, HPos.CENTER);
		
		// root node for scene is a grid
		GridPane grid = new GridPane();

		// add children
		grid.add(labelTop, 0, 0, 2, 1);
		grid.add(textbox, 0, 1, 2, 1);
		grid.add(answer1, 0, 2);
		grid.add(answer2, 1, 2);
		grid.add(answer3, 0, 3);
		grid.add(answer4, 1, 3);
		grid.add(comboBox, 0, 4, 2, 1);
		grid.add(button, 0, 5, 2, 1);

		// grid lines
		grid.setGridLinesVisible(false);
		
		//

		// scene graph
		Scene scene = new Scene(grid);
		scene.getStylesheets().add(getClass().getResource("style.css").toString());

		// staging
		primaryStage.setScene(scene);
		primaryStage.setTitle("Wer wird Millionär - Fragen erfassen");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch();
	}

}
