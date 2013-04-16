package assignment1;

public class Percolation {
	int size = 0;
	boolean FRowOn = false;
	boolean firColFillB[];
	int firColFill[];
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
		firColFillB = new boolean[N];
		//firColFill = new int[N];
		quickUnion = new WeightedQuickUnionUF(N * N);
	}

	public void open(int i, int j) // open site (row i, column j) if it is not
									// already
	{
		if ( i >= size || j >= size || j < 0 || i < 0 ) {
			throw new java.lang.IndexOutOfBoundsException();
		}
		grid[i][j] = OPEN;
		if ((i - 1) >= 0 && isOpen(i - 1, j)) {
			quickUnion.union((size * (i - 1)) + j, size * (i) + j); // up
			
		}
		if ((j - 1) >= 0 && isOpen(i, j - 1)) {
			quickUnion.union((size * (i)) + (j - 1), size * (i) + j); // left
			
		}
		if ((j + 1) < size && isOpen(i, j + 1)) {
			quickUnion.union(size * (i) + j , (size * (i)) + (j + 1) ); // right
			
		}
		if ((i + 1) < size && isOpen(i + 1, j)) {
			quickUnion.union( size * (i) + j , (size * (i + 1)) + j ); // down
			
		}
		
		if ( i == 0 ) {
			FRowOn = true;
			firColFillB [ j ] = true;
			//firColFill [ j ] = quickUnion.find( j );
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
				for ( int j = 0; j < size; j++ ) {
					if ( firColFillB [ i ] ) {
						if ( quickUnion.find( i ) == quickUnion.find( ( size * ( size - 1 ) ) + j ) ) {
							return true;
						}
					}
					else continue;
				}
			}
		}
		return false;

	}
}
