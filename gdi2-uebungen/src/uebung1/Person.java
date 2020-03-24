package uebung1;

//class declaration

public class Person {
	//class variables
	static int nextId = 10000;
	
	//instance variables
	String name;
	int id;
	Vehicle[] myVehicles;
	double parkingSpaces; // 1 parking space = 100 units of space
	
	//constructor declaration
	public Person(String name, Vehicle[] myVehicles, double parkingSpaces) {
		this.id = nextId;
		nextId++;
		this.name = name;
		this.myVehicles = myVehicles;
		this.parkingSpaces = parkingSpaces;
	}
	
	//methods
	public void printVehicles() {
		for (Vehicle currentVehicle : this.myVehicles) {
			currentVehicle.print();
		}
	}
	
	public boolean buyVehicle(Vehicle acquisition) {
		if (this.getFreeSpace() >= acquisition.spaceCost) {
			int length = this.myVehicles.length;
			Vehicle[] tmp = new Vehicle[length + 1];
			for (int i = 0; i < length; i++) {
				tmp[i] = this.myVehicles[i];
				tmp[this.myVehicles.length] = acquisition;
			}
			this.myVehicles = tmp;
			return true;
		} else {
			return false;
		}
	}
	
	private double getFreeSpace() {
		double totalSpace = this.parkingSpaces * 100;
		double usedSpace = 0;
		for (Vehicle currentVehicle : this.myVehicles) {
			usedSpace += currentVehicle.spaceCost;
		}
		return totalSpace - usedSpace;
	}
}
