package test1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class LayoutFlowPane extends Application {
  @Override
  public void start(Stage stage) throws Exception {
    FlowPane f = addFlowPane();
//    f.setStyle("-fx-background-color: cornflowerblue");
    
    Scene scene = new Scene(f);
    scene.getStylesheets().add("fx/css/style.css");
    stage.setScene(scene);
    stage.setTitle("FlowPanel Demo");
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

  private FlowPane addFlowPane() {
    FlowPane flow = new FlowPane();
    flow.setPadding(new Insets(5, 0, 5, 0));
    flow.setVgap(10);
    flow.setHgap(10);
    flow.setPrefWrapLength(170); // bevorzugte Laenge

    for (int i = 1; i <= 8; i++) {
      // Button x = new Button("Nr " + i);
      ImageView v = new ImageView(new Image("/fx/graphics/chart_" + i + ".png"));
      Button x = new Button("", v);
      flow.getChildren().add(x);
    }

    return flow;
  }
}
