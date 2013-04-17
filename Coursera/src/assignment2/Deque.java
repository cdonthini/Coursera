package assignment2;

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

	private class Node {
		private Item item;
		private Node next;
		private Node prev;
		
		private Node ( Item item) {
			this.item = item;
			this.next = null;
			this.prev = null;
		}
	}
	
	private Node head;
	private Node tail;
	private int N;
	
	public Deque() // construct an empty deque
	{
		head = null;
		tail = null;
		N = 0;
	}

	public boolean isEmpty() // is the deque empty?
	{
		return ( head == null && tail == null );

	}

	public int size() // return the number of items on the deque
	{
		return N;

	}

	public void addFirst(Item item) // insert the item at the front
	{
		if ( item == null ) throw new java.lang.NullPointerException();
		Node temp = new Node( item);
		
		if ( N == 0 ) {
			head = temp;
			tail = temp;
		}
		else {
			temp.next = head;
			head.prev = temp;
			head = temp;
			head.prev = null;
		}
		N++;
	}

	public void addLast(Item item) // insert the item at the end
	{
		if ( item == null ) throw new java.lang.NullPointerException();
		Node temp = new Node( item);
		
		if ( N == 0 ) {
			head = temp;
			tail = temp;
		}
		else {
			tail.next = temp;
			temp.prev = tail;
			tail = temp;
			tail.next = null;
		}
		N++;
	}

	public Item removeFirst() // delete and return the item at the front
	{
		if ( isEmpty() ) throw new java.util.NoSuchElementException();
		N--;
		Node temp = head;
		head = head.next;
		head.prev = null;
		
		return temp.item;		
	}

	public Item removeLast() // delete and return the item at the end
	{
		if ( isEmpty() ) throw new java.util.NoSuchElementException();
		N--;
		Node temp = tail;
		tail = tail.prev;
		tail.next = null;
		
		return temp.item;
	}

	public Iterator<Item> iterator() // return an iterator over items in order
										// from front to end
	{
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item> {
		private Node current = head;
		public boolean hasNext() {
			
			return current != null;
		}

		public Item next() {
			if ( !hasNext() ) throw new java.util.NoSuchElementException();
			current = current.next;
			return current.item;
		}

		public void remove() {
			throw new java.lang.UnsupportedOperationException();
		}
		
	}
}
