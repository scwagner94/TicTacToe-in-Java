import org.junit.Before;
import org.junit.Test;
import data.GameManager;
import data.Square;
import data.WinManager;

import junit.framework.TestCase;

/**
 * 
 */

/**
 * @author Sean Wagner
 * Tests for Tic Tac Toe game.
 */
public class TTTtest extends TestCase {
	/**
	 * Tests the state of each square after clearing the board
	 */
	@Test
	public void testSquareStateNewBoard() {
		Square[][] b = newBoard();
		for(int i = 0; i < 3;i++) {
			for (int j = 0;j<3;j++) {
				assertEquals(b[i][j].getStatus(),0);
			}
		}
	}
	/**
	 * Tests the state of each square after a horizontal win
	 */
	@Test
	public void testHorizontalWin() {
		Square[][] b = newBoard();
		b[0][0].setStatus(1);
		b[0][1].setStatus(1);
		b[0][2].setStatus(1);
		WinManager wm = new WinManager(b);
		assertTrue(wm.checkWin());
	}
	/**
	 * Tests if a win is registered after a vertical win.
	 */
	@Test
	public void testVerticalWin() {
		Square[][] b = newBoard();
		b[0][0].setStatus(1);
		b[1][0].setStatus(1);
		b[2][0].setStatus(1);
		WinManager wm = new WinManager(b);
		assertTrue(wm.checkWin());
	}
	/**
	 * Tests if a win is processed on a diagonal board.
	 */
	@Test
	public void testDiagWin() {
		Square[][] b = newBoard();
		b[0][0].setStatus(1);
		b[1][1].setStatus(1);
		b[2][2].setStatus(1);
		WinManager wm = new WinManager(b);
		assertTrue(wm.checkWin());
	}
	/**
	 * Tests the win manager state after a winning game.
	 */
	@Test
	public void testWinManager() {
		Square[][] b = newBoard();
		b[1][0].setStatus(1);
		b[1][1].setStatus(1);
		b[1][2].setStatus(1);
		WinManager wm = new WinManager(b);
		assertTrue(wm.checkWin());
	}
	/**
	 * Tests the state of all squares on a full board and that moves are illegal.
	 */
	@Test
	public void testSquareStateFull() {
		Square[][] b = newBoard();
		assertEquals(b[0][0].getStatus(),0);
		assertEquals(b[0][1].getStatus(),0);
		assertEquals(b[0][2].getStatus(),0);
		assertEquals(b[1][0].getStatus(),0);
		assertEquals(b[1][1].getStatus(),0);
		assertEquals(b[1][2].getStatus(),0);
		assertEquals(b[2][0].getStatus(),0);
		assertEquals(b[2][1].getStatus(),0);
		assertEquals(b[2][2].getStatus(),0);
	}
	/**
	 * Creates a new board for testing.
	 * @return A blank board of squares.
	 */
	public Square[][] newBoard() {
		Square[][] retVal = new Square[3][3];
		for (int i =0;i<3;i++) {
			for (int j = 0; j<3;j++) {
				retVal[i][j] = new Square();
			}
		}
		return retVal;
	}
}
