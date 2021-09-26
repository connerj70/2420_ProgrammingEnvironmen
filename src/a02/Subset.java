package a02;

import java.util.Scanner;

import edu.princeton.cs.algs4.StdIn;

public class Subset {

	public static void main(String[] args) {
		int k = 5;
		String[] input = {"hi", "there", "how", "is", "it", "going"};
		
		RandomizedQueue<String> rq = new RandomizedQueue<String>();
		
		
		for(int i=0; i < input.length; i++) {
			rq.enqueue(input[i]);
		}
		
		
		for(int i=0; i < k; i++) {
			System.out.println(rq.dequeue());
		}
		
	}

}
