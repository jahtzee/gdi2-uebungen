package test1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class LayoutHBox extends Application {

  @Override
  public void start(Stage stage) throws Exception {
    Button b1 = new Button("Demotext");
    Button b2 = new Button("Save");
    Button b3 = new Button("Exit");

    HBox box = new HBox(10);// Abstand zwischen den Elementen 10 Pixel
    box.setPadding(new Insets(20, 15, 20, 15)); // top, right, bottom, left  

    box.getChildren().addAll(b1, b2, b3); // Buttons in den Container aufnehmen
    box.setAlignment(Pos.TOP_CENTER); // Elemente werden zentriert dargestellt

    HBox.setHgrow(b2, Priority.ALWAYS); // b2 darf wachsen
    b2.setMaxWidth(300); // bis max. 300 Pixel

    Scene scene = new Scene(box);
    scene.getStylesheets().add("/fx/css/style.css");
    stage.setScene(scene);
    stage.setTitle("HBox Demo");
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
