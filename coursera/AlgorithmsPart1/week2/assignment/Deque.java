import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
	private Node first;
	private Node last;
	private int count;
	
	// construct an empty deque
	public Deque() {
		first = null;
		last = null;
		count = 0;
	}
	
	// linked list node implementation
	private class Node {
		Item item;
		Node next;
		Node previous; 
	}

	// iterator class implementation
	private class ListIterator implements Iterator<Item> {
		private Node current = first;

		public boolean hasNext() { 
			return (current != null); 
		}

		public void remove() {
			throw new java.lang.UnsupportedOperationException("Removing item not supported");
		}

		public Item next() {
		// check if deque is empty
		if (size() < 1) {
			throw new java.util.NoSuchElementException("Deque is empty, can't perform operation");	
		}
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

	// check if the deque empty
	public boolean isEmpty() {
		return(first == null && last == null);
	}

	// return the number of items on the deque
	public int size(){
		return count;
	}

	// add the item to the front
	public void addFirst(Item item) {
		if (isEmpty()) {
			first = new Node();
			first.item = item;
			last = first;
			count += 1;
		
		}else {
			Node oldfirst = first;
			first = new Node();
			oldfirst.previous = first; 
			first.item = item;
			first.next = oldfirst;
			count += 1;
		}
	}

	// add the item to the end
	public void addLast(Item item) {
		if (isEmpty()) {
			last = new Node();
			last.item = item;
			first = last;
			count += 1;

		}else {
			Node oldlast = last;
			last = new Node();
			last.item = item;
			oldlast.next = last;
			last.previous = oldlast;
			count += 1;
		}
	}

	// remove and return the item from the front
	public Item removeFirst() {
		// check if deque is empty
		if (size() < 1) {
			throw new java.util.NoSuchElementException("Deque is empty, can't perform operation");	
		}

		Item item = first.item;
		first = first.next;
		System.out.println(item);
		count -= 1;
		return item;
	}

	// remove and return the item from the end
	public Item removeLast() {
		// check if deque is empty
		if (size() < 1) {
			throw new java.util.NoSuchElementException("Deque is empty, can't perform operation");	
		}

		Item item = last.item;
		last = last.previous;
		System.out.println(item);
		count -= 1;
		return item;
	}

	// return an iterator over items in order from front to end
	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	// public static void main(String[] args) {
	// 	Deque<String> deck = new Deque<String>();

	// 	deck.addFirst("Hello");
	// 	deck.addLast("Ja");
	// 	deck.addLast("Rule");
	// 	deck.removeFirst();
	// 	deck.removeFirst();
	// 	deck.removeFirst();
	// }

}