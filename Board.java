
/**The board class for the Flood-It game.  This class implements a NxN board filled with numColors colors.
 * The class implements several methods to allow the playing of the game.
 */
class Board {
	int [][] board;
	int moves;
	public int randomNumber;
	private int row, col, size;
	/**Constructs a new sizeXsize board filled where each element on the board is a random number between 0
	 * and numColors.  Also initializes the number of moves to zero.
	 * @param size -- the size of the board
	 * @param numColors -- the number of possible entries on the board
	 */
	public Board(int size,int numColors) {
		board = new int[size][size];
		this.moves = 0;
		this.size=size;
		for (row=0; row<board.length; row++) {
			for (col=0; col<board[row].length; col++){
				randomNumber = (int)(Math.random()*(numColors+1));
				board[row][col] = randomNumber;
			}
		}
	}
	/**Updates the board to fill (from the top left corner) with a specified color.  
	 * Filling stops when any other color is hit besides the one in the top left corner.
	 * Play the game at http://www.lemoda.net/javascript/flood-it/ or http://unixpapa.com/floodit/?sz=14&nc=4
	 * to get a better understanding of what this method should do.
	 * You will probably also want to take a look at the algorithm described
	 * at http://en.wikipedia.org/wiki/Flood_fill which describes what this method should do.
	 * I recommend the Stack-based recursive implementation.  It is a recursive algorithm for
	 * flooding the board.  It is one of the easier ones to implement.
	 * You are free to have this method call other methods.  I would recommend creating a private method that
	 * this method calls and have that private method be the recursive method.
	 * A recursive method is one that calls itself.
	 * @param color -- the new color to flood the board with.
	 */
	public void move(int color) {
		floodFill(board[0][0], color, 0, 0);
		moves++;
	}
	/**
	 * This method is a recursion method that calls itself in order to flood the board with a specific color. 
	 * @param color- the current color that is held at position x,y.
	 * @param replacement- the new color the user is attempting to fill the board with.
	 * @param x- the x location of the current color.
	 * @param y- the y location of the current color.
	 */
	private void floodFill(int color, int replacement, int x, int y){
		if (color==replacement){
			return;
		}
		if (board[x][y]!=color){
			return;
		}
		board[x][y]=replacement;
		if (y-1>=0){
			floodFill(color, replacement, x, y-1);
		}
		if (y+1<board.length){
			floodFill(color, replacement, x, y+1);
		}
		if (x-1>=0){
			floodFill(color, replacement, x-1, y);
		}
		if (x+1<board.length){
			floodFill(color, replacement, x+1, y);
		}

	}
	/**returns true if the board is not completely filled with a single color.
	 * Otherwise it returns false.
	 * @return true if board is all one color
	 */
	public boolean finished() {
		for (row=0; row<board.length; row++) {
			for (col=0; col<board[row].length; col++){
				if (board[row][col] != board[0][0]){
					return false;
				}
			}
		}
		return true;
	}
	/**returns how many times the move() method has been called.
	 * @return the number of times the move() method has been called.
	 */
	public int numMoves() {
		return moves;
	}
	/**Returns a string representation of the board.  Use tabs between elements of the board.
	 * And have every row of the board be separated by a newline character.
	 * Example:
	 * "1\t0\t3\t\n2\t0\t2\t\n1\t0\t1\t\n"
	 * @return a String representation of the board
	 */
	public String toString() {
		String result = "";
		for (row=0; row<board.length; row++) {
			for (col=0; col<board[row].length; col++){
				result+=board[row][col];
				if (col+1<board[row].length){
					result+="\t";
				}
			}
			if (row+1 <board.length) {
				result+="\n";
			}
		}
		return result;
	}
	/**
	 * This method returns the current color held at position row2,col2.
	 * @param row2- the row that the color is currently in.
	 * @param col2- the column that the color is currently in.
	 * @return board[row2][col2]- returns the color that is held at this position. 
	 */
	public int getColor(int row2, int col2) {
		return board[row2][col2];
	}
}