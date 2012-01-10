package edu.semaster.checkers.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.ole.win32.OleClientSite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import edu.semaster.checkers.baseproject.FigureType;
import edu.semaster.checkers.baseproject.Point;
import edu.semaster.checkers.baseproject.Position;
import edu.semaster.checkers.presentation.IView;
import edu.semaster.checkers.presentation.Presenter;

public class View implements IView {
	static int BOARD_OFFSET_X = 16;
	static int BOARD_OFFSET_Y = 15;
	static int FIGURE_HEIGHT = 58;
	static int FIGURE_WIDTH = 58;

	private Shell shell;
	private FigureType[][] m_board;
	private Image m_boardImage;
	private Image m_redFigure;
	private Image m_yellowFigure;
	private Presenter m_presenter;

	private Position m_highlightedPosition = new Position(-1, -1);
	Menu menu, fileMenu, editMenu, viewMenu;

	public static void main(String[] args) {
		try {
			View window = new View();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void open() {

		Display display = Display.getDefault();
		createContents();
		loadFigures(display);
		initializeBoard();

		menu = new Menu(shell, SWT.BAR);
		MenuItem gameItem = new MenuItem(menu, SWT.CASCADE);
		gameItem.setText("Game");
		MenuItem actionItem = new MenuItem(menu, SWT.CASCADE);
		actionItem.setText("Action");
		MenuItem rulesItem = new MenuItem(menu, SWT.CASCADE);
		rulesItem.setText("Rules");
		MenuItem historyItem = new MenuItem(menu, SWT.CASCADE);
		historyItem.setText("History");
		MenuItem aboutItem = new MenuItem(menu, SWT.CASCADE);
		aboutItem.setText("About Checkers");
		MenuItem helpItem = new MenuItem(menu, SWT.CASCADE);
		helpItem.setText("Help");

		Menu gameMenu = new Menu(menu);
		gameItem.setMenu(gameMenu);
		MenuItem newItem = new MenuItem(gameMenu, SWT.NONE);
		newItem.setText("New Game");
		MenuItem openItem = new MenuItem(gameMenu, SWT.NONE);
		openItem.setText("Open...");
		MenuItem saveItem = new MenuItem(gameMenu, SWT.NONE);
		saveItem.setText("Save");
		new MenuItem(gameMenu, SWT.SEPARATOR);
		MenuItem exitItem = new MenuItem(gameMenu, SWT.NONE);
		exitItem.setText("Exit");

		Menu openMenu = new Menu(menu);
		actionItem.setMenu(openMenu);
		MenuItem fileItem = new MenuItem(openMenu, SWT.NONE);
		fileItem.setText("Undo");

		Menu historyMenu = new Menu(menu);
		historyItem.setMenu(historyMenu);
		MenuItem previousGameItem = new MenuItem(historyMenu, SWT.NONE);
		previousGameItem.setText("Previous Game");

		Menu rulesMenu = new Menu(menu);
		rulesItem.setMenu(rulesMenu);
		MenuItem GamerulesItem = new MenuItem(rulesMenu, SWT.NONE);
		GamerulesItem.setText("Game Rules");

		Menu helpMenu = new Menu(menu);
		helpItem.setMenu(helpMenu);
		MenuItem helpContentsItem = new MenuItem(helpMenu, SWT.NONE);
		helpContentsItem.setText("Help Contents");
		
		  
		 //exitItem.addSelectionListener(new MenuItemListener());
		  exitItem.addListener(SWT.Selection, new Listener()
		  {
				public void handleEvent(Event event)
				{
					MessageBox messageBox = new MessageBox(shell, SWT.ICON_QUESTION
							| SWT.YES | SWT.NO);
					messageBox.setMessage("Are you sure you want to exit checkers?");
					messageBox.setText("Checkers");
					if(true) shell.close();
				
					
					
				}
		  });
		  
		/* saveItem.addListener(SWT.Selection, new Listener()
		 {
		  class SaveListener implements Listener
		  {

				public OleClientSite olecs;
				public java.io.File file;

				public SaveListener(OleClientSite clientsite,java.io.File f) 
				{
					olecs = clientsite;	
					file =  f;
				}

				public void handleEvent (Event e) {
					System.out.println ("Save");
					if (olecs.isDirty()) {
						java.io.File tempFile = new java.io.File(file.getAbsolutePath() + ".tmp");
						file.renameTo(tempFile);
						if (olecs.save(file, true)){
							// save was successful so discard the backup
							tempFile.delete();
						}else {
				// save failed so restore the backup
						tempFile.renameTo(file);
			}
		}
	}		
}
		
		 	 });*/
	
		  					
		  
		  GamerulesItem.addListener(SWT.Selection, new Listener()
		  {
				public void handleEvent(Event event)
				{
					  MessageBox messageBox = new MessageBox(shell, SWT.ICON_INFORMATION);
				        
				        messageBox.setText("CHECKERS RULES");
				        messageBox.setMessage(
				        		"1-Checkers is played by two players. Each player begins the game with 12 colored discs.(Typically, one set of pieces is black and the other red.)=>" + 
				        		"2-The board consists of 64 squares, alternating between 32 dark and 32 light squares. It is positioned so that each player has a light square on the right side corner closest to him or her.=>" +
				        		"3-Each player places his or her pieces on the 12 dark squares closest to him or her.=>" +
				        		"4-Black moves first. Players then alternate moves.=>" +
				        		"5-Moves are allowed only on the dark squares, so pieces always move diagonally. Single pieces are always limited to forward moves (toward the opponent).=>" +
				        		"6-A piece making a non-capturing move (not involving a jump) may move only one square.=>" +
				        		"7-A piece making a capturing move (a jump) leaps over one of the opponent's pieces, landing in a straight diagonal line on the other side. Only one piece may be captured in a single jump; however, multiple jumps are allowed on a single turn." +
                                 "When a piece is captured, it is removed from the board." );
				        int buttonID = messageBox.open();
				        switch(buttonID) {
				          case SWT.YES:
				            // saves changes ...
				          case SWT.NO:
				            // exits here ...
				            break;
				          case SWT.CANCEL:
				            // does nothing ...
				        }
				        System.out.println(buttonID);
				}
				      });
		  
				 helpContentsItem.addListener(SWT.Selection, new Listener()
				  {
						public void handleEvent(Event event)
						{
							  MessageBox messageBox = new MessageBox(shell, SWT.ICON_INFORMATION);
						        
						        messageBox.setText("Help Contents");
						        messageBox.setMessage(
						        		"1-How to play checkers" + 
						        		"2-How to install checkers on your computer.=>" +
						        		"3-Get updates of checkers." 
						        		);
						        int buttonID = messageBox.open();
						        switch(buttonID) {
						          case SWT.YES:
						            // saves changes ...
						          case SWT.NO:
						            // exits here ...
						            break;
						          case SWT.CANCEL:
						            // does nothing ...
						        }
						        System.out.println(buttonID);
						      }
					
				
		  });

	
		  
		  
			newItem.addListener(SWT.Selection, new Listener()
			{
				public void handleEvent(Event event)
				{
					MessageBox messageBox = new MessageBox(shell, SWT.ICON_QUESTION
							| SWT.YES | SWT.NO);
					messageBox.setMessage("Create a new game?");
					messageBox.setText("Checkers");
					int rc = messageBox.open();

					System.out.println(rc == SWT.YES);
					System.out.println(rc == SWT.NO);
					
					
				}
				});
		  
		  shell.setMenuBar(menu);

		m_presenter = new Presenter(this);

		shell.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				Position boardPos = mouseToBoardPosition(new Position(e.x, e.y));
				m_presenter.onBoardPositionClicked(new Point(boardPos.getx(),
						boardPos.gety()));
			}
		});

