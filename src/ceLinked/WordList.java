package ceLinked;

import java.util.Iterator;

/**
 * WordList is a singly-linked list of Strings. It is designed as a practice
 * opportunity to learn how to manipulate linked sturctures.
 * 
 * @author ..........
 */
public class WordList implements Iterable<String> {
	private Node head; // first node of the list or null
	private Node tail; // last node of the list or null
	private int n; // number of words in the list

	/**
	 * Node of LinkedList that stores the item and a single reference to the next
	 * node.
	 */
	private class Node {
		private String item;
		private Node next;
	}

	/**
	 * Adds a node containing the new item at the end of the list.
	 * 
	 * @param newItem
	 */
	public void append(String newItem) {
		// create a new node based on the word provided by the user
		Node newNode = new Node();
		newNode.item = newItem;

		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		n++;
	}

	/**
	 * Adds a node containing the new item at the front of the list.
	 * 
	 * @param newItem
	 */
	public void prepend(String newItem) {
		Node newNode = new Node();
		newNode.item = newItem;

		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			Node oldHead = head;
			newNode.next = oldHead;
			head = newNode;
		}
		n++;
	}

	/**
	 * Returns the index of the first occurrence of the specified item. If the
	 * specified item in not part of the list the method indexOf returns -1
	 * 
	 * @param item
	 * @return index of the first occurrence of the item; -1 if the word was not
	 *         found.
	 */
	public int indexOf(String item) {
		int index = 0;
		Node currentNode = head;
		while (index < n) {
			if (currentNode.item == item) {
				return index;
			}
			currentNode = currentNode.next;
			index++;
		}
		return -1;
	}

	/**
	 * Checks whether the list contains the given item.
	 * 
	 * @param item
	 * @return true if the item is contained in the list; false otherwise.
	 */
	public boolean contains(String item) {
		Node currentNode = head;
		int index = 0;
		while (index < n) {
			if (currentNode.item == item) {
				return true;
			}
			currentNode = currentNode.next;
			index++;
		}
		return false;
	}

	/**
	 * Returns the number of elements in the list
	 * 
	 * @return the number of elements
	 */
	public int size() {
		return n;
	}

	/**
	 * Determines whether the list is empty or not.
	 * 
	 * @return true if there are no elements in the list.
	 */
	public boolean isEmpty() {
		return n == 0;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node current = head;

		while (current != null) {
			sb.append(current.item).append(" ");
			current = current.next;
		}

		return sb.toString();
	}

	/* * * * * * * * Test Client * * * * * * */
	public static void main(String[] args) {
		WordList list = new WordList();
		System.out.println("size: " + list.size());
		System.out.print("TODO 1: ");
		if (list.isEmpty()) {
			System.out.println("The list is empty.");
		} else {
			System.out.println("The list is not empty.");
		}
		// TODO 1
		// Dynamically determine whether the list is empty. If so, print
		// 'The list is empty.' otherwise print 'The list is not empty.'
		System.out.println("");
		System.out.println("TODO 2: prepend 'ape'");

		list.append("ant");
		list.append("bat");
		list.append("cow");
		list.append("dog");
		list.prepend("ape");
		System.out.println("list: " + list);

		System.out.println("");
		System.out.println("TODO 2: prepend 'auk'");
		list.prepend("auk");
		System.out.println("list: " + list);
		System.out.println("size: " + list.size());
		
		System.out.println("");
		System.out.println("TODO 3: indexOf");
		System.out.println("Index of dog: " + list.indexOf("dog"));
		System.out.println("Index of auk: " + list.indexOf("auk"));
		System.out.println("Index of yak: " + list.indexOf("yak"));
		
		System.out.println("");
		System.out.println("TODO 4: contains");
		System.out.println("cow " + (list.contains("cow") ? "is" : "is not") + " included in the list.");
		System.out.println("cow " + (list.contains("yak") ? "is" : "is not") + " included in the list.");
		
		System.out.println("");
		System.out.println("list: " + list);
		System.out.println("size: " + list.size());
		
		System.out.println("About to use for each loop!");
		for(String s : list) {
			System.out.print(s + " ");
		}
	}

	@Override
	public Iterator<String> iterator() {
		return new WordIterator();
	}
	
	private class WordIterator implements Iterator<String> {
		private Node current;
		
		public WordIterator() {
			current = head;
		}
		
		public boolean hasNext() {
			return current != null;
		}
		
		public String next() {
			Node temp = current;
			current = temp.next;
			return temp.item;
		}
	}

}
