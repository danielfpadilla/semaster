package checkers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class CheckBoard 
{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run()
			{
				try {
					CheckBoard window = new CheckBoard();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CheckBoard() 
	{
		initialize();
		//public void run() {
		      double sqSize = (double) getHeight() / NROWS;
		      for (int i = 0; i < NROWS; i++) {
		         for (int j = 0; j < NCOLUMNS; j++) {
		            double x = j * sqSize;
		            double y = i * sqSize;
		            GRect sq = new GRect(x, y, sqSize, sqSize);
		            sq.setFilled((i + j) % 2 != 0);
		            add(sq);
		         }
		      }
		   }
		 
		private double getHeight() {
		// TODO Auto-generated method stub
		return NROWS;
	
		}

		/* Private constants */
		   private static final int NROWS = 8;     /* Number of rows    */
		   private static final int NCOLUMNS = 8;  /* Number of columns */
		 
	//}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenuItem Game = new JMenuItem("Game");
		Game.setBackground(Color.LIGHT_GRAY);
		menuBar.add(Game);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Open");
		menuBar.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Save");
		menuBar.add(mntmNewMenuItem_1);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		menuBar.add(mntmExit);
		
		JMenuItem mntmAction = new JMenuItem("Action");
		menuBar.add(mntmAction);
		
		JMenuItem mntmUndo = new JMenuItem("Undo");
		menuBar.add(mntmUndo);
		
		JMenuItem mntmHistory = new JMenuItem("History");
		menuBar.add(mntmHistory);
		
		JMenuItem mntmHelp = new JMenuItem("Help");
		menuBar.add(mntmHelp);
		
		JMenuItem mntmRules = new JMenuItem("Rules");
		menuBar.add(mntmRules);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		menuBar.add(mntmAbout);
	}

}
