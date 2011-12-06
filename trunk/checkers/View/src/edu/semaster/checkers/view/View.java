package edu.semaster.checkers.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
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

import edu.semaster.checkers.presenter.FigureType;
import edu.semaster.checkers.presenter.IView;
import edu.semaster.checkers.presenter.Presentation;

public class View implements IView {
	static int BOARD_OFFSET_X = 15;
	static int BOARD_OFFSET_Y = 20;
	static int FIGURE_HEIGHT = 60;
	static int FIGURE_WIDTH = 60;

	private Shell shell;
	private FigureType[][] m_board;
	private Image m_boardImage;
	private Image m_redFigure;
	private Image m_yellowFigure;
	private Presentation m_presenter;
	
	private Position m_highlightedPosition = new Position(-1, -1);

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
		
		m_presenter = new Presentation(this);

		shell.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				onClick(new Position(e.x, e.y));
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
					gc.drawImage(m_redFigure, BOARD_OFFSET_X
							+ FIGURE_HEIGHT * j, BOARD_OFFSET_Y
							+ FIGURE_WIDTH * i);

				if (m_board[i][j].getFigureType() == FigureType.Type.WHITE)
					gc.drawImage(m_yellowFigure, BOARD_OFFSET_X
							+ FIGURE_HEIGHT * j, BOARD_OFFSET_Y
							+ FIGURE_WIDTH * i);
			}
		}
		
		if (m_highlightedPosition.getx() != -1)
		{
			gc.setForeground(Display.getDefault().getSystemColor(SWT.COLOR_YELLOW));
			gc.setLineWidth(5);
			gc.drawRectangle(
					BOARD_OFFSET_X
					+ FIGURE_HEIGHT * m_highlightedPosition.getx(), BOARD_OFFSET_Y
					+ FIGURE_WIDTH * m_highlightedPosition.gety(),
					
					
					FIGURE_WIDTH, FIGURE_HEIGHT);
			
			
			
		}
	}
	
	private void onClick(Position position)
	{
		Position pos = mouseToBoardPosition(position);
		if (pos.x >= 0 && pos.x < 8 &&
				pos.y >= 0 && pos.y < 8)
		{
			m_presenter.onBoardPositionClicked(new edu.semaster.checkers.presenter.Point(pos.x, pos.y));
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

	private void initializeBoard() {
		m_board = new FigureType[8][8];
		
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++)
				m_board[i][j] = getDefaultFigure(i, j);//new FigureType(FigureType.Type.NONE);
			
	}

	private FigureType getDefaultFigure(int x, int y) {

		if (x < 3) {
			if (!((x % 2 == 0 && y % 2 != 0)
					|| (x % 2 != 0 && y % 2 == 0))) {
				return new FigureType(FigureType.Type.BLACK);
			}
		}

		if (x > 4) {

			if (!((x % 2 == 0 && y % 2 != 0)
					|| (x % 2 != 0 && y % 2 == 0))) {
				return new FigureType(FigureType.Type.WHITE);
			}
		}

		return new FigureType(FigureType.Type.NONE);
	}

	@Override
	public void setFigurePosition(edu.semaster.checkers.presenter.Point p,
			FigureType type) {
		m_board[p.getX()][p.getY()] = type;
		
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
	public void highlightClickedSquarePosition(
			edu.semaster.checkers.presenter.Point p, boolean highlighted) {
		if (p == null)
		{
			m_highlightedPosition = null;
		}
		m_highlightedPosition = new Position(p.getX(), p.getY());
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearHighlighting() {
		// TODO Auto-generated method stub
		
	}
}
