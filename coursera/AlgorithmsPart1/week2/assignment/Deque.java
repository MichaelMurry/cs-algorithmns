import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
	private Node first;
	private Node last;
	private Node nul;
	private int size;
	
	// construct an empty deque
	public Deque() {
		nul = new Node(null, null, null);
		first = nul;
		last = nul;
		size = 0;
	}
	
	// linked list node implementation
	private class Node {
		private Item item;
		private Node next;
		private Node prev; 

		Node(Node prev, Node next, Item item) {
			this.prev = prev;
			this.next = next;
			this.item = item;
		}
	}

	// check if the deque empty
	public boolean isEmpty() {
		return(first.item == null && last.item == null);
	}

	// return the number of items on the deque
	public int size() {
		return size;
	}

	// add the item to the front
	public void addFirst(Item item) {
		if (item == null) throw new java.lang.NullPointerException("Can't add null to the deque!");

		Node newFirst = new Node(nul, first, item);
		if (isEmpty()) {
			last = newFirst;
			first = newFirst;
		}else {
			first.prev = newFirst;
			first = newFirst;
		}
		size++;
	}

	// add the item to the end
	public void addLast(Item item) {
		if (item == null) throw new java.lang.NullPointerException("Can't add null to the deque!");

		Node newLast = new Node(last, nul, item);
		if (isEmpty()) {
			first = newLast;
			last = newLast;
		}else {
			last.next = newLast;
			last = newLast;
		}
		size++;
	}

	// remove and return the item from the front
	public Item removeFirst() {
		// check if deque is empty
		if (size() < 1) throw new java.util.NoSuchElementException("The deque is empty!");	

		Item item = first.item;
		first = first.next;

		if (first.item == null) {
			last = nul;
		}else {
			first.prev = nul;
		}
		size--;
		return item;
	}

	// remove and return the item from the end
	public Item removeLast() {
		// check if deque is empty
		if (isEmpty()) throw new java.util.NoSuchElementException("The deque is empty!");	

		Item item = last.item;
		last = last.prev;
		if (last.item == null) {
			first = nul;
		}else {
			last.next = nul;
		}
		size--;
		return item;
	}

	// return an iterator over items in order from front to end
	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	// iterator class implementation
	private class ListIterator implements Iterator<Item> {
		private Node current = first;

		public boolean hasNext() { 
			return (current.next != null); 
		}

		public Item next() {
		// check if deque is empty
		if (!hasNext()) throw new java.util.NoSuchElementException("There is no more items!");	
			Item item = current.item;
			current = current.next;
			return item;
		}

		public void remove() {
			throw new java.lang.UnsupportedOperationException();
		}
	}

	// unit testing
	public static void main(String[] args) {
        Deque<String> deck = new Deque<String>();

        deck.addFirst("study");
        deck.addLast("I");
        deck.addLast("and");
        deck.addLast("You");


        deck.removeFirst();
        deck.removeLast();

        // deck.removeFirst();

        StdOut.println("output:");
        for (String x : deck) {
            System.out.println(x);
        }
    }
}