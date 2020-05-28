package test1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class EingabeFormular extends Application {

  @Override
  public void start(Stage stage) {

    GridPane g = new GridPane();
    g.setHgap(4); g.setVgap(4);
    g.setPadding(new Insets(5,5,5,5));
        
    g.add(new Label("Name"), 0, 0);
    TextField name = new TextField();
    g.add(name, 1, 0);

    g.add(new Label("Vorname"), 0, 1);
    TextField vname = new TextField();
    vname.setPromptText("Pflichtfeld");
    g.add(vname, 1, 1);

    HBox box = new HBox(5);
    box.setAlignment(Pos.BASELINE_RIGHT);
    Button ok = new Button("OK");
    Button cancel = new Button("Cancel");

    box.getChildren().addAll(cancel, ok);
    g.add(box, 0, 2, 2, 1);

    Scene scene = new Scene(g);
    scene.getStylesheets().add("/fx/css/style.css");
    stage.setScene(scene);
    stage.setTitle("Formular");
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}
