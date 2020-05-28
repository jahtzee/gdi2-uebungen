package test1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LayoutGridPane extends Application {

  @Override
  public void start(Stage stage) {

    GridPane grid = new GridPane();
    grid.setHgap(25);
    grid.setVgap(25);
    
    grid.add(new Label("Hello World !"), 0, 0, 2, 1);// Spalte=0, Zeile=0 AnzahlSpalten=2, AnzahlZeilen=1
    
    grid.add(new Label("Java Version"), 0, 2); // Spalte=0, Zeile=2
    grid.add(new Label(System.getProperty("java.version")), 1, 2);
    
    grid.add(new Label("JavaFX Version"), 0, 1); // Spalte=0, Zeile=1
    grid.add(new Label(System.getProperty("javafx.version")), 1, 1);
    grid.setGridLinesVisible(true);

    Scene scene = new Scene(grid);
    scene.getStylesheets().add("/fx/css/style.css");
    stage.setScene(scene);
    stage.setTitle("GridPane Demo");
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}
