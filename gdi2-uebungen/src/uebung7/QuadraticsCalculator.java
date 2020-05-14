package uebung7;

public class QuadraticsCalculator extends Thread{
	private int start;
	private int end;
	private int remainder;
	private int arrayLength;
	private int[] quadratics;
	
	public QuadraticsCalculator(int start, int end, boolean evenOnly) {
		this.start = start;
		this.end = end;
		this.remainder = (evenOnly) ? 0 : 1;
		arrayLength = (int) ((Math.floor(Math.sqrt(end)) - Math.ceil(Math.sqrt(start))+1)/2+1);
		quadratics = new int[arrayLength];
	}
	
	@Override
	public void run() {
		int n = 1;
		int i = 0;
		while (true) {
			if (n%2 == remainder) {
				if (n*n <= end && n*n >= start) {
					quadratics[i++] = n*n;
				} else {
					if (n*n >= end)
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
