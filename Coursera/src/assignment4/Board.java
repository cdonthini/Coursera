package assignment4;

import java.util.ArrayList;
import java.util.List;

class Point {
	int x , y;
	public Point ( int x, int y ) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setPoint( int x, int y) {
		setX(x);
		setY(y);
	}
}
public class Board {

	int[][] board, goalBoard;
	int movesMade = 0;
	Point empty;
	/**
	 * construct a board from an N-by-N array of blocks (where blocks[i][j] =
	 * block in row i, column j)
	 * 
	 * @param blocks
	 */
	public Board(int[][] blocks) {
		assert (blocks != null);
		this.board = blocks;
		this.empty =  new Point (0,0);
		setGoalBoard(board);
	}
	public Board(int[][] blocks, Point empty) {
		assert (blocks != null);
		this.board = blocks;
		this.empty =  empty;
		setGoalBoard(board);
	}

	private void setGoalBoard(int[][] blocks) {
		goalBoard = new int[dimension()][dimension()];
		int i, j = 0;
		for (i = 0; i < dimension(); i++) {
			for (j = 0; j < dimension(); j++) {
				goalBoard[i][j] = (i * 3) + j + 1;
				if ( board[i][j] == 0 ) empty.setPoint(i, j);
			}
		}
		goalBoard[i - 1][j - 1] = 0;
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
		for (int i = 0; i < dimension(); i++) {
			for (int j = 0; j < dimension(); j++) {
				if (board[i][j] != goalBoard[i][j] && board[i][j] != 0)
					hammingScore++;
			}
		}
		return hammingScore + movesMade;
	}

	/**
	 * @return sum of Manhattan distances between blocks and goal
	 */
	public int manhattan() {
		int manhattanScore = 0, horiz = 0, verti = 0;
		for (int i = 0; i < dimension(); i++) {
			for (int j = 0; j < dimension(); j++) {
				if (board[i][j] > 0) {
					horiz = (board[i][j] - 1) % dimension();
					verti = (board[i][j] - 1) / dimension();
					manhattanScore += (Math.abs(horiz - j) + Math
							.abs(verti - i));
				}
			}
		}
		return manhattanScore + movesMade;
	}

	/**
	 * 
	 * @return is this board the goal board?
	 */
	public boolean isGoal() {

		return board == goalBoard;
	}

	/**
	 * @return a board obtained by exchanging two adjacent blocks in the same
	 *         row
	 */
	public Board twin() {
		
		for (int i = 0; i < dimension(); i++) {
			for (int j = 0; j < dimension() - 1; j++) {
				if (this.board[i][j] > 0 && this.board[i][j + 1] > 0) {
					int temp = this.board[i][j];
					this.board[i][j] = this.board[i][j + 1];
					this.board[i][j + 1] = temp;
					i = dimension();
					break;

				}
			}
		}
		return this;
	}

	/**
	 * does this board equal y?
	 */
	public boolean equals(Object y) {
		Board that = (Board) y;
		return this.board == that.board;
	}

	/**
	 * @return // all neighboring boards
	 */
	public List<Board> neighbors() {
		List<Board> listofBoards = new ArrayList<Board>();
		final int[][] temp = board;
		Point newEmpty;
		/**
		 * Need to add stuff about disallowing a previously made move
		 */
		//System.out.println(board[empty.getX()][empty.getY()-1]);
		if ( empty.getY() - 1 >= 0 ){
			board[empty.getX()][empty.getY()] = board[empty.getX()][empty.getY()-1];
			board[empty.getX()][empty.getY()-1] = 0;
			newEmpty = new Point(empty.getX(),empty.getY()-1);
			listofBoards.add(new Board(board,newEmpty));
		}
		this.board = temp ;
		if ( empty.getY() + 1 < dimension()){
			board[empty.getX()][empty.getY()] = board[empty.getX()][empty.getY()+1];
			board[empty.getX()][empty.getY()+1] = 0;
			newEmpty = new Point(empty.getX(),empty.getY()+1);
			listofBoards.add(new Board(board,newEmpty));
		}
		this.board = temp;
		if ( empty.getX() + 1 < dimension()){
			board[empty.getX()][empty.getY()] = board[empty.getX()+1][empty.getY()];
			board[empty.getX()+1][empty.getY()] = 0;
			newEmpty = new Point(empty.getX()+1,empty.getY());
			listofBoards.add(new Board(board,newEmpty));
		}
		this.board = temp;
		if ( empty.getY() - 1 >= 0){
			board[empty.getX()][empty.getY()] = board[empty.getX()-1][empty.getY()];
			board[empty.getX()-1][empty.getY()] = 0;
			newEmpty = new Point(empty.getX()-1,empty.getY());
			listofBoards.add(new Board(board,newEmpty));
		}
		this.board = temp;
		return listofBoards;
	}
	

}
