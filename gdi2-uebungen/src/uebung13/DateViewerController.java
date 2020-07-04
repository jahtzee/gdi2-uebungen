package uebung13;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;

public class DateViewerController {

	@FXML
	private ListView<Person> listView;

	@FXML
	private DatePicker datePicker;

	private final String PATH = "P:\\Programme\\git\\gdi2-uebungen\\gdi2-uebungen\\src\\uebung13\\people.csv";

	private ArrayList<Person> personArrList = new ArrayList<Person>();

	public void initialize() {
		addDatePickerListener();
		ArrayList<String> csvData = parseCsvFile(PATH);
		buildPersonArrayListFromCsvData(csvData);
		// printPersonArrayList(); //DEBUG
		sortPersonArrayList();
		listView.getItems().addAll(personArrList);
	}

	public void addDatePickerListener() {
		datePicker.valueProperty().addListener((obs, newValue, oldValue) -> {
			Person selectedPerson = listView.getSelectionModel().selectedItemProperty().get();
			selectedPerson.setDate(obs.getValue());
			sortPersonArrayList();
			listView.getItems().sort((p1, p2) -> {
				return p1.getDate().compareTo(p2.getDate());
			});
		});
	}

	public void listViewItemSelected() {
		Person selectedPerson = listView.getSelectionModel().selectedItemProperty().get();
		datePicker.setValue(selectedPerson.getDate());
	}

	private void sortPersonArrayList() {
		personArrList.sort((p1, p2) -> {
			return p1.getDate().compareTo(p2.getDate());
		});
	}

	@SuppressWarnings("unused")
	private void printPersonArrayList() {
		for (Person p : personArrList) {
			System.out.println(p);
		}
	}

	private void buildPersonArrayListFromCsvData(ArrayList<String> csvData) {
		for (String line : csvData) {
			String[] lineArr = line.split(";");
			String name = lineArr[0];
			String surname = lineArr[1];
			String[] dateArr = lineArr[2].split("-");
			int year = Integer.parseInt(dateArr[0]);
			int month = Integer.parseInt(dateArr[1]);
			int dayOfMonth = Integer.parseInt(dateArr[2]);
			LocalDate date = LocalDate.of(year, month, dayOfMonth);
			personArrList.add(new Person(name, surname, date));
		}
	}

	private ArrayList<String> parseCsvFile(String path) {
		ArrayList<String> arr = new ArrayList<String>();
		try {
			File csv = new File(path);
			Scanner scanner = new Scanner(csv);
			while (scanner.hasNextLine()) {
				String data = scanner.nextLine();
				arr.add(data);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("File could not be found.");
			e.printStackTrace();
		}
		return arr;
	}
}
