package graphics;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import data.GameManager;
import data.Square;

/**
 * A tic tac toe board class.
 * @author Sean Wagner
 *
 */
public class Board {
	/**
	 * Frame for the GUI.
	 */
	private static JFrame frame;
	/**
	 * Array of buttons which store the location of each GUI button.
	 */
	private static TTTButton[][] buttons = new TTTButton[3][3];
	/**
	 * Stack of buttons which stores the previous click to allow the undo function to work.
	 */
	private static Stack<TTTButton> prevButton = new Stack<TTTButton>();
	/**
	 * The undo button so users may reverse clicks.
	 */
	private static JButton undo = new JButton("Undo");
	/**
	 * Game manager used to control the board and handle game events.
	 */
	private static GameManager gm;
	
	/**
	 * Constructor for the board.
	 * @param b Array of Squares used to store the data for each click.
	 */
	public Board(Square[][] b) {
		gm = new GameManager();
		initialize(b);
	}
	
	/**
	 * Main method for executing board creation.
	 * @param args Arguments defaulted by Java.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Board window = new Board(GameManager.getButtons());
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Initializes the board.
	 * @param b An array of Squares for the storage of data ("X's and O's").
	 */
	public static void initialize(Square[][] b) {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		int k = 0;
		int l = 0;
		for(int i = 0;i<=400;i+=200) {
			for(int j = 0;j<=400;j+=200) {
				buttons[l][k] = newButton(i,j,frame,k,l);
				l++;
			}
			k++;
			l=0;
		}
		//create new game button
		JButton ng = new JButton("New Game");
		ng.setBounds(0, 600, 300, 35);
		frame.add(ng);
		ng.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//reset game here when reset button clicked
				undo.setEnabled(false);
				gm.reset();
				for(int i =0;i<3;i++) {
					for(int j =0;j<3;j++) {
						buttons[i][j].setText("");
						buttons[i][j].setEnabled(true);
					}
				}
				prevButton = new Stack<TTTButton>();
			}
        });
		//create end game button
		JButton eg = new JButton("Exit");
		eg.setBounds(300, 600, 300, 35);
		frame.add(eg);
		eg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//exit game when button clicked
				System.exit(0);
			}
        });
		undo.setBounds(0, 640, 600, 35);
		frame.add(undo);
		undo.setEnabled(false);
		undo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (prevButton.isEmpty()) {
					JOptionPane.showMessageDialog(frame,"There are no moves to undo.","Error", JOptionPane.WARNING_MESSAGE);
					return;
				}
				TTTButton b = prevButton.pop();
				Square[][] squares = gm.getButtons();
				squares[b.getRow()][b.getCol()].setStatus(0);
				gm.click();
				if (prevButton.isEmpty()) {
					undo.setEnabled(false);
				}
				b.setText("");
				b.setEnabled(true);
				
			}
		});
	}
	/**
	 * Used to create a new button on the frame.
	 * @param x X position on the frame.
	 * @param y Y position on the frame.
	 * @param f Frame to be placed on.
	 * @param row Row of the tic tac toe board.
	 * @param col Column of the tic tac toe board.
	 * @return A newly created button for the frame.
	 */
	private static TTTButton newButton(int x,int y,JFrame f,int row, int col) {
		//create button
		final TTTButton button = new TTTButton("",row,col);
		final int r = row;
		final int c = col;
		//button.setFont(new Font("serif",Font.BOLD,65));
		button.setBounds(x, y, 200, 200);
		f.getContentPane().add(button);
		//change the button font and font size
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Square[][] current = GameManager.getButtons();
				current[r][c].click();
				if (current[r][c].getStatus()==1) {
					undo.setEnabled(true);
					button.setText("X");
					prevButton.push(button);
				}
				else if (current[r][c].getStatus()==2) {
					undo.setEnabled(true);
					button.setText("O");
					prevButton.push(button);
				}
				button.setEnabled(false);
				if (GameManager.getWinManager().checkWin()) {
					undo.setEnabled(false);
					for(int i =0;i<3;i++) {
						for(int j =0;j<3;j++) {
							buttons[i][j].setEnabled(false);
						}
					}
					String winner;
					if (GameManager.getLastClick()==0) {winner = "O's";}
					else { winner = "X's"; }
					JOptionPane.showMessageDialog(frame,"The "+winner+" have won the game.","Winner",JOptionPane.OK_OPTION);
					
				}
			}
        });
		return button;
	}
}
