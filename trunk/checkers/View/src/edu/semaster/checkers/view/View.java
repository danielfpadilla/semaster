package edu.semaster.checkers.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class View {
	static int BOARD_OFFSET_X = 0;
	static int BOARD_OFFSET_Y = 0;
	static int FIGURE_HEIGHT ;
	static int FIGURE_WIDTH;
	protected Shell shell;
	 static int[][] m_board;

	public static void main(String[] args) {
	try {
	View window = new View();
	window.open();
	} catch (Exception e) {
	e.printStackTrace();
	}

	final Display display = new Display();
	Shell shell = new Shell(display);
	shell.addListener(SWT.Paint, new Listener() {
		
	public void initializeBoard() 
	{
	for (int i = 0; i < 8; i++)
	  for (int j = 0; j < 8; j++)
	     m_board[i][j] = getImagePositions(i, j);
        }

	private int getImagePositions(int x, int y) 
	{

	     if (x < 4) 
	      {
	        if ((x % 2 == 0 && y % 2 != 0)
	        || (x % 2 != 0 && y % 2 == 1))
	        {
	         return 1;
	        }
              }

	      if (x > 5) 
	       {

	         if ((x % 2 == 0 && y % 2 != 0)
	         || (x % 2 != 0 && y % 2 == 0)) 
	         {
	         return 2;
                 }
	        }
	
	      return 0;
	}
/*
	@Override
	public void handleEvent(Event e) 
	{
	 GC gc = event.gc; 
	 for (int i = 0; i < 8; i++) 
	   for (int j = 0; j <8; j++)
		   gc.drawImage(redFigure,boardToMousePosition(new Position(i, j)));
	}
	*/
	//});


//	shell.addListener(SWT.Paint, new Listener() {
		public void handleEvent(Event event){
	           // drawImages()
			//{
			GC gc=event.gc;
			  for (int i = 0; i < 8; i ++)
			     {
			      for (int j = 0; j < 8; j++)
			       {
			    
			if (m_board[i][j] == 1)
			       gc.drawImage(redFigure,
			       BOARD_OFFSET_X + FIGURE_HEIGHT * i,
			       BOARD_OFFSET_Y + FIGURE_WIDTH * j);
			     
			if (m_board[i][j] == 2)
			       gc.drawImage(yellowFigure,
			       BOARD_OFFSET_X + FIGURE_HEIGHT * i,
			       BOARD_OFFSET_Y + FIGURE_WIDTH * j);
			       }
			      }
		          //}	
		}

	});
	
	shell.open();
	while (!shell.isDisposed()) {
	if (!display.readAndDispatch())
	display.sleep();
	}
	}

	/**
	* Open the window.
	*/
	public void open() {
	Display display = Display.getDefault();
	createContents();
	Image image = new Image(display,
	View.class.getResourceAsStream("board.jpg"));

	Image redFigure = new Image(display,
	View.class.getResourceAsStream("red_normal.jpg"));
	GC gc = new GC(image);
	gc.drawImage(redFigure, 22, 20);
	gc.drawImage(redFigure, 138, 20);
	gc.drawImage(redFigure, 254, 20);
	gc.drawImage(redFigure, 370, 20);

	gc.drawImage(redFigure, 80, 80);
	gc.drawImage(redFigure, 196, 80);
	gc.drawImage(redFigure, 310, 80);
	gc.drawImage(redFigure, 427, 80);

	gc.drawImage(redFigure, 22, 140);
	gc.drawImage(redFigure, 138, 140);
	gc.drawImage(redFigure, 254, 140);
	gc.drawImage(redFigure, 370, 140);

	Button button = new Button(shell, SWT.PUSH);
	button.setImage(redFigure);

	ImageData img = image.getImageData();

	int x = img.height;
	int y = img.width;

	System.out.println(x + "," + y);

	Image yellowFigure = new Image(display,
	View.class.getResourceAsStream("yellow_normal.jpg"));
	gc.drawImage(yellowFigure, 80, 430);
	gc.drawImage(yellowFigure, 196, 430);
	gc.drawImage(yellowFigure, 312, 430);
	gc.drawImage(yellowFigure, 428, 430);

	gc.drawImage(yellowFigure, 22, 370);
	gc.drawImage(yellowFigure, 138, 370);
	gc.drawImage(yellowFigure, 254, 370);
	gc.drawImage(yellowFigure, 370, 370);

	gc.drawImage(yellowFigure, 80, 310);
	gc.drawImage(yellowFigure, 196, 310);
	gc.drawImage(yellowFigure, 312, 310);
	gc.drawImage(yellowFigure, 428, 310);

	
	for (int i = 0; i < 8; i++)
	   for (int j = 0; j < 8; j++) 
	   {
	    Rectangle r = new Rectangle(BOARD_OFFSET_X + FIGURE_HEIGHT * i,
	    BOARD_OFFSET_Y + FIGURE_WIDTH * j, FIGURE_HEIGHT,
	    FIGURE_WIDTH);

	    if (r.contains(new Point(i, j))) 
	    {
	    // we have clicked on figure (i, j)
	    }
	   }

	shell.addMouseMoveListener(new MouseMoveListener()
	{
	public void mouseMove(MouseEvent arg0) 
	{
	System.out.println(arg0.x + " , " + arg0.y);
	}
	});

	gc.dispose();
	

	shell.setBackgroundImage(image);
	shell.open();
	shell.layout();
	while (!shell.isDisposed()) {
	if (!display.readAndDispatch()) {
	display.sleep();
	}
	}
	}

	Position boardToMousePosition(Position boardPosition) {
	Position p = new Position();
	p.x = BOARD_OFFSET_X + FIGURE_WIDTH * boardPosition.x;
	p.y = BOARD_OFFSET_Y + FIGURE_HEIGHT * boardPosition.y;
	return p;
	}

	Position mouseToBoardPosition(Position mousePosition) {
	Position p = new Position();
	p.x = (mousePosition.x - BOARD_OFFSET_X) / FIGURE_WIDTH;
	p.y = (mousePosition.y - BOARD_OFFSET_Y) / FIGURE_HEIGHT;
	return p;
	}

	/**
	* Create contents of the window.
	*/
	protected void createContents() {
	shell = new Shell();
	shell.setSize(495, 525);
	shell.setText("Checkers Game");

	}

	}