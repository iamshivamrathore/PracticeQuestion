package part1.algorithms.random;

public class FlippingBits {

	static long flippingBits(long n) {

		long l = 0B11111111111111111111111111111111l;

		n = n ^ l;

		return n;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long l = 1;
		System.out.println(flippingBits(l));

		// System.out.println(0B11111111111111111111111111111111l);
	}

}