		shell.addListener(SWT.Paint, new Listener() {
			public void handleEvent(Event event) {
				paintBoard(event.gc);
			}
		});

		shell.setBackgroundImage(m_boardImage);
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	private void paintBoard(GC gc) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {

				if (m_board[i][j].getFigureType() == FigureType.Type.BLACK)
					gc.drawImage(m_redFigure, BOARD_OFFSET_X + FIGURE_HEIGHT
							* j, BOARD_OFFSET_Y + FIGURE_WIDTH * i);

				if (m_board[i][j].getFigureType() == FigureType.Type.WHITE)
					gc.drawImage(m_yellowFigure, BOARD_OFFSET_X + FIGURE_HEIGHT
							* j, BOARD_OFFSET_Y + FIGURE_WIDTH * i);
			}
		}

		if (m_highlightedPosition != null && m_highlightedPosition.getx() != -1
				&& m_highlightedPosition.gety() != -1) {
			gc.setForeground(Display.getDefault().getSystemColor(
					SWT.COLOR_YELLOW));
			gc.setLineWidth(5);
			gc.drawRectangle(BOARD_OFFSET_X + FIGURE_HEIGHT
					* m_highlightedPosition.getx(), BOARD_OFFSET_Y
					+ FIGURE_WIDTH * m_highlightedPosition.gety(),
					FIGURE_WIDTH, FIGURE_HEIGHT);
		}

	}

	private Position boardToMousePosition(Position boardPosition) {
		Position p = new Position();
		p.x = BOARD_OFFSET_X + FIGURE_WIDTH * boardPosition.x;
		p.y = BOARD_OFFSET_Y + FIGURE_HEIGHT * boardPosition.y;
		return p;
	}

	private Position mouseToBoardPosition(Position mousePosition) {
		Position p = new Position();
		p.x = (mousePosition.x - BOARD_OFFSET_X) / FIGURE_WIDTH;
		p.y = (mousePosition.y - BOARD_OFFSET_Y) / FIGURE_HEIGHT;
		return p;
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell(SWT.DIALOG_TRIM);
		shell.setSize(500, 530);
		shell.setText("Checkers Game");

	}

	private void loadFigures(Display display) {
		m_boardImage = new Image(display,
				View.class.getResourceAsStream("board.jpg"));

		m_redFigure = new Image(display,
				View.class.getResourceAsStream("red_normal.jpg"));
		m_yellowFigure = new Image(display,
				View.class.getResourceAsStream("yellow_normal.jpg"));
	}

	private void initializeBoard() {
		m_board = new FigureType[8][8];

		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++)
				m_board[i][j] = getDefaultFigure(i, j);// new
														// FigureType(FigureType.Type.NONE);

	}

	private FigureType getDefaultFigure(int x, int y) {

		if (x < 3) {
			if (!((x % 2 == 0 && y % 2 != 0) || (x % 2 != 0 && y % 2 == 0))) {
				return new FigureType(FigureType.Type.BLACK);
			}
		}

		if (x > 4) {

			if (!((x % 2 == 0 && y % 2 != 0) || (x % 2 != 0 && y % 2 == 0))) {
				return new FigureType(FigureType.Type.WHITE);
			}
		}

		return new FigureType(FigureType.Type.NONE);
	}

	@Override
	public void setFigurePosition(Point p, FigureType type) {
		m_board[p.getY()][p.getX()] = type;
	}

	@Override
	public void refreshUserInterface() {
		shell.redraw();
		shell.update();

	}

	@Override
	public void setStatusMessage(String message) {
		// TODO (Charles): Implement it
		// A call to some SWT API

	}

	@Override
	public void highlightClickedSquarePosition(Point p, boolean highlighted) {
		if (p != null && highlighted) {
			m_highlightedPosition = new Position(p.getX(), p.getY());
		} else {
			m_highlightedPosition = null;
		}
	}

	@Override
	public void clearHighlighting() {
		// TODO Auto-generated method stub

	}

}
