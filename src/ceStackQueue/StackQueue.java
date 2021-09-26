package ceStackQueue;

import java.util.Iterator;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * CE Stack Queue Part 2
 * Exercise to practice the use of stacks and queues.
 * 
 * @author CSIS 2420 Starter Code
 *
 */
public class StackQueue {

	/**
	 * Performs the following transformations:
	 * Replaces the characters '1' with 'i'
	 * Removes characters that are not letters
	 * Removes upper-case letters
	 * 
	 * Example: [9 h ; e l # A l D 0 o . ] => [h e l l o ]
	 * 
	 * @param q
	 * @return transformed input
	 */
	private static Iterable<Character> transformationA(Queue<Character> q) {
		return new TransformationAIterable(q);
	}
	
	static class TransformationAIterable implements Iterable<Character> {
		private Queue q;
		
		TransformationAIterable(Queue<Character> q) {
			this.q = new Queue<Character>();
			q.forEach(c -> {
				if(c == '1') {
					this.q.enqueue('i');
				} else if(!Character.isLetter(c)) {
					
				} else if(Character.isLetter(c) && Character.isUpperCase(c)) {
					
				} else {
					this.q.enqueue(c);
				}
			});
		}
		
		

		public Iterator<Character> iterator() {
			return new TransformationAIterator();
		}
		
		class TransformationAIterator implements Iterator<Character> {
			
			public boolean hasNext() {
				return !q.isEmpty();
			}
			
			public Character next() {
				return (Character)q.dequeue();
			}
		}
	}
	

	/**
	 * Performs the following transformations:
	 * Duplicate all slashes and backslashes ( / and  \ )
	 * Add the reversed (transformed) character sequence to the end. 
	 * 
	 * Example: [. / ^ \ ~ ] => [. / / ^ \ \ ~ ~ \ \ ^ / / . ]
	 * 
	 * @param q
	 * @return transformed input
	 */
	private static Iterable<Character> transformationB(Queue<Character> q) {
		return new TransformationBIterable(q);
		
		
	}
	
	private static class TransformationBIterable implements Iterable<Character> {
		private Queue b;
		@SuppressWarnings("unchecked")
		TransformationBIterable(Queue q) {
			this.b = new Queue<Character>();
			Stack<Character> s = new Stack<Character>();
			q.forEach(c -> {
				if((Character)c == '/') {
					s.push('/');
					s.push('/');
					this.b.enqueue('/');
					this.b.enqueue('/');
				}
				else if ((Character)c == '\\') {
					s.push('\\');
					s.push('\\');
					this.b.enqueue('\\');
					this.b.enqueue('\\');
				} else {					
					this.b.enqueue(c);
					s.push((Character)c);
				}
				});
			while(!s.isEmpty()) {
				this.b.enqueue(s.pop());
			}
			
		}

		@Override
		public Iterator<Character> iterator() {
			return new TransformationBIterator();
		}
		
		class TransformationBIterator implements Iterator<Character> {
			public boolean hasNext() {
				return !b.isEmpty();
			}
			
			public Character next() {
				return (Character)b.dequeue();
			}
		}
	}
	
	public static void main(String[] args) {
		Queue<Character> inputQueue = new Queue<>();
		for(Character c : new Character[] {'9', 'h', ';', 'e', 'l', '#', 'A', 'l', 'D', '0', 'o', '.'}) {
			inputQueue.enqueue(c);
		}
		testTransformA(inputQueue);
		
		inputQueue = new Queue<>();
		for(Character c : new Character[] {'f', 'R', 'e', '!', 'P', 'l', '1', 'c', '1', 'D', '5', 't', ';', 'y'}) {
			inputQueue.enqueue(c);
		}
		testTransformA(inputQueue);
		
		Queue<Character> emptyQueue = new Queue<>();
		for(Character c : new Character[0]) {
			emptyQueue.enqueue(c);
		}
		testTransformA(emptyQueue);
		
		inputQueue = new Queue<>();
		for(Character c : new Character[] {'.', '/', '^', '\\', '~'}) {
			inputQueue.enqueue(c);
		}
		testTransformB(inputQueue);
		
		inputQueue = new Queue<>();
		for(Character c : new Character[] {'/', 'A', '|', 'A', '\\', 'o'}) {
			inputQueue.enqueue(c);
		}
		testTransformB(inputQueue);
		
		testTransformB(emptyQueue);
	}

	private static void testTransformA(Queue<Character> queue) {
		StdOut.println("TransformA (input: [" + queue + "])");
		StdOut.print("output: [");
		for (Character c : transformationA(queue)) {
			StdOut.print(c + " "); 
		}
		StdOut.println("]\n");
	}
	
	private static void testTransformB(Queue<Character> queue) {
		StdOut.println("TransformB (input: [" + queue + "])");
		StdOut.print("output: [");
		for (Character c : transformationB(queue)) {
			StdOut.print(c + " "); 
		}
		StdOut.println("]\n");
	}
}
