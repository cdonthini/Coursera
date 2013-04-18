package assignment2;

import java.util.Iterator;
import java.util.Random;

public class RandomizedQueue<Item> implements Iterable<Item> {

	private int N;
	private int last;
	private Item[] q;
	private Random rand = new Random();
	public RandomizedQueue() // construct an empty randomized queue
	{
		last = 0;
		q = (Item[]) new Object [2];
	}

	public boolean isEmpty() // is the queue empty?
	{
		return N == 0;
	}

	public int size() // return the number of items on the queue
	{
		return q.length;
	}
	
	private void resize ( int newlength ) {
		Item[] temp = (Item[]) new Object [ newlength ];
		
		for ( int i = 0; i < q.length; i++ ){
			temp[i] = q[i];
		}
		
		q = temp;
	}
	public void enqueue(Item item) // add the item
	{
		if ( item == null ) throw new java.lang.NullPointerException();
		if ( last >= q.length ) {
			resize( 2 * q.length );
		}
		q [ last ] = item;
		N++;
		last++;
		
	}

	public Item dequeue() // delete and return a random item
	{
		if ( isEmpty() ) throw new java.util.NoSuchElementException();
		
		int removeInd = rand.nextInt(N);
		Item temp;
		if ( removeInd == last - 1) {
			temp = q [ removeInd ];
			q[ removeInd ] = null;
			last--;
			N--;
		}
		else {
			temp = q [ removeInd ];
			q [ removeInd ] = q [ last - 1 ];
			q [ last - 1 ] = null;
			last--;
			N--;
		}
		if ( N < q.length / 4 ){
			resize( q.length / 4 );
		}
		return temp;

	}

	public Item sample() // return (but do not delete) a random item
	{
		if ( isEmpty() ) throw new java.util.NoSuchElementException();
		
		int removeInd = rand.nextInt(N);
				
		return q[ removeInd ];

	}

	public Iterator<Item> iterator() // return an independent iterator over
										// items in random order
	{
		
		return new ArrayIterator();

	}
	
	private class ArrayIterator implements Iterator <Item> {
		int i = 0;
		
		public boolean hasNext() {
			
			return i < N;
		}
		
		public Item next() {
			
			if ( !hasNext() ) {
				throw new java.util.NoSuchElementException();
			}
			Item item = q[i];
			
			return item;
		}

		public void remove() {

			throw new java.lang.UnsupportedOperationException();
			
		}
		
	}

}
