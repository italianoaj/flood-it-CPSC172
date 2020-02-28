import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JComponent;
/**This class constructs the color grid that the user will see drawn on the screen.
 * It will also handle any updates that are made to the grid.
 * @author aitaliano
 *
 */
public class Grid extends JComponent {
	private static final long serialVersionUID = 1L;
	private final int BOARD_SIZE = 500;
	private final int TILE_SIZE = BOARD_SIZE/10;
	private final int DIMENTIONS = 10;
	private final int NUM_OF_COLORS = 5;
	private final int turns_X = 10;
	private final int turns_Y = 20;
	private Font turns = new Font("Arial", Font.BOLD, 20);
	private ArrayList<Color> colorlist = new ArrayList<Color>();
	Board board;
	/**
	 * This constructor creates the grid by the given dimentions and fills the array list with colors. 
	 */
	public Grid(){
		board = new Board(DIMENTIONS, NUM_OF_COLORS);
		colorlist.add(Color.RED);
		colorlist.add(Color.BLUE);
		colorlist.add(Color.GREEN);
		colorlist.add(Color.YELLOW);
		colorlist.add(Color.ORANGE);
		colorlist.add(Color.PINK);
	}
	/**
	 * This method does all the drawing that is needed inorder to view the grid. 
	 */
	public void paintComponent(Graphics g){
		for (int row=0; row<DIMENTIONS; row++) {
	       	   for (int col=0; col<DIMENTIONS; col++){
	       		   g.setColor(colorlist.get(board.getColor(row,col)));
	       		   g.fillRect(row*TILE_SIZE, col*TILE_SIZE, TILE_SIZE, TILE_SIZE);
	       	   }
		}
		g.setColor(Color.BLACK);
		g.setFont(turns);
		g.drawString("Turn:"+board.numMoves()+"/"+FloodIt.TURN_LIMIT, turns_X, turns_Y);
	}
	/**
	 * This method checks to see if the grid is filled with one color.
	 * @return returns true if the board is finished and false otherwise. 
	 */
	boolean finished(){
		return board.finished();
	}
	/**
	 * this method tells the move() method in the board class what color the user is attempting to fill the grid with.
	 * @param nextcolor- the color that the user is trying to fill with. 
	 */
	public void colorChange(int nextcolor){
		board.move(nextcolor);
	}
	/**
	 * This method calls the numMoves() method in the board class in order to retirve how many turns the user has taken. 
	 * @return - the number of moves taken by the user. 
	 */
	public int getMoves(){
		return board.numMoves();
	}
}
