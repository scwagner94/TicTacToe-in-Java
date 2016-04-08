package data;

import graphics.Board;

/**
 * Manager for the Tic Tac Toe Game. Ensures all actions and events are handled.
 * @author Sean Wagner
 *
 */
public class GameManager {
	/**
	 * Instance of the Win Manager that is used to check if a win has occurred.
	 */
	private static WinManager wm;
	/**
	 * Byte used to store the last click, or last piece placed on the board.
	 */
	private static byte lastClick = 0;
	/**
	 * Array of Square used to store the click data and which pieces are on the board.
	 */
	private static Square[][] buttons;
	/**
	 * Constant used to determine the size of the board.
	 */
	private static byte boardSize = 3;
	/**
	 * Getter for the buttons array that stores click data.
	 * @return The array of buttons with click data.
	 */
	public static Square[][] getButtons() {return buttons;}
	
	/**
	 * Default constructor for the game manager.
	 */
	public GameManager() {
		buttons = new Square[boardSize][boardSize];
		for (int i = 0; i<boardSize;i++) {
			for (int j = 0; j < boardSize;j++) {
				buttons[i][j] = new Square();
			}
		}
		wm = new WinManager(buttons);
	}
	
	/**
	 * Alternative method of checking the win on the board.
	 * @return Returns true if a win has occurred.
	 */
	public static boolean checkWin() {
		return wm.checkWin();
	}
	/**
	 * Resets the board after a win, in preparation for a new game.
	 */
	public void reset() {
		buttons = new Square[boardSize][boardSize];
		for (int i = 0; i<boardSize;i++) {
			for (int j = 0; j < boardSize;j++) {
				buttons[i][j] = new Square();
			}
		}
		wm = new WinManager(buttons);
		lastClick = 0;
	}
	
	/**
	 * Getter for the Win Manager.
	 * @return Returns the Win Manager instance used.
	 */
	public static WinManager getWinManager() { return wm; }

	
	/**
	 * Getter for the last click placed, allowing the board to place the next piece.
	 * @return Returns the byte representing the last click made.
	 */
	public static byte getLastClick() {
		return lastClick;
	}
	
	/**
	 * Actions performed whenever a user clicks on the board.
	 */
	public static void click() {
		if (lastClick==0) {
			lastClick++;
		}
		else {
			lastClick--;
		}
	}
}
