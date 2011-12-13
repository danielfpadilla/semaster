package edu.semaster.checkers.presentation;

import edu.semaster.checkers.baseproject.FigureType;
import edu.semaster.checkers.model.Board;

public class Presenter{
	private IView m_view;
	private Board m_board = new Board(8, 8);

	public static enum FigureChoice {
		EXPECTING_FIGURE_SELECTION, EXPECTING_TARGET_LOCATION
	}
	
	public static enum Player {
		PLAYER_BLACK, PLAYER_WHITE
	}
	
	FigureChoice choice = FigureChoice.EXPECTING_FIGURE_SELECTION;
	private Point m_selectedFigure;;


	Player currentPlayer = Player.PLAYER_BLACK;
	public Presenter(IView view)
	{
		m_view = view;
		m_board.InitializeBoard();
		updateView();

		// TODO (Charles): m_view.setStatusMessage("..."); which player to move
		// player is defined in m_player
	}

	public void onBoardPositionClicked(Point p)
	{
		if (choice == FigureChoice.EXPECTING_FIGURE_SELECTION)
		{
			// TODO (Hussein): check that you select a valid figure
			
			// TODO (Joan): check that we are moving figure of the current player
			
			m_selectedFigure = p;
			m_view.highlightClickedSquarePosition(p, true);
			
			choice = FigureChoice.EXPECTING_TARGET_LOCATION;
			
			// TODO (Charles): m_view.setStatusMessage("...");
		}
		
		else if (choice == FigureChoice.EXPECTING_TARGET_LOCATION &&
			m_selectedFigure != null) 
		{
			// TODO: check that target location is correct

			// TODO: instead update m_board only
			// m_board.setFigurePosition(m_selectedFigure, new FigureType(FigureType.Type.NONE));
			// m_board.setFigurePosition(p, new FigureType(FigureType.Type.BLACK));
			// instead of this:
			m_view.setFigurePosition(m_selectedFigure, new FigureType(FigureType.Type.NONE));
			m_view.setFigurePosition(p, new FigureType(FigureType.Type.BLACK));
			
			m_view.highlightClickedSquarePosition(m_selectedFigure, false);
			m_selectedFigure = null;
			
			choice = FigureChoice.EXPECTING_FIGURE_SELECTION;
			
			// TODO (Joan):
			// change player by changing value of m_player

			// TODO (Charles): m_view.setStatusMessage("..."); which player to move
		}

		// TODO: call updateView instead
		m_view.refreshUserInterface();
	}

	private void updateView() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Point p = new Point(i,j);
			//	m_view.setFigurePosition( p , m_board.getDefaultFigure(i, j));
				// take figure from model
				// set figure to view

				// TODO:
				// m_view.setFigurePosition(new Point(i, j), m_board.getFigureAt(i, j));
			}
		}

		m_view.refreshUserInterface();
	}
}
