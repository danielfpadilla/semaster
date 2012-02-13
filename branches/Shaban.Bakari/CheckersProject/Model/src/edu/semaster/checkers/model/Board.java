package edu.semaster.checkers.model;

import edu.semaster.checkers.baseproject.FigureType;
import edu.semaster.checkers.baseproject.FigureType.Type;
import edu.semaster.checkers.baseproject.Point;

public class Board
{
	private final FigureType[][] pieces;

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
		return new FigureType(FigureType.Type.NONE);

	}

	public void setFigurePosition(Point p, FigureType type)
	{
		pieces[p.getY()][p.getX()] = type;

	}

	public boolean isAValidWalk(Point source, Point destination)
	{
		if (!isPositionPainted(source.getX(), source.getY()))
			return false;

		if (!(getFigureTypeAt(destination.getX(), destination.getY())
				.getFigureType() == Type.NONE))
			return false;
		if (Math.abs(source.getY() - destination.getY()) == 1)
		{

			if (getFigureTypeAt(source.getX(), source.getY())
					.getFigureType() == Type.WHITE)
			{
				if (!((source.getX() == destination.getX() - 1 && source
						.getY() == destination.getY() + 1) || (source
						.getX() == destination.getX() + 1 && source
						.getY() == destination.getY() + 1)))
					return false;
			}

			else
			{
				if (getFigureTypeAt(source.getX(),
						source.getY()).getFigureType() == Type.BLACK)
				{
					if (!((source.getX() == destination
							.getX() + 1 && source
							.getY() == destination
							.getY() - 1) || (source
							.getX() == destination
							.getX() - 1 && source
							.getY() == destination
							.getY() - 1)))
						return false;
				}
			}
		}

		{
			if (Math.abs(source.getY() - destination.getY()) > 1)
			{
				if (getFigureTypeAt(source.getX(),
						source.getY()).getFigureType() == Type.WHITE)
				{
					if ((getFigureTypeAt((source.getX() + destination.getX())/2,
							(source.getY() + destination.getY())/2)
							.getFigureType() == Type.WHITE))
						return false;

					/*
					 * if(((source.getX() ==
					 * destination.getX()+2 && source.getY()
					 * == destination.getY()+2) ||
					 * (source.getX() ==
					 * destination.getX()-2 && source.getY()
					 * ==destination.getY()+2))&&
					 * ((getFigureTypeAt(source.getX()+1,
					 * source
					 * .getY()-1).getFigureType()==Type
					 * .BLACK) ||
					 * (getFigureTypeAt(source.getX()-1,
					 * source
					 * .getY()-1).getFigureType()==Type
					 * .BLACK))) { return true; }
					 */

					if ((source.getX() == destination
							.getX() + 2 && source
							.getY() == destination
							.getY() + 2)
							|| (source.getX() == destination
									.getX() - 2 && source
									.getY() == destination
									.getY() + 2))
					{
						if ((getFigureTypeAt(
								source.getX() + 1,
								source.getY() - 1)
								.getFigureType() == Type.BLACK))
						{
							Point p = new Point(
									source.getX() + 1,
									source.getY() - 1);
							setFigurePosition(
									p,
									new FigureType(
											Type.NONE));
							return true;
						}
						else if ((getFigureTypeAt(
								source.getX() - 1,
								source.getY() - 1)
								.getFigureType() == Type.BLACK))
						{
							Point p = new Point(
									source.getX() - 1,
									source.getY() - 1);
							setFigurePosition(
									p,
									new FigureType(
											Type.NONE));
							return true;

						}
						return false;
					}
				}

				else
				{
					if (getFigureTypeAt(source.getX(),
							source.getY())
							.getFigureType() == Type.BLACK)
					{
						if ((getFigureTypeAt(
								(source.getX() + destination.getX())/2,
								(source.getY() + destination.getY())/2)
								.getFigureType() == Type.BLACK))
							return false;

						if ((source.getX() == destination
								.getX() + 2 && source
								.getY() == destination
								.getY() - 2)
								|| (source.getX() == destination
										.getX() - 2 && source
										.getY() == destination
										.getY() - 2))
						{
							if (getFigureTypeAt(
									source.getX() + 1,
									source.getY() + 1)
									.getFigureType() == Type.WHITE)
							{
								Point p = new Point(
										source.getX() + 1,
										source.getY() + 1);
								setFigurePosition(
										p,
										new FigureType(
												Type.NONE));
								return true;
							}
							else if (getFigureTypeAt(
									source.getX() - 1,
									source.getY() + 1)
									.getFigureType() == Type.WHITE)
							{
								Point p = new Point(
										source.getX() - 1,
										source.getY() + 1);
								setFigurePosition(
										p,
										new FigureType(
												Type.NONE));
								return true;
							}

							return false;
						}
					}
				}
			}
		}
		return true;
	}
}
