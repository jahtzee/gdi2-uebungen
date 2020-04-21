package uebung1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		Vehicle horstCar = new Car("Jeep Cherokee", "7MIE858", 9);
		Vehicle horstBike = new Ebike("R Raymon Tourray E", -5000);
		ArrayList<Vehicle> horstVehicles = new ArrayList<Vehicle>(Arrays.asList(horstCar, horstBike));
		Person horst = new Person("Horst Müller", horstVehicles, 2);
		
		System.out.println(horst.buyVehicle(horstCar));
		//System.out.println(horst.buyVehicle(horstBike));
		horst.printVehicles();
		horstCar.checkRange();
		horstBike.checkRange();
		System.out.println(horstBike.getTires());
	}

}
