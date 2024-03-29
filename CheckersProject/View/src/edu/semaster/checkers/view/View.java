package edu.semaster.checkers.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
//import org.eclipse.swt.ole.win32.OleClientSite;
//import org.eclipse.swt.ole.win32.OleFrame;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
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

public class View implements IView 
{
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

	public static void main(String[] args) 
	{
		try {
			View window = new View();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void open() {

		final Display display = Display.getDefault();
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
		MenuItem statisticsItem = new MenuItem(menu, SWT.CASCADE);
		statisticsItem.setText("Statistics");
		statisticsItem.addListener(SWT.Selection, new Listener()
		  {
				public void handleEvent(Event event)
				{
					  MessageBox messageBox = new MessageBox(shell, SWT.ICON_INFORMATION);
				        
				        messageBox.setText("CHECKERS RULES");
				        messageBox.setMessage(
				        		        "1-Each player is given amaximum of 3minutes to make amove. \n" +
						        		"2-No cheating is allowed.\n" +
						        		"3-For those who decide to play against the computer watchout for game fines incase of an invalid move.\n" +
						        		"4-Black moves first. Players then alternate moves.\n" +
						        		"5-Moves are allowed only on the dark squares, so pieces always move diagonally. Single pieces are always limited to forward moves (toward the opponent).\n" +
						        		"6-A piece making a non-capturing move (not involving a jump) may move only one square.\n" +
						        		"7-A piece making a capturing move (a jump) leaps over one of the opponent's pieces, landing in a straight diagonal line on the other side. Only one piece may be captured in a single jump; however, multiple jumps are allowed on a single turn.\n" +
		                                 "When a piece is captured, it is removed from the board." );
				        int buttonID = messageBox.open();

				}
				      });

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

		Menu actionMenu = new Menu(menu);
		actionItem.setMenu(actionMenu);
		MenuItem undoItem = new MenuItem(actionMenu, SWT.NONE);
		undoItem.setText("Undo Move");
		
		actionItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
			undo();
			}
			});
		
