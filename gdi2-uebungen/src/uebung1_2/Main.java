package uebung1_2;

public class Main {

	public static void main(String[] args) {
		Labyrinth l = new Labyrinth(10, 10); //x, y = dimensions
//		l.generateWallsSimple(10);
		l.generateWalls(30);
		l.print();
	}

}
