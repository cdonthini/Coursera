package assignment2;

public class subset {

	public static void main(String[] args) {
		System.out
				.println("Enter \"D\" to use deque or \"R\" for randomizedqueue");
		String input = StdIn.readString();

		if (input == "D") {
			Deque<String> deque = new Deque<String>();
			while (!StdIn.isEmpty()) {
				String item = StdIn.readString();
				if (item.equals("l"))
					deque.addLast(item);
				else if (item.equals("--"))
					StdOut.println(deque.removeFirst() + " ");
				else if (item.equals("f"))
					deque.addFirst(item);
				else
					StdOut.println(deque.removeLast() + " ");
				StdOut.println("(" + deque.size() + " left on Deque)");
			}

		} else {
			RandomizedQueue<String> randQueue = new RandomizedQueue<String>();
			while (!StdIn.isEmpty()) {
				String item = StdIn.readString();
				if (item.equals("-"))
					StdOut.println("item removed: " + randQueue.dequeue());
				else if (item.equals("s"))
					StdOut.println("sample item: " + randQueue.sample());
				else
					randQueue.enqueue(item);
				StdOut.println("(" + randQueue.size() + " left on queue)");
			}
		}
	}

}
