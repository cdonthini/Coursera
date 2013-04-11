package assignment1;

public class PercMain {

	public static void main(String[] args) {
			
			Percolation perc = new Percolation(4);

			while (!StdIn.isEmpty() ) {
				
				int p = StdIn.readInt();
				int q = StdIn.readInt();
				
				perc.open ( p , q );
				
				System.out.println( perc.percolates() );
			}
	}
}
