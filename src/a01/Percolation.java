package a01;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	private int n;
	public WeightedQuickUnionUF uf;
	public Integer[] grid;
	
	public Percolation(int N) {
		if (N <= 0) {			
			throw new IllegalArgumentException("N must be greater than 0.");
		}
		this.n = N;
		this.uf = new WeightedQuickUnionUF(N*N + 2);
		this.grid = new Integer[N*N];
		for(int i=0; i < N*N; i++) {
			if(i < N) {
				// Connect top nodes to virtual top
				this.uf.union(this.n*this.n, i);
			}
			if(i >= (N*N)-N) {
				// Connect bottom nodes to virtual bottom.
				this.uf.union(this.n*this.n+1, i);
			}
			grid[i] = null;
		}
	}
	
	public void open(int i, int j) {
		checkValidIndices(i, j);
		int realIndex = convertTo1D(i, j);
		grid[realIndex] = realIndex;
		boolean validRightIndex = (j + 1) < this.n;
		if( validRightIndex && grid[realIndex + 1] != null) {
			// The right index is open so let's connect it in UF.
			uf.union(realIndex, realIndex + 1);
		}
		boolean validBottomIndex = (i + 1) < this.n;
		if(validBottomIndex && grid[realIndex + this.n] != null) {
			uf.union(realIndex, convertTo1D(i, j + this.n));
		}
		boolean validLeftIndex = (j - 1) >= 0;
		if(validLeftIndex && grid[realIndex - 1] != null) {
			uf.union(realIndex,  realIndex - 1);
		}
		boolean validTopIndex = (i - 1) >= 0;
		if(validTopIndex && grid[realIndex - this.n] != null) {
			uf.union(realIndex,  realIndex - this.n);
		}
	}
	
	public boolean isOpen(int i, int j) {
		checkValidIndices(i, j);
		int realIndex = convertTo1D(i, j);
		return this.grid[realIndex] != null;
	}
	
	public boolean isFull(int i, int j) {
		checkValidIndices(i, j);
		int realIndex = convertTo1D(i, j);
		return this.uf.connected(realIndex, this.n*this.n);
	}
	
	public boolean percolates() {
		return this.uf.connected(this.n*this.n, this.n*this.n+1);
	}
	
	private int convertTo1D(int i, int j) {
		return (i * this.n) + j;
	}
	
	private boolean checkValidIndices(int i, int j) {
		if(i < 0 || i >= this.n) {
			throw new IndexOutOfBoundsException("row index " + i + " must be between 0 and " + (this.n - 1));
		}
		if(j < 0 || j >= this.n) {
			throw new IndexOutOfBoundsException("row index " + i + " must be between 0 and " + (this.n - 1));
		}
		return true;
	}
}
