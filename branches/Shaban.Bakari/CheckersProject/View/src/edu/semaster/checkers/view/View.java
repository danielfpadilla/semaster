package edu.semaster.checkers.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
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
	private Image m_yellow_kingFigure;
	private Image m_red_kingFigure;
	private Presenter m_presenter;

	private Position m_highlightedPosition = new Position(-1, -1);

	public static void main(String[] args)
	{
		try
		{
			View window = new View();
			window.open();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void open()
	{

		Display display = Display.getDefault();
		createContents();
		loadFigures(display);
		initializeBoard();

		// TODO (Charles): initialize the menu as a separate method
		// initializeMenu();

		m_presenter = new Presenter(this);

		shell.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseDown(MouseEvent e)
			{
				Position boardPos = mouseToBoardPosition(new Position(
						e.x, e.y));
				m_presenter.onBoardPositionClicked(new Point(
						boardPos.getx(), boardPos
								.gety()));
			}
		});

		shell.addListener(SWT.Paint, new Listener()
		{
			public void handleEvent(Event event)
			{
				paintBoard(event.gc);
			}
		});

		shell.setBackgroundImage(m_boardImage);
		shell.open();
		shell.layout();
		while (!shell.isDisposed())
		{
			if (!display.readAndDispatch())
			{
				display.sleep();
			}
		}
	}

	private void paintBoard(GC gc)
	{
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{

				if (m_board[i][j].getFigureType() == FigureType.Type.BLACK)
					gc.drawImage(m_redFigure,
							BOARD_OFFSET_X
									+ FIGURE_HEIGHT
									* j,
							BOARD_OFFSET_Y
									+ FIGURE_WIDTH
									* i);

				if (m_board[i][j].getFigureType() == FigureType.Type.WHITE)
					gc.drawImage(m_yellowFigure,
							BOARD_OFFSET_X
									+ FIGURE_HEIGHT
									* j,
							BOARD_OFFSET_Y
									+ FIGURE_WIDTH
									* i);
				
				if (m_board[i][j].getFigureType() == FigureType.Type.WHITE_KING)
					gc.drawImage(m_yellow_kingFigure,
							BOARD_OFFSET_X
									+ FIGURE_HEIGHT
									* j,
							BOARD_OFFSET_Y
									+ FIGURE_WIDTH
									* i);
				
				if (m_board[i][j].getFigureType() == FigureType.Type.BLACK_KING)
					gc.drawImage(m_red_kingFigure,
							BOARD_OFFSET_X
									+ FIGURE_HEIGHT
									* j,
							BOARD_OFFSET_Y
									+ FIGURE_WIDTH
									* i);
			}
		}

		if (m_highlightedPosition != null
				&& m_highlightedPosition.getx() != -1
				&& m_highlightedPosition.gety() != -1)
		{
			gc.setForeground(Display.getDefault().getSystemColor(
					SWT.COLOR_YELLOW));
			gc.setLineWidth(5);
			gc.drawRectangle(
					BOARD_OFFSET_X
							+ FIGURE_HEIGHT
							* m_highlightedPosition
									.getx(),
					BOARD_OFFSET_Y
							+ FIGURE_WIDTH
							* m_highlightedPosition
									.gety(),
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
		try
		{
		p.x = (mousePosition.x - BOARD_OFFSET_X) / FIGURE_WIDTH;
		p.y = (mousePosition.y - BOARD_OFFSET_Y) / FIGURE_HEIGHT;
		
		return p;
		}
		catch(IndexOutOfBoundsException exception)
		{
			exception.printStackTrace();
		       return null;
		}
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

		m_redFigure = new Image(
				display,
				View.class.getResourceAsStream("red_normal.jpg"));
		m_yellowFigure = new Image(
				display,
				View.class.getResourceAsStream("yellow_normal.jpg"));
		m_yellow_kingFigure = new Image(
				display,
				View.class.getResourceAsStream("yellow_king.jpg"));
		m_red_kingFigure = new Image(
				display,
				View.class.getResourceAsStream("red_king.jpg"));
	}

	private void initializeBoard()
	{
		m_board = new FigureType[8][8];

		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++)
				m_board[i][j] = getDefaultFigure(i, j);// new
		// System.out.printf("(%d, %d) %s figure", i, j,
		// getDefaultFigure(i, j).getFigureType());

		// FigureType(FigureType.Type.NONE);

	}

	private FigureType getDefaultFigure(int x, int y)
	{

		if (x < 3)
		{
			if (((x % 2 == 0 && y % 2 != 0) || (x % 2 != 0 && y % 2 == 0)))
			{
				return new FigureType(FigureType.Type.BLACK);
			}
		}

		if (x > 4)
		{

			if (((x % 2 == 0 && y % 2 != 0) || (x % 2 != 0 && y % 2 == 0)))
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
		}
		else
		{
			m_highlightedPosition = null;
		}
	}

	@Override
	public void clearHighlighting()
	{
		// TODO Auto-generated method stub

	}

}
