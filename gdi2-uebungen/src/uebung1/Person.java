package uebung1;

import java.util.ArrayList;

//class declaration

public class Person {
	//class variables
	private static int nextId = 10000;
	
	//instance variables
	private String name;
	private int id;
	//private Vehicle[] myVehicles;
	private ArrayList<Vehicle> myVehicles;
	private double parkingSpaces; // 1 parking space = 100 units of space
	
	//constructor declaration
	public Person(String name, ArrayList<Vehicle> myVehicles, double parkingSpaces) {
		this.setId(nextId);
		nextId++;
		this.setName(name);
		this.myVehicles = myVehicles;
		this.parkingSpaces = parkingSpaces;
	}
	
	//get set
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	//methods
	public void printVehicles() {
		for (Vehicle currentVehicle : this.myVehicles) {
			currentVehicle.print();
		}
	}
	
	public boolean buyVehicle(Vehicle acquisition) {
		if (this.getFreeSpace() >= acquisition.getSpaceCost()) {
//			int length = this.myVehicles.size();
//			Vehicle[] tmp = new Vehicle[length + 1];
//			for (int i = 0; i < length; i++) {
//				tmp[i] = this.myVehicles[i];
//				tmp[this.myVehicles.length] = acquisition;
//			}
//			this.myVehicles = tmp;
			this.myVehicles.add(acquisition);
			return true;
		} else {
			return false;
		}
	}
	
	private double getFreeSpace() {
		double totalSpace = this.parkingSpaces * 100;
		double usedSpace = 0;
		for (Vehicle currentVehicle : this.myVehicles) {
			usedSpace += currentVehicle.getSpaceCost();
		}
		return totalSpace - usedSpace;
	}
}
