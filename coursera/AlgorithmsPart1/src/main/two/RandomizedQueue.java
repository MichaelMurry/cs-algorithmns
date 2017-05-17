import java.util.Iterator;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item>{
	private Item[] items;
	private int N;

	// construct an empty randomized queue
	public RandomizedQueue() {
		N = 0; 
		items = (Item[]) new Object[1];
	}

	// is the queue empty
	public boolean isEmpty() { 
		return (N == 0); 
	}

	// return the number of items on the queue
	public int size() { 
		return N; 
	}

	// add the item
	public void enqueue(Item item) {
		if (item == null) throw new java.lang.NullPointerException();

		if (N == items.length) {
			resize(items.length *2);
		}
		items[N++] = item;
	}

	private void resize(int capacity) {
		Item[] copy = (Item[]) new Object[capacity];
		for (int i = 0; i < N; i++) {
			copy[i] = items[i];
		}
		items = copy;
	}

	// remove and return a random item
	public Item dequeue() {
		if (N == 0) throw new java.util.NoSuchElementException();
		
		if (N == items.length/4) {
			resize(items.length/2);
		}

		int rand = StdRandom.uniform(N);
		Item item = items[rand];
		items[rand] = items[--N];
		items[N] = null;
		return item;
	}

	// return (but do not remove) a random item
	public Item sample() {
		if (isEmpty()) throw new java.util.NoSuchElementException();

		int rand = StdRandom.uniform(N);
		Item item = items[rand];
		return item;
	}

	// return an independent iterator over items in random order
	public Iterator<Item> iterator() { 
		return new RandomizedIterator(); 
	}

	private class RandomizedIterator implements Iterator<Item> { 
        private int[] random;
        private int current;

        public RandomizedIterator() {
        	random = new int[N];
        	for (int i = 0; i < N; i++) {
        		random[i] = i;
        	}
        	StdRandom.shuffle(random);
        	current = 0;
        }

        public boolean hasNext() {
        	return current != random.length;
        }

        public Item next() {
        	if (!hasNext()) throw new java.util.NoSuchElementException();
        	return items[random[current++]];
        }

        public void remove() {
        	throw new java.lang.UnsupportedOperationException();
        }
	}

	// unit testing
	public static void main(String[] args) {
		RandomizedQueue<String> randomQueue = new RandomizedQueue<String>();

		randomQueue.enqueue("hello");
		randomQueue.enqueue("ja'rule");
		randomQueue.enqueue("bro");
		randomQueue.enqueue("screw");
		randomQueue.enqueue("hip");
		randomQueue.enqueue("hop");
		randomQueue.enqueue("yo");
		randomQueue.dequeue();
		randomQueue.dequeue();
		randomQueue.enqueue("yolo");

		for (String s : randomQueue) {
			System.out.println(s);
		}
	

	}


}