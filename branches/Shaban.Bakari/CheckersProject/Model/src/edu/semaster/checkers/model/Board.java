package edu.semaster.checkers.model;

import edu.semaster.checkers.baseproject.FigureType;
import edu.semaster.checkers.baseproject.FigureType.Type;
import edu.semaster.checkers.baseproject.Point;

public class Board
{
	private final FigureType[][] pieces;
	private Player currentPlayer = Player.PLAYER_BLACK;

	public Board(final int rowCount, final int columnCount)
	{
		if (rowCount <= 0 || columnCount <= 0)
			throw new IllegalArgumentException();
		this.pieces = new FigureType[rowCount][columnCount];
	}

	public void InitializeBoard()
	{
		for (int i = 0; i < 8; i++)
		{

			for (int j = 0; j < 8; j++)
			{
				if (isPositionPainted(i, j) == true)
				{
					if (i < 3)
						pieces[i][j] = new FigureType(
								FigureType.Type.BLACK);
					else if (i > 2 && i < 5)
						pieces[i][j] = new FigureType(
								FigureType.Type.NONE);
					else
						pieces[i][j] = new FigureType(
								FigureType.Type.WHITE);

				}
			}
		}
	}

	public boolean isPositionPainted(int i, int j)
	{
		if ((i % 2 == 0 && j % 2 != 0) || (i % 2 != 0 && j % 2 == 0))
		{

			return true;

		}
		else
		{
			return false;
		}

	}

	public FigureType getDefaultFigure(int x, int y)
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

	public FigureType getFigureTypeAt(int y, int x)
	{
		if (pieces[x][y] == null)
			return new FigureType(FigureType.Type.NONE);

		if (pieces[x][y].getFigureType() == FigureType.Type.BLACK)
			return new FigureType(FigureType.Type.BLACK);

		if (pieces[x][y].getFigureType() == FigureType.Type.WHITE)
			return new FigureType(FigureType.Type.WHITE);

		if (pieces[x][y].getFigureType() == FigureType.Type.BLACK_KING)
			return new FigureType(FigureType.Type.BLACK_KING);

		if (pieces[x][y].getFigureType() == FigureType.Type.WHITE_KING)
			return new FigureType(FigureType.Type.WHITE_KING);

		return new FigureType(FigureType.Type.NONE);

	}

	public void setFigurePosition(Point p, FigureType type)
	{
		pieces[p.getY()][p.getX()] = type;

		if (type.equals(Type.BLACK))
		{
			currentPlayer = Player.PLAYER_BLACK;
			System.out.println("type -->  RED");
		}
		else if (type.equals(Type.BLACK_KING))
		{
			currentPlayer = Player.PLAYER_BLACK;
			System.out.println("type -->  RED_KING");
		}
		else if (type.equals(Type.WHITE))
		{
			currentPlayer = Player.PLAYER_WHITE;
			System.out.println("type -->  YELLOW");
		}
		else if (type.equals(Type.WHITE_KING))
		{
			currentPlayer = Player.PLAYER_WHITE;
			System.out.println("type -->  YELLOW_KING");
		}
		
		

	}

