package assignment1;

public class Percolation {
	int size = 0;
	boolean FRowOn = false;
	final int BLOCK = 0;
	final int OPEN = 1;
	final int FULL = 2;
	final int UP = 1;
	final int DOWN = 2;
	final int RIGHT = 3;
	final int LEFT = 4;
	
	int grid[][];
	WeightedQuickUnionUF quickUnion;

	public Percolation(int N) // create N-by-N grid, with all sites blocked
	{
		size = N;
		grid = new int[N][N];
		quickUnion = new WeightedQuickUnionUF(N * N);
	}

	public void open(int i, int j) // open site (row i, column j) if it is not
									// already
	{
		if ( i == 0 ) FRowOn = true;
		grid[i][j] = OPEN;
		if ((i - 1) >= 0 && isOpen(i - 1, j)) {
			quickUnion.union((size * (i - 1)) + j, size * (i) + j); // up
			
		}
		if ((j - 1) >= 0 && isOpen(i, j - 1)) {
			quickUnion.union((size * (i)) + (j - 1), size * (i) + j); // left
			
		}
		if ((j + 1) < size && isOpen(i, j + 1)) {
			quickUnion.union((size * (i)) + (j + 1), size * (i) + j); // right
			
		}
		if ((i + 1) < size && isOpen(i + 1, j)) {
			quickUnion.union((size * (i + 1)) + j, size * (i) + j); // down
			
		}

	}

	private void fill(int i, int j , int prev ) {
		
		
		grid[i][j] = FULL;
		
		if ((i - 1) >= 0 && isFull(i - 1, j) && ( prev != DOWN ) ) {
			//quickUnion.union((size * (i - 1)) + j, size * (i) + j); // up
			fill(i - 1, j, UP);
		}
		if ((j - 1) >= 0 && isFull(i, j - 1)  && ( prev != RIGHT ) ) {
			//quickUnion.union((size * (i)) + (j - 1), size * (i) + j); // left
			fill(i, j - 1, LEFT);
		}
		if ((j + 1) < size && isFull(i, j + 1) && ( prev != LEFT ) ) {
			//quickUnion.union((size * (i)) + (j + 1), size * (i) + j); // right
			fill(i, j + 1, RIGHT);
		}
		if ((i + 1) < size && isFull(i + 1, j)  && ( prev != UP ) ) {
			//quickUnion.union((size * (i + 1)) + j, size * (i) + j); // down
			fill(i + 1, j, DOWN);
		}
	}

	public boolean isOpen(int i, int j) // is site (row i, column j) open?
	{
		if (grid[i][j] == OPEN)
			return true;
		else
			return false;

	}

	public boolean isFull(int i, int j) // is site (row i, column j) full?
	{
		if (grid[i][j] >= OPEN)
			return true;
		else
			return false;
	}

	public boolean percolates() // does the system percolate?
	{
		if( FRowOn ) {
			for ( int i = 0; i < size; i++ ) {
				if ( grid[0][i] >= OPEN) {
					fill( 0 , i , 0);
				}
			}
		}
		return false;

	}
}
