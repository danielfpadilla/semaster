package edu.semaster.checkers.presentation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.io.ObjectInputStream.GetField;
import java.util.Formatter;

import edu.semaster.checkers.baseproject.FigureType;
import edu.semaster.checkers.baseproject.FigureType.Type;
import edu.semaster.checkers.baseproject.Point;
import edu.semaster.checkers.model.Board;
import edu.semaster.checkers.model.Player;

public class Presenter
{
	private IView m_view;
	private Board m_board = new Board(8, 8);
	FigureType m_type = new FigureType(FigureType.Type.BLACK);
	private Player m_currentPlayer = Player.PLAYER_BLACK;

	// private Formatter output;
	// private Walk walk;

	public static enum FigureChoice
	{
		EXPECTING_FIGURE_SELECTION, EXPECTING_TARGET_LOCATION
	}

	FigureChoice choice = FigureChoice.EXPECTING_FIGURE_SELECTION;
	private Point m_selectedFigure;

	public Presenter(IView view)
	{
		m_view = view;
		m_board.InitializeBoard();
		updateView();
		

		// TODO (Charles): m_view.setStatusMessage("..."); which player
		// to move
		// player is defined in m_player

	}

	public void onBoardPositionClicked(Point p)
	{
		updateView();
		if (choice == FigureChoice.EXPECTING_FIGURE_SELECTION
				&& m_board.getFigureTypeAt(p.x, p.y) != new FigureType(
						FigureType.Type.NONE))
		{

			m_view.highlightClickedSquarePosition(p, true);
			m_selectedFigure = p;

			choice = FigureChoice.EXPECTING_TARGET_LOCATION;

		}

		else if (choice == FigureChoice.EXPECTING_TARGET_LOCATION
				&& m_selectedFigure != null)
		{
			FigureType type = m_board.getFigureTypeAt(
					m_selectedFigure.x, m_selectedFigure.y);

			if ((type != null && type.getFigureType() == FigureType.Type.BLACK)
					 && (m_board.isAValidMove(
							m_selectedFigure, p)) && m_currentPlayer == Player.PLAYER_BLACK )
					
			{
				m_view.highlightClickedSquarePosition(p, true);
				m_board.setFigurePosition(
						m_selectedFigure,
						new FigureType(
								FigureType.Type.NONE));
				m_board.setFigurePosition(p, new FigureType(
						FigureType.Type.BLACK));
				m_currentPlayer = Player.PLAYER_WHITE;

			}

			if ((type != null && type.getFigureType() == FigureType.Type.WHITE)
					 && (m_board.isAValidMove(
							m_selectedFigure, p)) && m_currentPlayer == Player.PLAYER_WHITE)
			{
				m_view.highlightClickedSquarePosition(p, true);
				m_board.setFigurePosition(
						m_selectedFigure,
						new FigureType(
								FigureType.Type.NONE));
				m_board.setFigurePosition(p, new FigureType(
						FigureType.Type.WHITE));
				m_currentPlayer = Player.PLAYER_BLACK;
			}
			if ((type != null && type.getFigureType() == FigureType.Type.WHITE_KING)
					  && (m_board.isAValidMove(
							m_selectedFigure, p)) && m_currentPlayer == Player.PLAYER_WHITE)
					
			{
				m_view.highlightClickedSquarePosition(p, true);
				m_board.setFigurePosition(
						m_selectedFigure,
						new FigureType(
								FigureType.Type.NONE));
				m_board.setFigurePosition(p, new FigureType(
						FigureType.Type.WHITE_KING));
				m_currentPlayer = Player.PLAYER_BLACK;
			}

			if ((type != null && type.getFigureType() == FigureType.Type.BLACK_KING)
					 && (m_board.isAValidMove(
							m_selectedFigure, p)) && m_currentPlayer == Player.PLAYER_BLACK)
					
			{
				m_view.highlightClickedSquarePosition(p, true);
				m_board.setFigurePosition(
						m_selectedFigure,
						new FigureType(
								FigureType.Type.NONE));
				m_board.setFigurePosition(p, new FigureType(
						FigureType.Type.BLACK_KING));
				m_currentPlayer = Player.PLAYER_WHITE;
			}

			m_view.highlightClickedSquarePosition(m_selectedFigure,
					false);
			m_selectedFigure = null;

			choice = FigureChoice.EXPECTING_FIGURE_SELECTION;

		}

		updateView();
		if (m_selectedFigure != null)
		{
			System.out.println("selected = " + m_selectedFigure.x + " "
					+ m_selectedFigure.y);
			
				
		}
		System.out.println("choice = " + choice);
		System.out.println("player = " + m_currentPlayer);
       
		if(m_board.isGameOver())
		{
			System.out.println("Game OVer!!!");
		}

	}

	private void updateView()
	{
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				// take figure from model
				// set figure to view
				m_view.setFigurePosition(new Point(i, j),
						m_board.getFigureTypeAt(i, j));
			}
		}

		m_view.refreshUserInterface();
	}
}
