package uebung7;

public class Calc {
	
	public static void main(String[] args) throws InterruptedException {
		int start = 49;
		int end = 64;
		
		if (Math.floor(Math.sqrt(end)) - Math.ceil(Math.sqrt(start))+1 == 0) {
			System.out.println("Keine Quadratzahlen in diesem Bereich.");
			return;
		}
		
		if (start == end) {
			System.out.println("Es muss ein Bereich angegeben werden.");
			return;
		}
		
		int[] evenQuadratics = null;
		int[] oddQuadratics = null;
		int[] allQuadratics = new int[(int) (Math.floor(Math.sqrt(end)) - Math.ceil(Math.sqrt(start))+1)];
		int sum;
		
		QuadraticsCalculator even = new QuadraticsCalculator(start, end, true);
		QuadraticsCalculator odd = new QuadraticsCalculator(start, end, false);
		even.start();
		odd.start();
		even.join();
		odd.join();
		
		evenQuadratics = even.getQuadraticsAsArray();
		oddQuadratics = odd.getQuadraticsAsArray();
		
		System.arraycopy(evenQuadratics, 0, allQuadratics, 0, allQuadratics.length/2);
		if (allQuadratics.length%2 == 0) {
			System.arraycopy(oddQuadratics, 0, allQuadratics, allQuadratics.length/2, (allQuadratics.length/2));
		} else {
			System.arraycopy(oddQuadratics, 0, allQuadratics, allQuadratics.length/2, (allQuadratics.length/2)+1);
		}
		
		PartialArraySum sum1 = new PartialArraySum(allQuadratics, 0, allQuadratics.length/2);
		PartialArraySum sum2 = new PartialArraySum(allQuadratics, (allQuadratics.length/2)+1, allQuadratics.length-1);
		sum1.start();
		sum2.start();
		sum1.join();
		sum2.join();
		
		sum = sum1.getSum();
		sum += sum2.getSum();
		
		System.out.println("Gerade Quadratzahlen:");
		for (int i : evenQuadratics) {
			if (i != 0)
			System.out.println(i);
		}
		System.out.println("Ungerade Quadratzahlen:");
		for (int i : oddQuadratics) {
			if (i != 0)
			System.out.println(i);
		}
		System.out.println("Summe der Quadratzahlen:");
		System.out.println(sum);
		
		System.out.println("Probe:");
		sum = 0;
		for (int i : evenQuadratics) {
			sum += i;
		}
		for (int i : oddQuadratics) {
			sum += i;
		}
		System.out.println(sum);
	}

}
