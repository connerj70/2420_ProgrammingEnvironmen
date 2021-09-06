package ceLinearBinary;

public class Search {
	/*
	 * Search for a key using a linear algorithm.
	 */
	public static int linear(int[] numbers, int key) {
		for(int i=0; i < numbers.length; i++) {
			if(numbers[i] == key) {
				return i;
			}
		}
		return -1;
	}
	
	/*
	 * Search the numbers for a key using binary algorithm.
	 */
	public static int binary(int[] numbers, int key) {
		if(numbers.length == 0) {
			return -1;
		}
		int low = numbers[0];
		int high = numbers[numbers.length - 1];
		
		if(low == high) {
			if(numbers[low] == key) {
				return low;
			} else {
				return -1;
			}
		}
		
		while(low != high && low < numbers.length && high > 0) {
			int mid = (high - low) / 2;
			if(numbers[mid] == key) {
				return mid;
			}
			if(numbers[mid] < key) {
				low = mid + 1;
			}
			if(numbers[mid] > key) {
				high = mid - 1;
			}
		}
		
		if(numbers[low] == key) {
			return low;
		}
		return -1;
	}
}
