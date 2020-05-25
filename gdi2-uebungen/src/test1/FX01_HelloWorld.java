package test1;

import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class FX01_HelloWorld extends Application{

	public static void main(String[] args) {
		launch();

	}

	@Override
	public void start(Stage stage) throws Exception {
		Label label = new Label("Hello World!");
		label.setStyle("-fx-font:24px Tahoma");
		Scene szene = new Scene(label);
		
		stage.setScene(szene);
		stage.setTitle("Meine Anwendung");
		stage.show();
	}

}
