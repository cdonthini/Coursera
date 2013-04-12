package assignment1;

public class PercMain {

	public static void main(String[] args) {
			
			Percolation perc = new Percolation(4);

			/*
			 while (!StdIn.isEmpty() ) {
			 
				
				int p = StdIn.readInt();
				int q = StdIn.readInt();
				
				perc.open ( p , q );
				
				System.out.println( perc.percolates() );
			}
			*/
			perc.open(1,2);
			perc.open(1,3);
			perc.open(2,2);
			perc.open(2,3);
			
			perc.open(0, 2);
			
			perc.open(1, 0);
			
			perc.open(3, 0);
			System.out.println(perc.percolates());
			perc.open(3, 2);
			
			System.out.println(perc.percolates());
	}
}
