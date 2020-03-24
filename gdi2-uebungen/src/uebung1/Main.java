package uebung1;

public class Main {

	public static void main(String[] args) {
		
		Vehicle horstCar = new Car("Jeep Cherokee", "7MIE858", 9);
		Vehicle horstBike = new Ebike("R Raymon Tourray E", 23);
		Vehicle[] horstVehicles = {horstCar, horstBike};
		Person horst = new Person("Horst Müller", horstVehicles, 2);
		
		System.out.println(horst.buyVehicle(horstCar));
		System.out.println(horst.buyVehicle(horstBike));
		horst.printVehicles();
	}

}
