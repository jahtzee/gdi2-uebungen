package uebung1;

//class declaration

public abstract class Vehicle {
	//instance variables
	private String designation;
	private int tires;
	private double spaceCost;
	
	//constructor declaration
	public Vehicle(String designation, int tires, double spaceCost) {
		this.designation = designation;
		this.setTires(tires);
		this.spaceCost = spaceCost;
	}
	
	//get set
	public double getSpaceCost() {
		return this.spaceCost;
	}
	
	public String getDesignation() {
		return this.designation;
	}
	
	public int getTires() {
		return tires;
	}

	public void setTires(int tires) {
		this.tires = tires;
	}
	
	//methods
	public abstract void checkRange();
	
	public void print() {
		System.out.println(this.designation);
	}
}
