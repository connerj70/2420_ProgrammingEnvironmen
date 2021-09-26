package ceRecursion;

public class Recursion {
	public static void main(String[] args) {
		System.out.println("Hailstone numbers");
		System.out.println("-------------------");
		hailstone(3);
		System.out.println("");
		hailstone(16);
		System.out.println("");
		hailstone(17);
		System.out.println("");
		hailstone(24);
	}
	
	public static void hailstone(int seed) {
		if(seed < 0) {
			throw new IllegalArgumentException("the seed must be positive");
		}
		System.out.print(seed + " ");
		if(seed == 1) {
			return;
		}
		
		if(seed % 2 == 0) {
			hailstone(seed/2);
		} else {
			hailstone((seed * 3) + 1);
		}
	}
}
