package edu.semaster.checkers.view;
import edu.semaster.checkers.baseProject.Piece;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;


import edu.semaster.checkers.presentatation.IView;
import edu.semaster.checkers.presentatation.Point;
import edu.semaster.checkers.presentatation.Presenter;


public class View implements IView {
	static int BOARD_OFFSET_X = 15;
	static int BOARD_OFFSET_Y = 20;
	static int FIGURE_HEIGHT = 60;
	static int FIGURE_WIDTH = 60;

	private Shell shell;
	private Piece[][] m_board = new Piece[8][8];;
	private Image m_boardImage;
	private Image m_redFigure;
	private Image m_yellowFigure;
	private Presenter m_presenter;
	
	private Point m_highlightedPosition = new Point(-1, -1);

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
				
		m_presenter = new Presenter(this);

		shell.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				onClick(new Point(e.x, e.y));
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

				if (m_board[i][j].getColor() == Piece.Color.BLACK)
					gc.drawImage(m_redFigure, BOARD_OFFSET_X
							+ FIGURE_HEIGHT * j, BOARD_OFFSET_Y
							+ FIGURE_WIDTH * i);

				if (m_board[i][j].getColor() == Piece.Color.WHITE)
					gc.drawImage(m_yellowFigure, BOARD_OFFSET_X
							+ FIGURE_HEIGHT * j, BOARD_OFFSET_Y
							+ FIGURE_WIDTH * i);
			}
		}
		
		if (m_highlightedPosition.getX() != -1)
		{
			gc.setForeground(Display.getDefault().getSystemColor(SWT.COLOR_YELLOW));
			gc.setLineWidth(5);
			gc.drawRectangle(
					BOARD_OFFSET_X
					+ FIGURE_HEIGHT * m_highlightedPosition.getX(), BOARD_OFFSET_Y
					+ FIGURE_WIDTH * m_highlightedPosition.getY(),
					
					
					FIGURE_WIDTH, FIGURE_HEIGHT);
			
			
			
		}
	}
	
	private void onClick(Point position)
	{
		Point pos = mouseToBoardPosition(position);
		if (pos.x >= 0 && pos.x < 8 &&
				pos.y >= 0 && pos.y < 8)
		{
			m_presenter.onBoardPositionClicked(new Point(pos.x, pos.y));
		}
	}

	private Point boardToMousePosition(Point boardPosition) {
		Point p = new Point();
		p.setPoint(BOARD_OFFSET_X + FIGURE_WIDTH * boardPosition.x,
				BOARD_OFFSET_Y + FIGURE_HEIGHT * boardPosition.y);
		return p;
	}

	private Point mouseToBoardPosition(Point mousePosition) {
		Point p = new Point();
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
	
	private void loadFigures(Display display)
	{
		m_boardImage = new Image(display,
				View.class.getResourceAsStream("board.jpg"));

		m_redFigure = new Image(display,
				View.class.getResourceAsStream("red_normal.jpg"));
		m_yellowFigure = new Image(display,
				View.class.getResourceAsStream("yellow_normal.jpg"));
		
		ImageData data = m_redFigure.getImageData();
	}

	
	@Override
	public void setFigurePosition(Point p,
			Piece color) {
		m_board[p.getX()][p.getY()] = color;
		
	}

	@Override
	public void refreshUserInterface() {
		shell.redraw();
		shell.update();
		
	}

	@Override
	public void setStatusMessage(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void highlightClickedSquarePosition(Point p, boolean highlighted) {
		if (p == null)
		{
			m_highlightedPosition = null;
		}
		m_highlightedPosition = new Point(p.getX(), p.getY());
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearHighlighting() {
		// TODO Auto-generated method stub
		
	}
}
