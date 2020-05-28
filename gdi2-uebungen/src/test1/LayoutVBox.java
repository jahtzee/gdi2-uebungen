package test1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LayoutVBox extends Application {

  @Override
  public void start(Stage stage) {

    String javaVersion = System.getProperty("java.version");
    String javafxVersion = System.getProperty("javafx.version");
    
    Label l1 = new Label("Hello World!");
    Label l2 = new Label("This is JavaFX " + javafxVersion);
    Label l3 = new Label("Running on Java " + javaVersion);
    l2.setStyle("-fx-text-fill:red"); // überschreiben

    VBox box = new VBox(10);
    box.getChildren().addAll(l1, l2, l3);
    
    Scene scene = new Scene(box);
    scene.getStylesheets().add("/fx/css/style.css");
    stage.setScene(scene);
    stage.setTitle("VBox Demo");
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}
