import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> 
{
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
		Node prev; 
	}

	// iterator class implementation
	private class ListIterator implements Iterator<Item> {
		private Node current = first;

		public boolean hasNext() { 
			return (current != null); 
		}

		public void remove() {
			throw new java.lang.UnsupportedOperationException();
		}

		public Item next() {
		// check if deque is empty
		if (size() < 1) {
			throw new java.util.NoSuchElementException();	
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
		if (item == null) throw new java.lang.NullPointerException();
		if (isEmpty()) {
			first = new Node();
			first.item = item;
			last = first;
			count += 1;
		
		}else {
			Node oldfirst = first;
			first = new Node();
			oldfirst.prev = first; 
			first.item = item;
			first.next = oldfirst;
			count += 1;
		}
	}

	// add the item to the end
	public void addLast(Item item) {
		if (item == null) throw new java.lang.NullPointerException();
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
			last.prev = oldlast;
			count += 1;
		}
	}

	// remove and return the item from the front
	public Item removeFirst() {
		// check if deque is empty
		if (size() < 1) throw new java.util.NoSuchElementException();	

		Item item = first.item;
		first = first.next;
		count -= 1;
		return item;
	}

	// remove and return the item from the end
	public Item removeLast() {
		// check if deque is empty
		if (size() < 1) throw new java.util.NoSuchElementException();	

		Item item = last.item;
		last = last.prev;
		count -= 1;
		return item;
	}

	// return an iterator over items in order from front to end
	public Iterator<Item> iterator() {
		return new ListIterator();
	}


}