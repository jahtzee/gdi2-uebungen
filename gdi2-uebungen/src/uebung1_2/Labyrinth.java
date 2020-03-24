package uebung1_2;

import java.util.Arrays;

public class Labyrinth {
	//class variables
	private static final char EMPTY = '-';
	private static final char FILLED = 'X';
	
	//instance variables
	private char[][] plan;
	private int x;
	private int y;
	
	//constructor declaration
	public Labyrinth(int x, int y) {
		this.x = x;
		this.y = y;
		this.plan = new char[y][x];
		
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				this.plan[i][j] = EMPTY;
			}
		}
	}
	
	//methods
	public void print() {
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				System.out.print(this.plan[i][j]);
			}
			System.out.println("");
		}
	}
	
	public void generateWallsSimple(int wallAmount) {
		
	}
	
	public void generateWalls(int wallAmount) {
		
	}
	
	public String getPlanAsString() {
		return Arrays.deepToString(plan);
	}
}
