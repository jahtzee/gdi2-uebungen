package uebung7;

public class PartialArraySum extends Thread {
	private int[] array;
	private int startIndex;
	private int endIndex;
	private int sum;
	
	public PartialArraySum(int[] array, int startIndex, int endIndex) {
		this.array = array;
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}
	
	@Override
	public void run() {
		sum = 0;
		for (int i = startIndex; i <= endIndex; i++) {
			sum += array[i];
		}
	}
	
	public int getSum() {
		return this.sum;
	}
}