	public boolean isAValidMove(Point source, Point destination)
	{
		boolean result = isAValidMoveInternal(source, destination);
		System.out.println("valid = " + result);
		return result;
	}
	public boolean isAValidMoveInternal(Point source, Point destination)
	{
		
		
		if (!isPositionPainted(source.getX(), source.getY()))
			return false;
		
		if((getFigureTypeAt(source.getX(), source.getY())
				.getFigureType() == Type.WHITE) && source.getY()==0 )
		{
			changePawnToKing(source);
			System.out.println("changePawnToKing method has been called ");
			return true;
		}
		
		if((getFigureTypeAt(source.getX(), source.getY())
				.getFigureType() == Type.BLACK) && source.getY()==7)
		{
			changePawnToKing(source);
			System.out.println("changePawnToKing method has been called ");
			return true;
		}

		if (!(getFigureTypeAt(destination.getX(), destination.getY())
				.getFigureType() == Type.NONE))
			return false;
		

		if (getFigureTypeAt(source.getX(), source.getY())
				.getFigureType() == Type.WHITE && currentPlayer==Player.PLAYER_WHITE)
		{
			if ((source.getX() == destination.getX() + 1 && source
					.getY() == destination.getY() + 1)
					|| (source.getX() == destination.getX() - 1 && source
							.getY() == destination
							.getY() + 1))
			{
				currentPlayer=Player.PLAYER_BLACK;
				return true;
			}

			if ((source.getX() == destination.getX() + 2 && source
					.getY() == destination.getY() + 2)
					|| (source.getX() == destination.getX() - 2 && source
							.getY() == destination
							.getY() + 2))
			{
				
				pawnJumpMove(source, destination);				
				currentPlayer=Player.PLAYER_BLACK;
				return true;

			}
			
			return false;	
		}
		
		else if (getFigureTypeAt(source.getX(), source.getY())
				.getFigureType() == Type.BLACK && currentPlayer==Player.PLAYER_BLACK)
		{
			if ((source.getX() == destination.getX() + 1 && source
					.getY() == destination.getY() - 1)
					|| (source.getX() == destination.getX() - 1 && source
							.getY() == destination
							.getY() - 1))
			{
				currentPlayer=Player.PLAYER_WHITE;
				return true;
			}

			if ((source.getX() == destination.getX() + 2 && source
					.getY() == destination.getY() - 2)
					|| (source.getX() == destination.getX() - 2 && source
							.getY() == destination
							.getY() - 2))
			{
				
				pawnJumpMove(source, destination);
				currentPlayer=Player.PLAYER_WHITE;
				return true;	
			}
			
			return false;

		}
		
		else if (getFigureTypeAt(source.getX(), source.getY())
				.getFigureType() == Type.BLACK_KING && currentPlayer==Player.PLAYER_BLACK)
		{

		if (getFigureTypeAt(source.getX(), source.getY())
				.getFigureType() == Type.BLACK_KING
				&& (Math.abs(source.getX() - destination.getX()) == 1 && Math
						.abs(source.getY()
								- destination.getY()) == 1))
		{
			currentPlayer=Player.PLAYER_WHITE;
			return true;
		}

		if (getFigureTypeAt(source.getX(), source.getY())
				.getFigureType() == Type.BLACK_KING
				&& (Math.abs(source.getX() - destination.getX()) > 1 && Math
						.abs(source.getY()
								- destination.getY()) > 1))
		{
			
			kingJumpMove(source, destination);
			currentPlayer=Player.PLAYER_WHITE;
			return true;		
		}
		return false;
		}
		
		else if (getFigureTypeAt(source.getX(), source.getY())
				.getFigureType() == Type.WHITE_KING && currentPlayer==Player.PLAYER_WHITE)
		{

		if (getFigureTypeAt(source.getX(), source.getY())
				.getFigureType() == Type.WHITE_KING
				&& (Math.abs(source.getX() - destination.getX()) == 1 && Math
						.abs(source.getY()
								- destination.getY()) == 1))
		{
			currentPlayer=Player.PLAYER_BLACK;
			return true;
		}
		if (getFigureTypeAt(source.getX(), source.getY())
				.getFigureType() == Type.WHITE_KING
				&& (Math.abs(source.getX() - destination.getX()) > 1 && Math
						.abs(source.getY()
								- destination.getY()) > 1))
		{
			
				kingJumpMove(source, destination);
				currentPlayer=Player.PLAYER_BLACK;
				return true;
		}

		return false;
		}
		return true;
	}
	
	
	private void changePawnToKing(Point p)
	{
		if(p.getY()==0)
		{
			Point myPoint = new Point(p.getX(),
					p.getY());
			setFigurePosition(myPoint, new FigureType(
					Type.WHITE_KING));
			System.out.println("set position is called");
			
		}
		else if(p.getY()==7)
		{
			Point myPoint = new Point(p.getX(),
					p.getY());
			setFigurePosition(myPoint, new FigureType(
					Type.BLACK_KING));
			System.out.println("set position is called");
		}
		
	}
	
