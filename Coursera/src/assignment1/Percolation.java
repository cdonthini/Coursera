package assignment1;

public class Percolation {
	int size = 0;
	final int BLOCK = 0;
	final int OPEN = 1;
	final int FULL = 2;
	int grid[][];
	WeightedQuickUnionUF quickUnion;
	
	public Percolation( int N )              // create N-by-N grid, with all sites blocked
    {
		size = N;
		grid = new int [N][N] ;
		quickUnion = new WeightedQuickUnionUF ( N * N );
    }
	
	public void open(int i, int j)         // open site (row i, column j) if it is not already
	{
		grid[i][j] = OPEN;
		
		if ( ( i - 1 ) >= 0 && isOpen( i - 1 , j ) ) quickUnion.union( ( size * ( i - 1 ) ) + j , size * ( i )  + j); // up
		if ( ( j - 1 ) >= 0 && isOpen( i , j - 1 ) ) quickUnion.union( ( size * ( i ) ) + ( j - 1) , size * ( i )  + j); // left 
		if ( ( j + 1 ) < size && isOpen( i , j + 1 ) ) quickUnion.union( ( size * ( i ) ) + ( j + 1) , size * ( i )  + j); // right
		if ( ( i + 1 ) < size && isOpen( i + 1 , j ) ) quickUnion.union( ( size * ( i + 1 ) ) + j , size * ( i )  + j); // down 
		
	}
	
	public boolean isOpen(int i, int j)    // is site (row i, column j) open?
	{
		if ( grid[i][j] == OPEN ) return true;
		else return false;
		   
	}
	
	public boolean isFull(int i, int j)    // is site (row i, column j) full?
	{
		if ( grid[i][j] == FULL ) return true;
		else return false;
	}
	
	public boolean percolates()            // does the system percolate?
	{
		
		for ( int i = 0; i < size; i++ ) {
			if ( isFull ( size - 1, i ) )
				return true;
		}
		 
		return false;
		   
	}
}
