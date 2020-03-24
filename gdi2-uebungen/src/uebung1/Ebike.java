package uebung1;

public class Ebike extends Vehicle{
	
	//instance variables
	double power; // in percent
	
	//constructor declaration
	public Ebike(String designation, int tires, double power) {
		super(designation, 2, 25); //2 tires, 25 space cost
		this.power = validatePower(power);
	}
	
	//methods
	public double validatePower(double power) {
		if (power>100) {
			return 100;
		} else if (power<0) {
			return 0;
		} else {
			return power;
		}
	}
	
	public String toString() {
		return(this.designation + ", " + this.power);
	}
	
	@Override
	public void checkRange() {
		if (this.power < 25) {
			System.out.println("Warning");
		}
	}
}
