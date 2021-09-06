package a01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PercolationStatsTest {

	@Test
	void constructor_whenNIsLessThanZero_ThrowsException() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			new PercolationStats(-1, 10);
		});
	}
	
	@Test
	void constructor_whenTIsLessThanZero_ThrowsException() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			new PercolationStats(10, -1);
		});
	}
	
	@Test
	void constructor_whenNIsZero_ThrowsException() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			new PercolationStats(0, 10);
		});
	}
	
	@Test
	void constructor_whenTIsZero_ThrowsException() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			new PercolationStats(10, 0);
		});
	}
	
	@Test
	void mean_calculatesTheCorrectMean() {
		double[] d = new double[] {1,1,1};
		PercolationStats ps = new PercolationStats(1,1);
		ps.sitesOpenWhenPercolates = d;
		double mean = ps.mean();
		assertEquals(1, mean);
	}

}
