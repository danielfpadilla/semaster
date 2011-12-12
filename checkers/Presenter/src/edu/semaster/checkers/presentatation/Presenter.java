package edu.semaster.checkers.presentatation;

import edu.semaster.checkers.model.Board;

public class Presenter{
	private IView m_view;
	private Board m_board = new Board(8, 8);
	

	public Presenter(IView view)
	{
		m_view = view;
		m_board.InitializeBoard();
		updateView();
	}


	public void onBoardPositionClicked(Point p) {
		
		System.out.println(p.x + "x" + p.y);
		
		m_view.highlightClickedSquarePosition(p, true);
	    m_view.refreshUserInterface();
		
	}
	
	private void updateView()
	{
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				Point p = new Point(i,j);
				m_view.setFigurePosition( p , m_board.getDefaultFigure(i, j));
				// take figure from model
				// set figure to view
			}
		}
		
		m_view.refreshUserInterface();
	}


	
}