       /*Menu actionMenu = new Menu(menu);
		actionItem.setMenu(actionMenu);
		MenuItem redoItem = new MenuItem(actionMenu, SWT.NONE);
		redoItem.setText("Redo Move");
		//undo eventHandler
		actionItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
			redo();
			}
			});*/
		
		
		Menu historyMenu = new Menu(menu);
		historyItem.setMenu(historyMenu);
		MenuItem previousGameItem = new MenuItem(historyMenu, SWT.NONE);
		previousGameItem.setText("Previous Game");
		//history eventHandler
		historyItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
			//history();
			}
			});
		
	
		Menu rulesMenu = new Menu(menu);
		rulesItem.setMenu(rulesMenu);
		MenuItem GamerulesItem = new MenuItem(rulesMenu, SWT.NONE);
		GamerulesItem.setText("Game Rules");

		Menu helpMenu = new Menu(menu);
		helpItem.setMenu(helpMenu);
		MenuItem helpContentsItem = new MenuItem(helpMenu, SWT.NONE);
		helpContentsItem.setText("Help Contents");
		
		
		
		 class Open implements SelectionListener 
		 {
		      public void widgetSelected(SelectionEvent event) 
		      {
		        Shell s = shell; 
		        
				FileDialog fd = new FileDialog(s, SWT.OPEN);
		        fd.setText("Open");
		        fd.setFilterPath("C:/");
		        String[] filterExt = { "*.checkers" };
		        fd.setFilterExtensions(filterExt);
		        String selected = fd.open();
		        System.out.println(selected);
		      }

		      public void widgetDefaultSelected(SelectionEvent event) {
		      }
		    }

		    class Save implements SelectionListener 
		    {
		      public void widgetSelected(SelectionEvent event)
		      {
		        Shell s = shell; 
		        
				FileDialog fd = new FileDialog(s, SWT.SAVE);
		        fd.setText("Save");
		        fd.setFilterPath("C:/");
		        String[] filterExt = {"*.checkers"};
		        fd.setFilterExtensions(filterExt);
		        String selected = fd.open();
		        System.out.println(selected);
		      }

		      public void widgetDefaultSelected(SelectionEvent event) {
		      }
		    }
		    openItem.addSelectionListener(new Open());
		    saveItem.addSelectionListener(new Save());
		    
		    
		    /*s.setMenuBar(m);
		    s.open();

		    while (!s.isDisposed()) {
		      if (!d.readAndDispatch())
		        d.sleep();
		    }
		    d.dispose();
		  }

		  public static void main(String[] argv) {
		    new FileDialogExample();
		  }

		}*/

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
		  
		  
		  GamerulesItem.addListener(SWT.Selection, new Listener()
		  {
				public void handleEvent(Event event)
				{
					  MessageBox messageBox = new MessageBox(shell, SWT.ICON_INFORMATION);
				        
				        messageBox.setText("CHECKERS RULES");
				        messageBox.setMessage(
				        		        "1-Each player is given amaximum of 3minutes to make amove. \n" +
						        		"2-No cheating is allowed.\n" +
						        		"3-For those who decide to play against the computer watchout for game fines incase of an invalid move.\n" +
						        		"4-Black moves first. Players then alternate moves.\n" +
						        		"5-Moves are allowed only on the dark squares, so pieces always move diagonally. Single pieces are always limited to forward moves (toward the opponent).\n" +
						        		"6-A piece making a non-capturing move (not involving a jump) may move only one square.\n" +
						        		"7-A piece making a capturing move (a jump) leaps over one of the opponent's pieces, landing in a straight diagonal line on the other side. Only one piece may be captured in a single jump; however, multiple jumps are allowed on a single turn.\n" +
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
						        messageBox.setMessage(helpMessage()	);        	 
						        		
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
						private String helpMessage()
						{
							StringBuilder helpText = new StringBuilder();
							helpText.append("1-How to play checkers.\n");
							helpText.append("2-How to install checkers on your computer.\n");
							helpText.append("3-Get updates of checkers.\n");
							
							return helpText.toString();
						}
					
				
		  });
				 
				 aboutItem.addListener(SWT.Selection, new Listener()
				  {
						public void handleEvent(Event event)
						{
							  MessageBox messageBox = new MessageBox(shell, SWT.ICON_INFORMATION);
						        
						        messageBox.setText("About Checkers");
						        messageBox.setMessage(
						        		"1-Checkers is played by two players. Each player begins the game with 12 colored discs.(Typically, one set of pieces is black and the other red.)\n" + 
						        		"2-The board consists of 64 squares, alternating between 32 dark and 32 light squares. It is positioned so that each player has a light square on the right side corner closest to him or her.\n" +
						        		"3-Each player places his or her pieces on the 12 dark squares closest to him or her.\n" +
						        		"4-Black moves first. Players then alternate moves.\n" +
						        		"5-Moves are allowed only on the dark squares, so pieces always move diagonally. Single pieces are always limited to forward moves (toward the opponent).\n" +
						        		"6-A piece making a non-capturing move (not involving a jump) may move only one square.\n" +
						        		"7-A piece making a capturing move (a jump) leaps over one of the opponent's pieces, landing in a straight diagonal line on the other side. Only one piece may be captured in a single jump; however, multiple jumps are allowed on a single turn.\n" +
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
//to be removed
	private void undo() {
		System.err.println("undo");
	
		//Undo();
		
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

	private Position boardToMousePosition(Position boardPosition) 
	{
		Position p = new Position();
		p.x = BOARD_OFFSET_X + FIGURE_WIDTH * boardPosition.x;
		p.y = BOARD_OFFSET_Y + FIGURE_HEIGHT * boardPosition.y;
		return p;
	}

	private Position mouseToBoardPosition(Position mousePosition)
	{
		Position p = new Position();
		p.x = (mousePosition.x - BOARD_OFFSET_X) / FIGURE_WIDTH;
		p.y = (mousePosition.y - BOARD_OFFSET_Y) / FIGURE_HEIGHT;
		return p;
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() 
	{
		shell = new Shell(SWT.DIALOG_TRIM);
		shell.setSize(500, 530);
		shell.setText("Checkers Game");

	}

	private void loadFigures(Display display)
	{
		m_boardImage = new Image(display,
				View.class.getResourceAsStream("board.jpg"));

		m_redFigure = new Image(display,
				View.class.getResourceAsStream("red_normal.jpg"));
		m_yellowFigure = new Image(display,
				View.class.getResourceAsStream("yellow_normal.jpg"));
	}

	private void initializeBoard()
	{
		m_board = new FigureType[8][8];

		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++)
				m_board[i][j] = getDefaultFigure(i, j);// new
														// FigureType(FigureType.Type.NONE);

	}

	private FigureType getDefaultFigure(int x, int y) 
	{

		if (x < 3) {
			if (!((x % 2 == 0 && y % 2 != 0) || (x % 2 != 0 && y % 2 == 0))) 
			{
				return new FigureType(FigureType.Type.BLACK);
			}
		}

		if (x > 4) {

			if (!((x % 2 == 0 && y % 2 != 0) || (x % 2 != 0 && y % 2 == 0))) 
			{
				return new FigureType(FigureType.Type.WHITE);
			}
		}

		return new FigureType(FigureType.Type.NONE);
	}

	@Override
	public void setFigurePosition(Point p, FigureType type)
	{
		m_board[p.getY()][p.getX()] = type;
	}

	@Override
	public void refreshUserInterface()
	{
		shell.redraw();
		shell.update();

	}

	@Override
	public void setStatusMessage(String message)
	{
		// TODO (Charles): Implement it
		// A call to some SWT API

	}

	@Override
	public void highlightClickedSquarePosition(Point p, boolean highlighted) 
	{
		if (p != null && highlighted) 
		{
			m_highlightedPosition = new Position(p.getX(), p.getY());
		} else {
			m_highlightedPosition = null;
		}
	}

	@Override
	public void clearHighlighting() 
	{
		// TODO Auto-generated method stub

	}

}
