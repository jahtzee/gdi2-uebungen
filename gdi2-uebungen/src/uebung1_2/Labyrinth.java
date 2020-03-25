package uebung1_2;

import java.util.Arrays;
import java.util.Random;

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
		for (int i = 1; i <= wallAmount; i++) {
			Coordinates pair = generateCoordinatePair(this.x, this.y);
			this.plan[pair.getY()][pair.getX()] = FILLED;
		}
	}
	
	public void generateWalls(int wallAmount) {
		for (int i = 0; i < wallAmount; i++) {
			Coordinates pair = generateCoordinatePair(this.x, this.y);
			
			while (this.plan[pair.getY()][pair.getX()] == FILLED) {
				pair = generateCoordinatePair(this.x, this.y);
			}
			
			this.plan[pair.getY()][pair.getX()] = FILLED;
		}
	}
	
	public String getPlanAsString() {
		return Arrays.deepToString(plan);
	}
	
	private Coordinates generateCoordinatePair(int maxX, int maxY) {
		Random random = new Random();
		
		int x = random.nextInt(maxX);
		int y = random.nextInt(maxY);
		
		Coordinates pair = new Coordinates(x, y);
		return pair;
	}
}
