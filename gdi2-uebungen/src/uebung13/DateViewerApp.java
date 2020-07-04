package uebung13;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DateViewerApp extends Application{

	public static void main(String args[]) {
		launch();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		URL fxml = getClass().getResource("DateViewer.fxml");
		Parent root = FXMLLoader.load(fxml);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Date viewer");
		primaryStage.show();
	}

}
