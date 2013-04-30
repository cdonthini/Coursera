package assignment4;

public class Board {

	int[][] board,goalBoard;
	
	/**
	 * construct a board from an N-by-N array of blocks
     * (where blocks[i][j] = block in row i, column j)
	 * @param blocks
	 */
	public Board(int[][] blocks) {
		assert(blocks != null);
		board = blocks;
		goalBoard = board;
		setGoalBoard( );
	}
	
	private void setGoalBoard ( ) {
		int i, j = 0;
		for( i = 0; i < dimension(); i++ ) {
			for ( j = 0; j < dimension(); j++ ) {
				goalBoard[i][j] = ( i * 3 ) + j + 1; 
			}
		}
		goalBoard[i][j] = 0;
	}
	/**
	 * @return board dimension N
	 */
	public int dimension() {
		return board.length;
	}

	/**
	 * @return number of blocks out of place
	 */
	public int hamming() {
		int hammingScore = 0;
		for( int i = 0; i < dimension(); i++ ) {
			for ( int j = 0; j < dimension(); j++ ) {
				if ( board[i][j] != goalBoard[i][j] )
					hammingScore++;
			}
		}
		return hammingScore;
	}
	
	public int manhattan () {
		int manhattanScore = 0;
		for( int i = 0; i < dimension(); i++ ) {
			for ( int j = 0; j < dimension(); j++ ) {
				if ( board[i][j] != goalBoard[i][j] ) {
					//hammingScore++;
				}
			}
		}
		
		return manhattanScore;
	}

}

