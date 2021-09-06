package a01;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/*
 * Author Conner Jensen
 */
public class PercolationStats {
	int N;
	int T;
	public double[] sitesOpenWhenPercolates;

	/*
	 * Returns a new instance of the PercolationStats class
	 * 
	 * @param N the length of the rows and columns of the Percolation matrix.
	 * @param T the total number of trials that should be run in order to calculate
	 *  the percolation threshold.
	 * @return an instance of the PercolationStats class.
	 */
	public PercolationStats(int N, int T) {
		if (N <= 0 || T <= 0) {
			throw new IllegalArgumentException("Both N and T must be greater than zero.");
		}

		this.N = N;
		this.T = T;
		this.sitesOpenWhenPercolates = new double[T];

		for (int i = 0; i < T; i++) {
			// Perform T trials.
			int sitesOpen = 0;
			Percolation p = new Percolation(N);
			while (!p.percolates()) {
				sitesOpen++;
				// Continue opening sites until it percolates
				int j = 0;
				int k = 0;

				while (p.isOpen(j, k)) {
					j = StdRandom.uniform(N);
					k = StdRandom.uniform(N);
				}

				// We have a cell that is closed.
				p.open(j, k);
			}

			this.sitesOpenWhenPercolates[i] = (double) sitesOpen / (N * N);
		}
	}

	/*
	 * Calculates the mean of the sitesOpen when the system percolates
	 * 
	 * @return the calculated mean.
	 */
	public double mean() {
		return StdStats.mean(this.sitesOpenWhenPercolates);
	}

	/*
	 * Calculates the standard deviation of the sites open when percolates.
	 * 
	 * @return the calculated standard deviation.
	 */
	public double stddev() {
		return StdStats.stddev(this.sitesOpenWhenPercolates);
	}

	/*
	 * The low end of the 95% confidence range.
	 * 
	 * @return the low end of the 95% confidence range.
	 */
	public double confidenceLow() {
		return (mean() - confidenceRatio());
	}

	/*
	 * The high end of the 95% confidence range.
	 * 
	 * @return the high end of the 95% confidence range.
	 */
	public double confidenceHigh() {
		return (mean() + confidenceRatio());
	}

	private double confidenceRatio() {
		return (1.96 * stddev() / Math.sqrt(this.T));
	}
}
