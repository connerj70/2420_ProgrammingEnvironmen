package a01;

public class PercolationStatsSecond {
	public PercolationStatsSecond(int N, int T) {
		// perform T independent experiments on an N­by­N grid
		if(N <= 0 || T <= 0) {
			throw new IllegalArgumentException("Both N and T must be greater than 0.");
		}
	
		// Step 1. Initialize all sites to be blocked.
		
		
	}
	public double mean() {
		// sample mean of percolation threshold
		return 0.0;
	}
	public double stddev() {
		// sample standard deviation of percolation threshold
		return 0.0;
	}
	public double confidenceLow() {
		// low endpoint of 95% confidence interval
		return 0.0;
	}
	public double confidenceHigh() {
		// high endpoint of 95% confidence interval
		return 0.0;
	}
}
