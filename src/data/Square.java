package data;
/**
 * Class used to store the click data for a board of Tic Tac Toe.
 * @author Sean Wagner
 *
 */
public class Square {
	//0=empty,1 is X, 2 is O
	/**
	 * Integer corresponding to the click status of the square.
	 */
	int status;
	/**
	 * Standard constructor for a new square.
	 */
	public Square() {status = 0;}
	/**
	 * Actions performed when a user clicks on a button.
	 */
	public void click() {
		int last = GameManager.getLastClick();
		GameManager.click();
		if (status!=0) {return;}
		if (last==0) {status = 1;}
		else if (last==1){status = 2;}
		else {return;}
	}
	/**
	 * Returns the status of the square.
	 * @return The status of the square.
	 */
	public int getStatus() { return status;}
	/**
	 * Sets the status of the square.
	 * @param i The status the square should be set as.
	 */
	public void setStatus(int i) { status = i;}
}