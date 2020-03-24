package uebung1;

//class declaration

public abstract class Vehicle {
	//instance variables
	String designation;
	int tires;
	double spaceCost;
	
	//constructor declaration
	public Vehicle(String designation, int tires, double spaceCost) {
		this.designation = designation;
		this.tires = tires;
		this.spaceCost = spaceCost;
	}
	
	//methods
	public abstract void checkRange();
	
	public void print() {
		System.out.println(this.designation);
	}
}
