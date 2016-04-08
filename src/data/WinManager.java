package data;

/**
 * Class used to check if a win has occurred in the tic tac toe game.
 * @author Sean Wagner
 *
 */
public class WinManager {
	/**
	 * Array of squares that holds the click data.
	 */
	private Square[][] buttons;
	/**
	 * Standard constructor for the win manager.
	 * @param b Array of squares used to store the data for clicks.
	 */
	public WinManager(Square[][] b) {
		buttons = b;
	}
	
	/**
	 * Checks to see if a win has occurred.
	 * @return Boolean stating if a win has occurred.
	 */
	public boolean checkWin() {
		if (checkColumn()) {
			return true;
		}
		else if (checkRow()) {
			return true;
		}
		else if (checkDiagonal()) {
			return true;
		}
		return false;
	}
	/**
	 * Checks all columns for a TTT win.
	 * @return Returns true if win occurred.
	 */
	private boolean checkColumn() {
		for (int i=0;i<=2;i++) {
			if (buttons[i][0].getStatus()==1&&buttons[i][1].getStatus()==1&&buttons[i][2].getStatus()==1) {
				return true;
			}
			else if (buttons[i][0].getStatus()==2&&buttons[i][1].getStatus()==2&&buttons[i][2].getStatus()==2) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Checks all rows for a TTT win.
	 * @return Returns true if a win occurred.
	 */
	private boolean checkRow() {
		for (int i=0;i<=2;i++) {
			if (buttons[0][i].getStatus()==1&&buttons[1][i].getStatus()==1&&buttons[2][i].getStatus()==1) {
				return true;
			}
			else if (buttons[0][i].getStatus()==2&&buttons[1][i].getStatus()==2&&buttons[2][i].getStatus()==2) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Checks diagonally on the board for a TTT win.
	 * @return Returns true if a win has occurred.
	 */
	private boolean checkDiagonal() {
		if (buttons[0][0].getStatus()==1&&buttons[1][1].getStatus()==1&&buttons[2][2].getStatus()==1) {
			return true;
		}
		else if (buttons[0][0].getStatus()==2&&buttons[1][1].getStatus()==2&&buttons[2][2].getStatus()==2) {
			return true;
		}
		else if (buttons[2][0].getStatus()==1&&buttons[1][1].getStatus()==1&&buttons[0][2].getStatus()==1) {
			return true;
		}
		else if (buttons[2][0].getStatus()==2&&buttons[1][1].getStatus()==2&&buttons[0][2].getStatus()==2) {
			return true;
		}
		return false;
	}
}
