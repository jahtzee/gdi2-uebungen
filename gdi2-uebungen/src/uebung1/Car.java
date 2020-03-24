package uebung1;

public class Car extends Vehicle{
	
	//instance variables
	String licensePlate;
	double fuel; // in liters
	
	//constructor declaration
	public Car(String designation, int tires, String licensePlate, double fuel) {
		super(designation, 4, 100); //4 tires, 100 space cost
		this.licensePlate = licensePlate;
		this.fuel = fuel;
	}
	
	//methods
	public String toString() {
		return(this.designation + ", " + this.licensePlate + ", " + this.fuel);
	}
	
	@Override
	public void checkRange() {
		if (this.fuel < 10) {
			System.out.println("Warning");
		} else {
			System.out.println(this.fuel);		}
	}
}
