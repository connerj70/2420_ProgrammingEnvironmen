package a02;

import java.util.Scanner;

import edu.princeton.cs.algs4.StdIn;

public class Subset {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int k = input.nextInt();
		
		System.out.println(k);
		
		RandomizedQueue<String> rq = new RandomizedQueue<String>();
		
		
		while(!StdIn.isEmpty()) {
			String s = StdIn.readString();
			rq.enqueue(s);
		}
		
		
		for(int i=0; i < k; i++) {
			System.out.println(rq.dequeue());
		}
		
	}

}
