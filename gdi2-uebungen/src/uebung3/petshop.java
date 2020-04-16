package uebung3;

public class petshop {

	public static void main(String[] args) {
		int value = 100;
		int centValue = value*100;
		
		int mouseValue = 50;
		int hamsterValue = 200;
		int turtleValue = 1500;
		
		int result;
		
		for (int x = 1; x < 99; x++) {
			for (int y = 1; y < 99; y++) {
				for (int z = 1; z < 99; z++) {
					result = (mouseValue*x)+(hamsterValue*y)+(turtleValue*z);
					if (result == centValue && x+y+z == 100) {
						System.out.print("mice: " + x);
						System.out.print(" hamsters: " + y);
						System.out.print(" turtles: " + z + "\n");
					}
				}
			}
		}

	}

}

