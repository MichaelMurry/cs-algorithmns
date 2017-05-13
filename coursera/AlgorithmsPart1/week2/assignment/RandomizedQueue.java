import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item>{
	private Item[] q;
	private int N;

	// construct an empty randomized queue
	public RandomizedQueue() {
		N = 0; 
		q = (Item[]) new Object[1];
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

		if (N == q.length) {
			Item[] copy = (Item[]) new Object[2*q.length];
			for (int i = 0; i < N; i++)
				copy[i] = q[i];
			q = copy;
		}

		q[N] = item;
		N++;
	}

	// remove and return a random item
	public Item dequeue() {
		if (N==0) throw new java.util.NoSuchElementException();

		int rand = StdRandom.uniform(N);
		Item item = q[rand];
		if (rand != N - 1)
			q[rand] = q[N-1];

		// don't forget to put the newArray[newLength] to be null to avoid Loitering
		q[rand] = null;
		N--;
		if (N > 0 && N == q.length/4) {
			Item[] copy = (Item[]) new Object[q.length/2];
			int j = 0;
			for (int i = 0; i < N; i++)
				if (q[i] != null) copy[j] = q[i];
			q = copy;
		} 

		return item;
	}

	// return (but do not remove) a random item
	public Item sample() {
		if (isEmpty()) throw new java.util.NoSuchElementException();

		int rand = StdRandom.uniform(N);
		Item item = q[rand];
		return item;
	}

	// return an independent iterator over items in random order
	public Iterator<Item> iterator() { return new RandomizedIterator(); }

	private class RandomizedIterator implements Iterator<Item> { 
        // Must copy the item in q[] into a new Array
        // Because when we create two independent iterators to same randomized queue, the original one
        // has been changed and the second one will lead to false result.
        private int index = 0;
        private int newN = N;
        private Item newArray[] = (Item[]) new Object[N];
 
        private RandomizedIterator() {
            for (int i = 0; i < newN; i++) {
                newArray[i] = q[i];
            }
        }
 
        public boolean hasNext() {
            return index <= newN - 1;
        }
 
        public Item next() {
            if (newArray[index] == null) throw new java.util.NoSuchElementException();

            int rand = StdRandom.uniform(newN);
            Item item = newArray[rand];
            if (rand != newN - 1)
                newArray[rand] = newArray[newN - 1];
            newN--;
            newArray[newN] = null;
            return item;
        }
 
        public void remove() {
            throw new UnsupportedOperationException();
        }
	}

	// unit testing (optional)
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