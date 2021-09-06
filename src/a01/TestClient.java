package a01;

public class TestClient {

	public static void main(String[] args) {
		Percolation p = new Percolation(2);
		p.open(0,  1);
		p.open(1, 1);
		p.open(0, 0);
		System.out.println(p.percolates());
		
		
		PercolationStats ps = new PercolationStats(10, 5);
		for(int i=0; i < ps.sitesOpenWhenPercolates.length; i++) {			
			System.out.println(ps.sitesOpenWhenPercolates[i]);
		}
		System.out.println(" ");
		System.out.println(ps.mean());
		System.out.println(ps.stddev());
		System.out.println(ps.confidenceHigh());
		System.out.println(ps.confidenceLow());
	}

}
