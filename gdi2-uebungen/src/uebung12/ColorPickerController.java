package uebung12;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class ColorPickerController {

    @FXML
    private Label colorLabel;

    @FXML
    private Slider redSlider;

    @FXML
    private Label redSliderLabel;

    @FXML
    private Slider greenSlider;

    @FXML
    private Label greenSliderLabel;

    @FXML
    private Slider blueSlider;

    @FXML
    private Label blueSliderLabel;

    @FXML
    private Label textLabel;

    @FXML
    private Button button;
    
    public void initialize() {
    	//Set color label default to red
    	colorLabel.setBackground(new Background (new BackgroundFill(Color.rgb(255,0,0), null, null)));
    	
    	//Add Listeners to all the ValueProperties of the 3 sliders, that change the background color of colorLabel
    	redSlider.valueProperty().addListener( (ov, old_val, new_val) -> colorLabel.setBackground(new Background (new BackgroundFill(Color.rgb(new_val.intValue(),(int) greenSlider.getValue(),(int) blueSlider.getValue()), null, null))) );
		greenSlider.valueProperty().addListener( (ov, old_val, new_val) -> colorLabel.setBackground(new Background (new BackgroundFill(Color.rgb((int) redSlider.getValue(),new_val.intValue(),0), null, null))) );
		blueSlider.valueProperty().addListener( (ov, old_val, new_val) -> colorLabel.setBackground(new Background (new BackgroundFill(Color.rgb((int) redSlider.getValue(),(int) greenSlider.getValue(),new_val.intValue()), null, null))) );
		
		//
		button.setOnAction( ev -> {
			textLabel.setText("Current color value: "+ (int) redSlider.getValue() +","+ (int) greenSlider.getValue() +","+ (int) blueSlider.getValue());
			textLabel.setTextFill(Color.rgb((int) redSlider.getValue(), (int) greenSlider.getValue(), (int) blueSlider.getValue()));
		} );
    }

}
