import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 * This class runs the actual Flood It game by calling the necessary methods from other classes.
 * @author aitaliano
 *
 */
public class FloodIt {
	public static final int FRAME_WIDTH = 500;
	public static final int FRAME_HEIGHT = 525;
	public static final int TURN_LIMIT = 25;
/**
 * This method runs the Flood It game.
 * @param args
 */
	public static void main(String args[]){
		boolean play = true;
		while(play){
			JFrame frame = new JFrame("Flood It");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
			frame.setResizable(false);
			Grid comp = new Grid();
			frame.add(comp);
			frame.setVisible(true);
			JOptionPane.showMessageDialog(frame, "Welcome to Flood It! \nYour job is to fill the entire grid with a single color \nbegining with the top left-hand corner.");
			do {
				String nextColor = "";
				if (comp.getMoves()>TURN_LIMIT) break;
				do{
					nextColor = JOptionPane.showInputDialog("Choose the color you would like to flood: \n Red=0 \n Blue=1 \n Green=2 \n Yellow=3 \n Orange=4 \n Pink=5");
					if (nextColor==null){
						System.exit(0);
					}
				}
				while (!nextColor.equals("0")&&!nextColor.equals("1")&&!nextColor.equals("2")&&!nextColor.equals("3")&&!nextColor.equals("4")&&!nextColor.equals("5"));
				comp.colorChange(Integer.parseInt(nextColor));
				comp.repaint();
			}
			while (!comp.finished());
			if (comp.getMoves()<=TURN_LIMIT){
				int result = JOptionPane.showConfirmDialog(frame, "You flooded the board in "+comp.getMoves()+" turns! Would you like to play again?");
				if (result == JOptionPane.YES_OPTION){

				}else{
					play = false;
				}

			}else{
				int result = JOptionPane.showConfirmDialog(frame, "You failed to flood the board in 25 turns! Would you like to play again?");
				if (result == JOptionPane.YES_OPTION){

				}else{
					play = false;
				}
			}
		}
		System.exit(0);
	}
}
