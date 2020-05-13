package uebung7;

public class QuadraticsCalculator extends Thread{
	private int start;
	private int end;
	private int remainder;
	private int[] quadratics = new int[50];
	
	public QuadraticsCalculator(int start, int end, boolean evenOnly) {
		this.start = start;
		this.end = end;
		this.remainder = (evenOnly) ? 0 : 1;
	}
	
	@Override
	public void run() {
		int n = start;
		int i = 0;
		while (true) {
			if (n%2 == remainder) {
				if (n*n <= end) {
					quadratics[i++] = n*n;
				} else {
					break;
				}
			}
			n++;
		}
	}
	
	public int[] getQuadraticsAsArray() {
		return this.quadratics;
	}
}
