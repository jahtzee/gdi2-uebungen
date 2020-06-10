package uebung10;

import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.HPos;
//import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import uebung2.Question;
import uebung2.Questionnaire;
 
public class WwmSetQuestion extends Application {
 
   @Override
   public void start(Stage primaryStage) throws Exception {
	   //
	   Questionnaire qu = new Questionnaire(4, "P:\\Programme\\git\\gdi2-uebungen\\gdi2-uebungen\\src\\uebung2\\questions.csv");
	   
       GridPane root = new GridPane();
       root.setAlignment(Pos.CENTER);
       
       // Schriftart festlegen
       final int fontSize = 17;
	   final String font = "Verdana";
	   Font schriftart = new Font(font,fontSize);
 
	   // horizontaler / vertikaler Abstand zwischen Elementen
       root.setHgap(20);
       root.setVgap(15);
 
       Label lblFrageAnlegen = new Label("Frage anlegen:");
       lblFrageAnlegen.setTextAlignment(TextAlignment.CENTER);
       lblFrageAnlegen.setFont(schriftart);
 
       // Textfeld Frage
       TextField txtFrage = new TextField("Frage eingeben");
       txtFrage.setMaxWidth(520);
       txtFrage.setFont(schriftart);
       
       // Textfelder Antworten
       TextField txtA1 = new TextField("Antwortmoeglichkeit 1");
       TextField txtA2 = new TextField("Antwortmoeglichkeit 2");
       TextField txtA3 = new TextField("Antwortmoeglichkeit 3");
       TextField txtA4 = new TextField("Antwortmoeglichkeit 4");
       
       // Schriftart Textfelder setzen
       txtA1.setFont(schriftart);
       txtA2.setFont(schriftart);
       txtA3.setFont(schriftart);
       txtA4.setFont(schriftart);
       
       // Breite der Textfelder definieren
       txtA1.setMinWidth(250);
       txtA2.setMinWidth(250);
       txtA3.setMinWidth(250);
       txtA4.setMinWidth(250);
       
       // ChoiceBox zur Auswahl der korrekten Antwort
       ChoiceBox<String> CBkorrekteAntwort = new ChoiceBox<>();
       CBkorrekteAntwort.getItems().add("Antwort 1");
       CBkorrekteAntwort.getItems().add("Antwort 2");
       CBkorrekteAntwort.getItems().add("Antwort 3");
       CBkorrekteAntwort.getItems().add("Antwort 4");
       
       // Button: Frage abspeichern
       Button BtnAbsenden = new Button("Frage hinzufügen");
       BtnAbsenden.setMinWidth(250);
       
       EventHandler<ActionEvent> ae = new EventHandler<ActionEvent>() {
    	   @Override
    	   public void handle (ActionEvent e) {
    		   Question q = new Question(txtFrage.getText(), new String[] {txtA1.getText(), txtA2.getText(), txtA3.getText(), txtA4.getText()}, Integer.parseInt(CBkorrekteAntwort.getValue().substring(CBkorrekteAntwort.getValue().lastIndexOf(' ')+1)));
    		   qu.recordQuestionFromGUI(q);
    		   txtFrage.setText("Frage eingeben");
    		   txtA1.setText("Antwortmoeglichkeit 1");
    		   txtA2.setText("Antwortmoeglichkeit 2");
    		   txtA3.setText("Antwortmoeglichkeit 3");
    		   txtA4.setText("Antwortmoeglichkeit 4");
    		   if (qu.isQuestionnaireFull()) {
    			   BtnAbsenden.setDisable(true);
    		   }
    		   //CBkorrekteAntwort.setValue("");
    	   }
       };
       
       BtnAbsenden.setOnAction(ae);
       
       // Button: Abschließen
       Button BtnFinish = new Button("Fragen abspeichern");
       BtnFinish.setMinWidth(250);
       
       EventHandler<ActionEvent> finishAndSaveHandler = new EventHandler<ActionEvent>() {
    	   @Override
    	   public void handle(ActionEvent e) {
    		   try {
				qu.saveQuestionnaire();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.err.println("Es gab ein Problem beim Speichern!");
			}
    		   System.out.println("Fragen wurden gespeichert!");
    		   primaryStage.close();
    	   }
       };
       
       BtnFinish.setOnAction(finishAndSaveHandler);
       
       // Elemente zur GridPane hinzufuegen
       root.add(lblFrageAnlegen, 0,0,2,1);
       root.add(txtFrage, 0,1,2,1);
       root.add(txtA1, 0,2);
       root.add(txtA2, 1,2);
       root.add(txtA3, 0,3);
       root.add(txtA4, 1,3);
       root.add(CBkorrekteAntwort,0,4,2,1);
       root.add(BtnAbsenden, 0,5,2,1);
       root.add(BtnFinish, 0,6,2,1);
 
       GridPane.setHalignment(BtnAbsenden, HPos.CENTER);
       GridPane.setHalignment(BtnFinish, HPos.CENTER);
       GridPane.setHalignment(CBkorrekteAntwort, HPos.CENTER);
       GridPane.setHalignment(lblFrageAnlegen, HPos.CENTER);
 
       Scene scene = new Scene(root, 700, 300);
       primaryStage.setTitle("GDI II - Wer wird Millionär");
       primaryStage.setScene(scene);
       primaryStage.show();
   }
 
   public static void main(String[] args) {
       launch(args);
   }
}
