package assignment1;

public class Percolation {

	
	public Percolation( int N )              // create N-by-N grid, with all sites blocked
    {
		grid = new int [N][N] ;
		unionFind = new WeightedQuickUnionUF ( N * N );
    }
	
	public void open(int i, int j)         // open site (row i, column j) if it is not already
	{
		grid[i][j] = OPEN;
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
		
		unionFind.count(); //TODO 
		return false;
		   
	}
}
