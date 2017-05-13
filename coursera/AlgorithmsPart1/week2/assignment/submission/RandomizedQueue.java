public class RandomizedQueue
{
	private String[] q;
	private int N;
	private int count;

	// construct an empty randomized queue
	public RandomizedQueue() {
		q = new String[1];
	}

	// is the queue empty
	public boolean isEmpty() {
		return (N < 1);
	}

	// return the number of items on the queue
	public int size() {
		return N;
	}

	// add the item
	public void enqueue(String item) {
		if (N == q.length) {
			String[] copy = new String[2*q.length];
			for (int i = 0; i < N; i++)
				copy[i] = q[i];
			q = copy;
		}

		q[N++] = item;
		System.out.println(item);
	}

	// remove and return a random item
	public String dequeue() {
		int index = StdRandom.uniform(N);
		String item = q[index];
		q[index] = null;
		N--;

		if (N > 0 && N == q.length/4) {
			String[] copy = new String[q.length/2];
			int j = 0;
			for (int i = 0; i < N; i++)
				if (q[i] != null) copy[j] = q[i];
			q = copy;
		} 

		System.out.println(item);
		return item;
	}

	// return (but do not remove) a random item
	public String sample() {
		int index = StdRandom.uniform(N);
		String item = q[index];
		return item;
	}

	// public void printSize() {
	// 	System.out.println("Queue length is: " + q.length);
	// }

	// public void printN() {
	// 	System.out.println("N value is: " + N);
	// }

	// // return an independent iterator over items in random order
	// public Iterator<item> iterator()

	// // unit testing (optional)
	// public static void main(String[] args) {
	// 	RandomizedQueue queue = new RandomizedQueue();

	// 	queue.enqueue("hello");
	// 	queue.printSize();
	// 	queue.printN();

	// 	queue.enqueue("ja'rule");
	// 	queue.printSize();
	// 	queue.printN();

	// 	queue.enqueue("never");
	// 	queue.printSize();
	// 	queue.printN();

	// 	queue.enqueue("tell");
	// 	queue.printSize();
	// 	queue.printN();

	// 	queue.dequeue();
	// 	queue.printSize();
	// 	queue.printN();

	// 	queue.dequeue();
	// 	queue.printSize();
	// 	queue.printN();

	// 	queue.dequeue();
	// 	queue.printSize();
	// 	queue.printN();

	// }


}