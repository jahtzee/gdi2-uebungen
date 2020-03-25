package uebung1;

public class Car extends Vehicle{
	
	//instance variables
	private String licensePlate;
	private double fuel; // in liters
	
	//constructor declaration
	public Car(String designation, String licensePlate, double fuel) {
		super(designation, 4, 100); //4 tires, 100 space cost
		this.licensePlate = licensePlate;
		this.fuel = fuel;
	}
	
	//methods
	public String toString() {
		return(this.getDesignation() + ", " + this.licensePlate + ", " + this.fuel);
	}
	
	@Override
	public void checkRange() {
		if (this.fuel < 10) {
			System.out.println("Warning");
		} else {
			System.out.println(this.fuel);		}
	}
}
