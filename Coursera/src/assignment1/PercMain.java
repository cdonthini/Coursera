package assignment1;

public class PercMain {

	public static void main(String[] args) {
		boolean go = true;
		while (go) {
			System.out.print("size: ");
			Percolation perc = new Percolation(StdIn.readInt());
			
			while (!StdIn.isEmpty() ) {

				int p = StdIn.readInt();
				int q = StdIn.readInt();

				perc.open(p, q);
				go = perc.percolates();
				
				System.out.println(go);
				if ( go ) break;
			}
		}
	}
}
