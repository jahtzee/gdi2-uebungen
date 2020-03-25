package uebung1_2;

public class Coordinates {
	//instance variables
	//private int id;
	private int x;
	private int y;
	
	//constructor declaration
	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
		//this.id = Integer.valueOf(x + "" + y);
	}
	
	//get set 
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}

//	public int getId() {
//		return id;
//	}
	
	//methods
}
