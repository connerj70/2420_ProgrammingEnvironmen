package ceLinearBinary;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Array;

import org.junit.jupiter.api.Test;

class SearchTest {

	@Test
	void linear_findsTheFirstElement() {
		int[] a = new int[]{1,2,3};
		int index = Search.linear(a, 1);
		assertEquals(index, 0);
	}
	
	@Test
	void linear_findsTheLastElement() {
		int[] a = new int[] {1,2,3};
		int index = Search.linear(a,  3);
		assertEquals(index, 2);
	}
	
	@Test
	void linear_findsTheMiddleElement() {
		int[] a = new int[] {1,2,3};
		int index = Search.linear(a,  2);
		assertEquals(index, 1);
	}
	
	@Test
	void linear_elementNotInArray() {
		int[] a = new int[] {1,2,3};
		int index = Search.linear(a,  4);
		assertEquals(index, -1);
	}
	
	@Test
	void linear_emptyArray() {
		int[] a = new int[] {};
		int index = Search.linear(a,  3);
		assertEquals(index, -1);
	}
	
	@Test
	void binary_findsTheFirstElement() {
		int[] a = new int[]{1,2,3};
		int index = Search.binary(a, 1);
		assertEquals(index, 0);
	}
	
	@Test
	void binary_findsTheLastElement() {
		int[] a = new int[]{1,2,3};
		int index = Search.binary(a, 3);
		assertEquals(index, 2);
	}
	
	@Test
	void binary_findsTheMiddleElement() {
		int[] a = new int[]{1,2,3};
		int index = Search.binary(a, 2);
		assertEquals(index, 1);
	}
	
	@Test
	void binary_elementNotInArray() {
		int[] a = new int[]{1,2,3};
		int index = Search.binary(a, 4);
		assertEquals(index, -1);
	}
	
	@Test
	void binary_emptyArray() {
		int[] a = new int[]{};
		int index = Search.binary(a, 1);
		assertEquals(index, -1);
	}

}