	public void pawnJumpMove(Point source, Point destination)
	{
		if (getFigureTypeAt(source.getX(), source.getY())
				.getFigureType() == Type.WHITE)
		{
			

			if (getFigureTypeAt(
					(source.getX() + destination
							.getX()) / 2,
					(source.getY() + destination
							.getY()) / 2)
					.getFigureType() == Type.BLACK
					|| getFigureTypeAt(
							(source.getX() + destination
									.getX()) / 2,
							(source.getY() + destination
									.getY()) / 2)
							.getFigureType() == Type.BLACK_KING)
			{
				
				Point p = new Point(
						(source.getX() + destination
								.getX()) / 2,
						(source.getY() + destination
								.getY()) / 2);
				setFigurePosition(p, new FigureType(
						Type.NONE));
				
			}
		
		}
		
		else if (getFigureTypeAt(source.getX(), source.getY())
				.getFigureType() == Type.BLACK)
		{
			
			if (getFigureTypeAt(
					(source.getX() + destination
							.getX()) / 2,
					(source.getY() + destination
							.getY()) / 2)
					.getFigureType() == Type.WHITE
					|| getFigureTypeAt(
							(source.getX() + destination
									.getX()) / 2,
							(source.getY() + destination
									.getY()) / 2)
							.getFigureType() == Type.WHITE_KING)
			{
				Point p = new Point(
						(source.getX() + destination
								.getX()) / 2,
						(source.getY() + destination
								.getY()) / 2);
				
				setFigurePosition(p, new FigureType(
						Type.NONE));	
				
			}
		
		}
		
	}
	
	public void kingJumpMove(Point source, Point destination)
	{
		if (getFigureTypeAt(source.getX(), source.getY())
				.getFigureType() == Type.BLACK_KING)
		{
			if (getFigureTypeAt(
					(source.getX() + destination.getX()) / 2,
					(source.getY() + destination.getY()) / 2)
					.getFigureType() == Type.WHITE_KING
					|| getFigureTypeAt(
							(source.getX() + destination
									.getX()) / 2,
							(source.getY() + destination
									.getY()) / 2)
							.getFigureType() == Type.WHITE)
			{
				Point p = new Point(
						(source.getX() + destination
								.getX()) / 2,
						(source.getY() + destination
								.getY()) / 2);
				
				setFigurePosition(p, new FigureType(Type.NONE));
				
				
			}
		}
		else if (getFigureTypeAt(source.getX(), source.getY())
				.getFigureType() == Type.WHITE_KING)
		{
			if (getFigureTypeAt(
					(source.getX() + destination.getX()) / 2,
					(source.getY() + destination.getY()) / 2)
					.getFigureType() == Type.BLACK_KING
					|| getFigureTypeAt(
							(source.getX() + destination
									.getX()) / 2,
							(source.getY() + destination
									.getY()) / 2)
							.getFigureType() == Type.BLACK)
			{
				Point p = new Point(
						(source.getX() + destination
								.getX()) / 2,
						(source.getY() + destination
								.getY()) / 2);
				
				setFigurePosition(p, new FigureType(Type.NONE));
				
				
			}
		}
			
	}

	public boolean isGameOver()
	{
		int redFigures = 0, yellowFigures = 0;
		for (int i = 0; i < 8; i++)
		{

			for (int j = 0; j < 8; j++)
			{
				if(getFigureTypeAt(i, j).getFigureType()==Type.BLACK)
					redFigures++;
				else if(getFigureTypeAt(i, j).getFigureType()==Type.BLACK_KING)
					redFigures++;
				else if(getFigureTypeAt(i, j).getFigureType()==Type.WHITE)
					yellowFigures++;
				else if(getFigureTypeAt(i, j).getFigureType()==Type.WHITE_KING)
					yellowFigures++;
			}
		}
		
		if(redFigures==0)
		{
			System.out.println("Yellow won!");
			return true;
		}
		else if(yellowFigures==0)
		{
			System.out.println("Red won");
			return true;
		}
		
		
		return false;
	}
}
