package a02;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class Deque<Item> implements Iterable<Item> {
	private Node head;
	private Node tail;
	private int N;
	
	private class Node {
		Item value;
		Node next;
		Node prev;
		
		Node() {
			
		}
		
		Node(Item value, Node next, Node prev) {
			this.value = value;
			this.next = next;
			this.prev = prev;
		}
	}
	
	@SuppressWarnings("unchecked")
	public Deque() {
		Node node = new Node();
		head = node;
		tail = node;
		N = 0;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public void addFirst(Item item) {
		if (item == null) {
			throw new NullPointerException("item must not be null");
		}
		Node newNode = new Node(item, head, null);
		head.prev = newNode;
		head = newNode;
		if(N == 0) {
			tail = newNode;
		}
		N++;
	}

	public void addLast(Item item) {
		if (item == null) {
			throw new NullPointerException("item must not be null");
		}
		Node newNode = new Node(item, null, tail);
		tail.next = newNode;
		tail = newNode;
		if(N == 0) {
			head = newNode;
		}
		N++;
	}
	
	public Item removeFirst() {
		if(isEmpty()) {
			throw new NoSuchElementException("the deque is empty.");
		}
		Node removedNode = head;
		head = removedNode.next;
		if(head != null) {			
			head.prev = null;
		}
		N--;
		return removedNode.value;
	}

	public Item removeLast() {
		if(N==0) {
			throw new NoSuchElementException("the deque is empty.");
		}
		Node removedNode = tail;
		tail = removedNode.prev;
		if(tail != null) {			
			tail.next = null;
		}
		N--;
		return removedNode.value;
	}
	
	public Iterator<Item> iterator() {
		return new DequeIterator();
	}
	
	private class DequeIterator implements Iterator<Item> {
		private Node current;
		
		DequeIterator() {
			if(N == 0) {
				current = null;
			} else {
				current  = head;
			}
		}
		
		public void remove() {
			throw new UnsupportedOperationException("the remove operation is not supported.");
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			if(!hasNext()) {
				throw new NoSuchElementException("There are no more elements to iterate.");
			}
			Item item = current.value;
			current = current.next;
			return item;
		}
	}

	public static void main(String[] args) {
		Deque<String> d = new Deque<String>();
		System.out.println(d.size());
		Iterator it = d.iterator();
		it.next();

	}
}
