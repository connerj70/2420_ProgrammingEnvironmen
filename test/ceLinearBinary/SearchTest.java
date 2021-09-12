package ceLinearBinary;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Array;

import org.junit.jupiter.api.Test;

class SearchTest {
	private final int[] a = new int[] {1,2,3};
	private final int[] emptyArray = new int[]{};

	@Test
	void linear_findsTheFirstElement() {
		int index = Search.linear(a, 1);
		assertEquals(index, 0);
	}
	
	@Test
	void linear_findsTheLastElement() {
		int index = Search.linear(a,  3);
		assertEquals(index, 2);
	}
	
	@Test
	void linear_findsTheMiddleElement() {
		int index = Search.linear(a,  2);
		assertEquals(index, 1);
	}
	
	@Test
	void linear_elementNotInArray() {
		int index = Search.linear(a,  4);
		assertEquals(index, -1);
	}
	
	@Test
	void linear_emptyArray() {
		int index = Search.linear(emptyArray,  3);
		assertEquals(index, -1);
	}
	
	@Test
	void binary_findsTheFirstElement() {
		int index = Search.binary(a, 1);
		assertEquals(index, 0);
	}
	
	@Test
	void binary_findsTheLastElement() {
		int index = Search.binary(a, 3);
		assertEquals(index, 2);
	}
	
	@Test
	void binary_findsTheMiddleElement() {
		int index = Search.binary(a, 2);
		assertEquals(index, 1);
	}
	
	@Test
	void binary_elementNotInArray() {
		int index = Search.binary(a, 4);
		assertEquals(index, -1);
	}
	
	@Test
	void binary_emptyArray() {
		int[] b = new int[]{};
		int index = Search.binary(emptyArray, 1);
		assertEquals(index, -1);
	}

}
