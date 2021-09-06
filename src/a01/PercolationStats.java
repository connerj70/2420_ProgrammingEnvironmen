package a01;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
	int N;
	int T;
	public double[] sitesOpenWhenPercolates;
	
	public PercolationStats(int N, int T) {
		if(N <= 0 || T <= 0) {
			throw new IllegalArgumentException("Both N and T must be greater than zero.");
		}
		
		this.N = N;
		this.T = T;
		this.sitesOpenWhenPercolates = new double[T];
	
		
		for(int i=0; i < T; i++) {
			// Perform T trials.
			int sitesOpen = 0;
			Percolation p = new Percolation(N);
			while(!p.percolates()) {
				sitesOpen++;
				// Continue opening sites until it percolates
				int j = 0;
				int k = 0;
				
				while(p.isOpen(j, k)) {
					j = StdRandom.uniform(N);					
					k = StdRandom.uniform(N);
				}
				
				// We have a cell that is closed.
				p.open(j, k);
			}
			
			this.sitesOpenWhenPercolates[i] = (double)sitesOpen / (N * N);
		}
	}
	
	public double mean() {
		return StdStats.mean(this.sitesOpenWhenPercolates);
	}
	
	public double stddev() {
		return StdStats.stddev(this.sitesOpenWhenPercolates);
	}
	
	public double confidenceLow() {
		return (mean() - (1.96*stddev()/Math.sqrt(this.T)));
	}
	
	public double confidenceHigh() {
		return (mean() + (1.96*stddev()/Math.sqrt(this.T)));
	}
}
