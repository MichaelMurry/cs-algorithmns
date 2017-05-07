public class Deque{
	private Node first, last;
	
	// construct an empty deque
	// public Deque() {}
	
	private class Node {
		String item;
		Node next;
	}

	// is the deque empty
	public boolean isEmpty() {
		return first == null;
	}

	// // return the number of items on the deque
	// public int size(){}

	// add the item to the front
	public void addFirst(String item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;

		if (isEmpty()) last = first;
		else           first.next = oldfirst;
	}

	// add the item to the end
	public void addLast(String item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;

		if (isEmpty()) first = last;
		else           oldlast.next = last;		
	}

	// remove and return the item from the front
	public String removeFirst() {
		String item = first.item;
		first = first.next;
		System.out.println(item);
		return item;
	}

	// // remove and return the item from the end
	// public Item removeLast(){}

	// // return an iterator over items in order from front to end
	// public Iterator<Item> iterator(){}

	// unit testing 
	public static void main(String[] args){
		Deque tst = new Deque();

		tst.addFirst("shoot");
		tst.addLast("hello");


		// tst.addLast("me");
		// tst.addLast("There");
		// tst.removeLast();
		// tst.removeFirst();

		// tst.addLast("Hi");
		// tst.addLast("poop");
		// tst.removeFirst();
		// tst.removeFirst();


	}



}