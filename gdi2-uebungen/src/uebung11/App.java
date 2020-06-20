package uebung11;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		// create root node
		GridPane root = new GridPane();

		// padding to window border
		root.setPadding(new Insets(10));
		root.setHgap(25);
		root.setVgap(15);
		
		// create label
		Label colorBox = new Label();
		colorBox.setText("");
		colorBox.setMinSize(100,100);
		colorBox.setBackground(new Background (new BackgroundFill(Color.rgb(255,0,0), null, null)));
		
		// create three sliders for R,G and B
		Slider redSlider = new Slider();
		redSlider.setMin(0);
		redSlider.setMax(255);
		redSlider.setValue(255);
		
		Slider greenSlider = new Slider();
		greenSlider.setMin(0);
		greenSlider.setMax(255);
		greenSlider.setValue(0);
		
		Slider blueSlider = new Slider();
		blueSlider.setMin(0);
		blueSlider.setMax(255);
		blueSlider.setValue(0);
		
		// add listeners to all sliders
		redSlider.valueProperty().addListener( (ov, old_val, new_val) -> colorBox.setBackground(new Background (new BackgroundFill(Color.rgb(new_val.intValue(),(int) greenSlider.getValue(),(int) blueSlider.getValue()), null, null))) );
		greenSlider.valueProperty().addListener( (ov, old_val, new_val) -> colorBox.setBackground(new Background (new BackgroundFill(Color.rgb((int) redSlider.getValue(),new_val.intValue(),0), null, null))) );
		blueSlider.valueProperty().addListener( (ov, old_val, new_val) -> colorBox.setBackground(new Background (new BackgroundFill(Color.rgb((int) redSlider.getValue(),(int) greenSlider.getValue(),new_val.intValue()), null, null))) );
		
		// text label
		Label text = new Label("Color");
		
		// confirm button
		Button btn = new Button("confirm");
		btn.setOnAction( ev -> {text.setTextFill(Color.rgb((int) redSlider.getValue(), (int) greenSlider.getValue(), (int) blueSlider.getValue()));} );
		
		// vbox for sliders
		VBox vbox = new VBox();
		vbox.getChildren().addAll(redSlider, greenSlider, blueSlider, text, btn);
		
		// add children to root
		root.add(colorBox, 1, 0);
		root.add(vbox, 0, 0);
		
		// create scene and show on stage
		Scene scene = new Scene(root, 250, 150);
		primaryStage.setTitle("Slider demo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
