package uebung10;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import uebung2.Quiz;
 
public class Wwm extends Application {
 
   @Override
   public void start(Stage primaryStage) throws Exception {
	   
	   Quiz z = new Quiz("P:\\Programme\\git\\gdi2-uebungen\\gdi2-uebungen\\src\\uebung2\\questions.csv", 4);
	   //z.printQuestions();

	   // Schriftart festlegen
	   final int fontSize = 15;
	   final String font = "Verdana";
	   Font schriftart = new Font(font,fontSize);
	   
	   // GradPane zur Anordnung aller Elemente
       GridPane root = new GridPane();
 
       // Padding - Abstand zum Fensterrand
       root.setPadding(new Insets(10));
       
       // horizontaler / vertikaler Abstand zwischen Elementen
       root.setHgap(25);
       root.setVgap(15);
 
       // Fragetext
       Label lblFrage = new Label(z.getQuestions()[z.getProgress()].getQuestion());
       lblFrage.setFont(schriftart);
        
       // vier Buttons fuer die Antwortmoeglichkeiten
       Button btnF1 = new Button(z.getQuestions()[z.getProgress()].getAnswers()[0]);
       Button btnF2 = new Button(z.getQuestions()[z.getProgress()].getAnswers()[1]);
       Button btnF3 = new Button(z.getQuestions()[z.getProgress()].getAnswers()[2]);
       Button btnF4 = new Button(z.getQuestions()[z.getProgress()].getAnswers()[3]);
       Button btnAbsenden = new Button("Antwort absenden!");
       
       //Antwort Auswahl Handler
       EventHandler<ActionEvent> ae = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent e) {
			if (e.getSource().equals(btnF1)) {
				z.setSelection("1");
			} else if (e.getSource().equals(btnF2)) {
				z.setSelection("2");
			} else if (e.getSource().equals(btnF3)) {
				z.setSelection("3");
			} else if (e.getSource().equals(btnF4)) {
				z.setSelection("4");
			}
			//System.out.println(z.getSelection());
		} 
       };
       
       btnF1.setOnAction(ae);
       btnF2.setOnAction(ae);
       btnF3.setOnAction(ae);
       btnF4.setOnAction(ae);
       
       //Antwort Absenden Handler
       EventHandler<ActionEvent> registerAnswerHandler = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			if (z.getProgress() >= 4) {
				System.err.println("Es kann keine weitere Antwort ausgewählt werden!");
				return;
			}
			
			if (z.getSelection() != null){
				z.registerCurrentSelectionToAnswers();
				z.setProgress(z.getProgress()+1);
				if (z.getProgress() >= 4) {
					z.results();
					btnAbsenden.setDisable(true);
					btnF1.setDisable(true);
					btnF2.setDisable(true);
					btnF3.setDisable(true);
					btnF4.setDisable(true);
				} else {
					lblFrage.setText(z.getQuestions()[z.getProgress()].getQuestion());
					btnF1.setText(z.getQuestions()[z.getProgress()].getAnswers()[0]);
					btnF2.setText(z.getQuestions()[z.getProgress()].getAnswers()[1]);
					btnF3.setText(z.getQuestions()[z.getProgress()].getAnswers()[2]);
					btnF4.setText(z.getQuestions()[z.getProgress()].getAnswers()[3]);
				}
			} else {
				System.err.println("Es wurde noch keine Antwort gewählt!");
			}
		}
    	   
       };
       
       btnAbsenden.setOnAction(registerAnswerHandler);
              
       // Schriftart der Buttons setzen
       btnF1.setFont(schriftart);
       btnF2.setFont(schriftart);
       btnF3.setFont(schriftart);
       btnF4.setFont(schriftart);
       btnAbsenden.setFont(schriftart);     
       
       // Mindestbreite Buttons
       btnF1.setMinWidth(250);
       btnF2.setMinWidth(250);
       btnF3.setMinWidth(250);
       btnF4.setMinWidth(250);
       btnF4.setMaxWidth(250);
       btnAbsenden.setMinWidth(250);
       
       // einen Button einfärben
       /*
       String css = "-fx-background-color:\n" + 
          		"        linear-gradient(#f0ff35, #a9ff00),\n" + 
           		"        radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);\n" + 
           		"    -fx-background-radius: 6, 5;\n" + 
           		"    -fx-background-insets: 0, 1;\n" + 
           		"    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );\n" + 
           		"    -fx-text-fill: #395306;";
       btnF1.setStyle(css);
       */ 
       
       
       // Alle Elemente zur GridPane hinzufuegen
       root.add(lblFrage,0,0,2,1);
       
       root.add(btnF1,0,1); // Spalte 0, Zeile 1
       root.add(btnF2,1,1); // Spalte 1, Zeile 1
       root.add(btnF3,0,2); // Spalte 0, Zeile 2
       root.add(btnF4,1,2); // Spalte 1, Zeile 2
       
       root.add(btnAbsenden, 0,3,2,1);
 
       GridPane.setHalignment(btnAbsenden, HPos.CENTER);
       GridPane.setHalignment(lblFrage, HPos.CENTER);
 
       Scene scene = new Scene(root, 550, 250);
       primaryStage.setTitle("GDI II - Wer wird Millionär");
       primaryStage.setScene(scene);
       primaryStage.show();
   }
 
   public static void main(String[] args) {
       launch(args);
   }
 
}