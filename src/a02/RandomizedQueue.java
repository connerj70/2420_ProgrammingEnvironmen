package a02;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private Item[] a;
	private int N;
	
	@SuppressWarnings("unchecked")
	public RandomizedQueue() {
		a = (Item[]) new Object[1];
		N = 0;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public void enqueue(Item item) {
		if(item ==  null) {
			throw new NullPointerException("the item to enqueue must not be null.");
		}
		if(a.length == N) {
			// Resize the array first before adding the item.
			resize(a.length * 2);
		}
		a[N] = item;
		N = N + 1;
	}

	public Item dequeue() {
		if(isEmpty()) {
			throw new NoSuchElementException("The queue is empty.");
		}
		int n = StdRandom.uniform(N);
		N = N - 1;
		Item temp = a[N];
		a[N] = a[n];
		a[n] = temp;
		Item i = a[N];
		a[N] = null; // Prevent loitering.
		if(N > 0 && N == (a.length/4)) {
			resize(a.length/2);
		}
		return i;
	}

	public Item sample() {
		if(isEmpty()) {
			throw new NoSuchElementException("The queue is empty.");
		}
		int n = StdRandom.uniform(N);
		return a[n];
	}

	public Iterator<Item> iterator() {
		return new RandomArrayIterator();
	}
	
	public class RandomArrayIterator implements Iterator<Item> {
		private int i;
		private Item[] b;
		
		@SuppressWarnings("unchecked")
		public RandomArrayIterator() {
			i = N;
			this.b = (Item[]) new Object[N];
	        for (int j = 0; j < N; j++) {
	        	if(N > 0) {	        		
	        		b[j] = a[j];
	        	}
	        }
	        StdRandom.shuffle(b);
		}
		
		public boolean hasNext() {
			return i > 0;
		}
		
		public Item next() {
			if(i == 0) {
				throw new NoSuchElementException("There are no more elements");
			}
			i = i - 1;
			return b[i];
		}
		
		public void remove() {
			throw new UnsupportedOperationException("The remove operation is not supported for this iterator.");
		}
	}
	
	private void resize(int max) {
		@SuppressWarnings("unchecked")
		Item[] temp = (Item[]) new Object[max];
		for(int i=0; i < N; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}
	
	public static void main(String[] args) {
		RandomizedQueue<String> q = new RandomizedQueue<String>();
		q.enqueue("blah");
		for(String j: q) {
			System.out.println(j);
		}
	}
}
