package a01;

public class TestClient {

	public static void main(String[] args) {
		Percolation p = new Percolation(2);
		p.open(0,  1);
		p.open(1, 1);
		p.open(0, 0);
		System.out.println(p.percolates());
	}

}
