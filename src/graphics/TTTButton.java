package graphics;

import java.awt.Font;

import javax.swing.JButton;

import data.Square;
/**
 * A subclass of JButton which is used for buttons on a Tic Tac Toe board.
 * @author Sean Wagner
 *
 */
public class TTTButton extends JButton {
	/**
	 * The row the button is on of the TTT frame.
	 */
	int row;
	/**
	 * The column the button is on of the TTT frame.
	 */
	int col;
	
	/**
	 * Standard constructor for a new button.
	 * @param s Button text.
	 * @param r Row of the button.
	 * @param c Column of the button.
	 */
	public TTTButton(String s, int r, int c) {
		super(s);
		this.setFont(new Font("serif",Font.BOLD,65));
		row = r;
		col = c;
	}
	/**
	 * Getter for the row of the button.
	 * @return The row of the button.
	 */
	public int getRow() {return row;}
	/**
	 * Getter for the column of the button.
	 * @return The column of the button.
	 */
	public int getCol() {return col;}
	
	
	

	
}
